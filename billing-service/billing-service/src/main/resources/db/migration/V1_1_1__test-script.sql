use `demo-billing-service`;

INSERT into master_application(name)  VALUES ('PDFDoctor') ;
INSERT into master_application(name)  VALUES ('Theimagekit.com') ;
INSERT into master_application(name)  VALUES ('Audioeditor.com') ;

INSERT into credit_information(application_id,per_credit_file_size) VALUES (1,5);
INSERT into credit_information(application_id,per_credit_file_size) VALUES (2,10);
INSERT into credit_information(application_id,per_credit_file_size) VALUES (3,2);

insert into accounts(name,primary_email,primary_phone_number) values ("Person One","abc@def.com","9999900111");
insert into accounts(name,primary_email,primary_phone_number) values ("Person Two","cde@def.com","9999900112");
insert into accounts(name,primary_email,primary_phone_number) values ("Person Three","ghi@def.com","9999900113");

insert into output_media(media_id,account_id,size,api,credits_consumed,application_id) values ("1111","1",55,'PDFDoctor',"6","2");
insert into output_media(media_id,account_id,size,api,credits_consumed,application_id) values ("2222","2",150,'Audioeditor.com',"75","3");
insert into output_media(media_id,account_id,size,api,credits_consumed,application_id) values ("3333","3",200,'Theimagekit.com',"40","1");

insert into account_application_mapping(account_id,application_id,active) values (1,2,true);
insert into account_application_mapping(account_id,application_id,active) values (2,3,true);
insert into account_application_mapping(account_id,application_id,active) values (3,3,true);

insert into account_application_usage_limits(account_application_mapping,month,credit_used) values (2,'January',50);
insert into account_application_usage_limits(account_application_mapping,month,credit_used) values (1,'February',150);