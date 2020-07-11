package com.test.billingservice.controller;

import com.test.billingservice.entity.OutputMedia;
import com.test.billingservice.service.OutputMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RequestMapping("/billingService/outputMedia")
@RestController
public class OutputMediaController {

  @Resource OutputMediaService outputMediaService;

  @PostMapping("/create")
  public OutputMedia createOutputMedia(@RequestBody OutputMedia outputMedia) {
    OutputMedia createdOutputMedia = outputMediaService.createOutputMedia(outputMedia);
    return createdOutputMedia;
  }

  @GetMapping("/view/byAccountId/{accountId}")
  public List<OutputMedia> getOutputMediaByAccountId(@PathVariable int accountId) {
    return outputMediaService.getOutputMediaByAccountId(accountId);
  }

  @GetMapping("/view/byApi/{api}")
  public List<OutputMedia> getOutputMediaByApi(@PathVariable String api) {
    return outputMediaService.getOutputMediaByApi(api);
  }

  @GetMapping("/view/byApplicationId/{applicationId}")
  public List<OutputMedia> getOutputMediaByApplicationid() {
    List<OutputMedia> outputMediaList = outputMediaService.getOutputMediaList();
    if (!outputMediaList.isEmpty()) return outputMediaList;
    log.info("Output Media List empty");
    return null;
  }

  @GetMapping("/view/byCreditsConsumed/{minCreditsConsumed}/{maxCreditsConsumed}")
  public List<OutputMedia> getOutputMediaByCreditsConsumed() {
    List<OutputMedia> outputMediaList = outputMediaService.getOutputMediaList();
    if (!outputMediaList.isEmpty()) return outputMediaList;
    log.info("Output Media List empty");
    return null;
  }

  @GetMapping("/view/bySize/{size}")
  public List<OutputMedia> getOutputMediaBySize() {
    List<OutputMedia> outputMediaList = outputMediaService.getOutputMediaList();
    if (!outputMediaList.isEmpty()) return outputMediaList;
    log.info("Output Media List empty");
    return null;
  }
}
