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

insert into account_application_mapping(account_id,application_id,active,credit_limit) values (1,2,true,300);
insert into account_application_mapping(account_id,application_id,active,credit_limit) values (2,3,true,45);
insert into account_application_mapping(account_id,application_id,active,credit_limit) values (3,3,true,400);

insert into account_application_usage_limits(account_application_mapping,month,credit_used) values (2,'JANUARY',50);
insert into account_application_usage_limits(account_application_mapping,month,credit_used) values (1,'FEBRUARY',150);
insert into account_application_usage_limits(account_application_mapping,month,credit_used) values (1,'JULY',150);

insert into plans(application_id,plan_name,min_credits,max_credits,fix_price,per_credit_file_size) values (1,'Plan A',0,500,50,5);
insert into plans(application_id,plan_name,min_credits,max_credits,fix_price,per_credit_file_size) values (1,'Plan B',501,1000,100,10);
insert into plans(application_id,plan_name,min_credits,max_credits,fix_price,per_credit_file_size) values (2,'Plan A',0,0,500,5);
insert into plans(application_id,plan_name,min_credits,max_credits,fix_price,per_credit_file_size) values (2,'Plan B',501,1000,100,10);
insert into plans(application_id,plan_name,min_credits,max_credits,fix_price,per_credit_file_size) values (3,'Plan A',0,500,50,5);
insert into plans(application_id,plan_name,min_credits,max_credits,fix_price,per_credit_file_size) values (3,'Plan B',501,1000,100,10);