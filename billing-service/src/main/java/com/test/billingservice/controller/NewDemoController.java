package com.test.billingservice.controller;

import com.test.billingservice.service.FacebookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class NewDemoController {

  @Resource FacebookService facebookService;

  @GetMapping("/createFacebookAuthorization")
  public String createFacebookAuthorization() {
    return facebookService.createFacebookAuthorizationURL();
  }

  @GetMapping("/facebook")
  public void createFacebookAccessToken(@RequestParam("code") String code) {
    facebookService.createFacebookAccessToken(code);
  }

  @GetMapping("/getName")
  public String getNameResponse() {
    return facebookService.getName();
  }
}
