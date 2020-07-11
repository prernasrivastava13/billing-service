package com.test.billingservice.service;

import com.test.billingservice.entity.OutputMedia;

import java.util.List;

public interface OutputMediaService {

  public OutputMedia createOutputMedia(OutputMedia outputMedia);

  public List<OutputMedia> getOutputMediaList();

  public List<OutputMedia> getOutputMediaByMediaId(int mediaId);

  public List<OutputMedia> getOutputMediaByAccountId(int accountId);

  public List<OutputMedia> getOutputMediaBySize(int minSize, int maxSize);

  public List<OutputMedia> getOutputMediaByApi(String api);

  public List<OutputMedia> getOutputMediaByCreditConsumed(
      int minCreditsConsumed, int maxCreditsConsumed);

  public List<OutputMedia> getOutputMediaByApplicationId(int applicationId);
}
