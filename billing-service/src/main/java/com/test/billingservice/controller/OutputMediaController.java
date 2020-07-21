package com.test.billingservice.controller;

import com.test.billingservice.entity.OutputMedia;
import com.test.billingservice.service.OutputMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Slf4j
@RequestMapping("/billingService/outputMedia")
@RestController
public class OutputMediaController {

  @Resource OutputMediaService outputMediaService;

  @PostMapping("/create")
  public ResponseEntity<OutputMedia> createOutputMedia(@RequestBody OutputMedia outputMedia) {
    OutputMedia createdOutputMedia = outputMediaService.createOutputMedia(outputMedia);
    if (createdOutputMedia == null) {
      ResponseEntity.badRequest().build();
    }
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{outputMediaId}")
            .buildAndExpand(createdOutputMedia.getId())
            .toUri();
    return ResponseEntity.created(uri).body(createdOutputMedia);
  }

  @GetMapping("/view/byAccountId/{accountId}")
  public ResponseEntity<List<OutputMedia>> getOutputMediaByAccountId(@PathVariable int accountId) {
    List<OutputMedia> outputMediaList = outputMediaService.getOutputMediaByAccountId(accountId);
    return CollectionUtils.isEmpty(outputMediaList)
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(outputMediaList);
  }

  @GetMapping("/view/byApi/{api}")
  public ResponseEntity<List<OutputMedia>> getOutputMediaByApi(@PathVariable String api) {
    List<OutputMedia> outputMediaList = outputMediaService.getOutputMediaByApi(api);
    return CollectionUtils.isEmpty(outputMediaList)
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(outputMediaList);
  }

  @GetMapping("/view/byApplicationId/{applicationId}")
  public ResponseEntity<List<OutputMedia>> getOutputMediaByApplicationid(
      @PathVariable int applicationId) {
    List<OutputMedia> outputMediaList =
        outputMediaService.getOutputMediaByApplicationId(applicationId);
    return CollectionUtils.isEmpty(outputMediaList)
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(outputMediaList);
  }

  @GetMapping("/view/byCreditsConsumed/{minCreditsConsumed}/{maxCreditsConsumed}")
  public ResponseEntity<List<OutputMedia>> getOutputMediaByCreditsConsumed(
      @PathVariable int minCreditsConsumed, @PathVariable int maxCreditsConsumed) {
    List<OutputMedia> outputMediaList =
        outputMediaService.getOutputMediaByCreditConsumed(minCreditsConsumed, maxCreditsConsumed);
    return CollectionUtils.isEmpty(outputMediaList)
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(outputMediaList);
  }
}
