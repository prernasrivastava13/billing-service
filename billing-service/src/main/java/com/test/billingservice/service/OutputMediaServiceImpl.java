package com.test.billingservice.service;

import com.querydsl.core.types.Predicate;
import com.test.billingservice.dao.OutputMediaRepository;
import com.test.billingservice.entity.AccountApplicationMapping;
import com.test.billingservice.entity.AccountApplicationUsageLimits;
import com.test.billingservice.entity.CreditInformation;
import com.test.billingservice.entity.OutputMedia;
import com.test.billingservice.predicate.OutputMediaPredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class OutputMediaServiceImpl implements OutputMediaService {

	@Resource
	OutputMediaRepository outputMediaRepository;
	@Resource
	CreditInformationServiceImpl creditInformationService;
	@Resource
	AccountApplicationMappingService accountApplicationMappingService;
	@Resource
	AccountApplicationUsageLimitsService accountApplicationUsageLimitsService;

	@Override
	public OutputMedia createOutputMedia(OutputMedia outputMedia) {
		CreditInformation creditInformation = creditInformationService
				.getCreditInformationByApiId(outputMedia.getApplicationId());
		int creditsConsumed = calculateCreditsConsumed(outputMedia.getSize(), creditInformation);
		outputMedia.setCreditsConsumed(creditsConsumed);
		OutputMedia createdOutputMedia = outputMediaRepository.save(outputMedia);

		if (createdOutputMedia != null) {
			AccountApplicationMapping accountApplicationMapping = accountApplicationMappingService
					.getAccountApplicationMappingByAccountIdAndApplicationId(createdOutputMedia.getAccountId(),
							createdOutputMedia.getApplicationId());
			if (accountApplicationMapping != null) {
				AccountApplicationUsageLimits accountApplicationUsageLimits = accountApplicationUsageLimitsService
						.getAccountApplicationUsageLimitsByMappingId(accountApplicationMapping.getId());
				String curentmonth = "" + Calendar.getInstance().get(Calendar.MONTH) + 1;
				if (accountApplicationUsageLimits != null && accountApplicationUsageLimits.getMonth() == curentmonth) {
					int initialCredits = accountApplicationUsageLimits.getCreditUsed();
					accountApplicationUsageLimits.setCreditUsed(initialCredits + creditsConsumed);
					accountApplicationMappingService.updateAccountApplicationMapping(accountApplicationMapping);
				}
				accountApplicationUsageLimits.setMonth(curentmonth);
				accountApplicationUsageLimits.getAccountApplicationMapping().setId(accountApplicationMapping.getId());
				accountApplicationUsageLimits.setCreditUsed(creditsConsumed);
			}
			log.error("No account application mapping found for account id: " + createdOutputMedia.getAccountId()
					+ " and applicationId: " + createdOutputMedia.getApplicationId());
			// accountApplicationMapping.setAccountId(outputMedia.getAccountId());
			// accountApplicationMapping.setApplicationId(outputMedia.getApplicationId());
			// accountApplicationMapping.setActive(true);
			// AccountApplicationMapping createdAccountApplicationMapping =
			// accountApplicationMappingService.createAccountApplicationMapping(
			// accountApplicationMapping);
			return createdOutputMedia;
		}
		log.info("Error creating output media entry");
		return null;
	}

	@Override
	public List<OutputMedia> getOutputMediaList() {
		return outputMediaRepository.findAll();
	}

	@Override
	public List<OutputMedia> getOutputMediaByMediaId(int mediaId) {
		return StreamSupport.stream(
				outputMediaRepository.findAll(OutputMediaPredicate.getOutputMediaByMediaId(mediaId)).spliterator(),
				false).collect(Collectors.toList());
	}

	@Override
	public List<OutputMedia> getOutputMediaByAccountId(int accountId) {
		return StreamSupport.stream(
				outputMediaRepository.findAll(OutputMediaPredicate.getOutputMediaByAccountId(accountId)).spliterator(),
				false).collect(Collectors.toList());
	}

	@Override
	public List<OutputMedia> getOutputMediaBySize(int minSize, int maxSize) {
		return StreamSupport.stream(outputMediaRepository
				.findAll(OutputMediaPredicate.getOutputMediaBySize(minSize, maxSize)).spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public List<OutputMedia> getOutputMediaByApi(String api) {
		return StreamSupport
				.stream(outputMediaRepository.findAll(OutputMediaPredicate.getOutputMediaByApi(api)).spliterator(),
						false)
				.collect(Collectors.toList());
	}

	@Override
	public List<OutputMedia> getOutputMediaByCreditConsumed(int minCreditsConsumed, int maxCreditsConsumed) {
		return StreamSupport.stream(outputMediaRepository
				.findAll(OutputMediaPredicate.getOutputMediaCreditConsumed(minCreditsConsumed, maxCreditsConsumed))
				.spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public List<OutputMedia> getOutputMediaByApplicationId(int applicationId) {
		return StreamSupport.stream(outputMediaRepository
				.findAll(OutputMediaPredicate.getOutputMediaApplicationId(applicationId)).spliterator(), false)
				.collect(Collectors.toList());
	}

	private int calculateCreditsConsumed(int fileSize, CreditInformation creditInformation) {
		int creditsConsumed = 0;
		while (fileSize > creditInformation.getPerCreditFileSize()) {
			creditsConsumed++;
			fileSize = fileSize - creditInformation.getPerCreditFileSize();
		}
		if (fileSize > 0) {
			creditsConsumed++;
		}
		return creditsConsumed;
	}
}
