package com.test.billingservice.controller;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialFacebookController {

  private FacebookConnectionFactory factory =
      new FacebookConnectionFactory("278112556972743", "786ee4db7a7b27123428d23e9decc252");

  @RequestMapping("/")
  public ModelAndView firstPage() {
    return new ModelAndView("welcome");
  }

  @GetMapping(value = "/useApplication")
  public String producer() {

    OAuth2Operations operations = factory.getOAuthOperations();
    OAuth2Parameters params = new OAuth2Parameters();

    params.setRedirectUri("http://localhost:8080/forwardLogin");
    params.setScope("email,public_profile");

    String url = operations.buildAuthenticateUrl(params);
    System.out.println("The URL is" + url);
    return "redirect:" + url;
  }

  @RequestMapping(value = "/forwardLogin")
  public ModelAndView producer(@RequestParam("code") String authorizationCode) {
    OAuth2Operations operations = factory.getOAuthOperations();
    AccessGrant accessToken =
        operations.exchangeForAccess(authorizationCode, "http://localhost:8080/forwardLogin", null);

    Connection<Facebook> connection = factory.createConnection(accessToken);
    Facebook facebook = connection.getApi();

    String[] fields = {"id", "email", "first_name", "last_name", "phone"};
    User userProfile = facebook.fetchObject("me", User.class, fields);
    System.out.println(userProfile.toString());
    userProfile.getName();
    userProfile.getDevices();

    UserOperations userOperations = facebook.userOperations();
    User user = userOperations.getUserProfile();
    System.out.println("User details: " + user.getFirstName());

    System.out.println("userProfile: " + userProfile.getName());
    System.out.println("userProfile: " + userProfile.getEmail());
    System.out.println("userProfile: " + userProfile.getBirthday());
    System.out.println("userProfile: " + userProfile.getGender());
    System.out.println("userProfile: " + userProfile.getFirstName());
    System.out.println("userProfile: " + userProfile.getLastName());
    ModelAndView model = new ModelAndView("details");
    model.addObject("user", userProfile);
    return model;
  }
}
