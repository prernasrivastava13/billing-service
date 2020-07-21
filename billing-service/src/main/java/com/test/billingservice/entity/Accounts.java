package com.test.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "accounts")
public class Accounts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @NotBlank(message = "Please enter your name")
  @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid character(s). Only Letters are allowed")
  @Column(name = "name")
  private String name;

  @Email(message = "Invalid email")
  @NotBlank(message = "Please enter your email")
  @Column(name = "primary_email")
  private String primaryEmail;

  @NotBlank(message = "Please enter your mobile number")
  @Size(min = 10, max = 10, message = "Invalid primary phone number")
  @Pattern(regexp = "^[0-9]+$", message = "Invalid number or character")
  @Column(name = "primary_phone_number")
  private String primaryPhoneNumber;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  private Date createdAt = new Date();

  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt = new Date();

  @Transient private int applicationId;
}
