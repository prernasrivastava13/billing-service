use `demo-billing-service`;

CREATE TABLE IF NOT EXISTS `master-application` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `output-media`
(

    `id`               int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `media-id`         int,
    `account-id`       int,
    `size`             int,
    `api`              varchar(100),
    `credits-consumed` int,
    `application-id`   int,
    `created-at`       timestamp DEFAULT CURRENT_TIMESTAMP,
    `updated-at`       timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `credit-information`
(

    `id`                   int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `application-id`       int,
    `account-id`           int,
    `per-credit-file-size` int
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `monthly-usage`
(

    `id`               int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `month`            varchar(100),
    `account-id`       int,
    `credits-consumed` int,
    `invoice-id`       int,
    `created-at`       timestamp DEFAULT CURRENT_TIMESTAMP,
    `updated-at`       timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `plans`
(

    `id`                   int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `application-id`       int,
    `account-id`           int,
    `plan-name`            varchar(100),
    `min-credits`          int,
    `max-credits`          int,
    `fix-price`            int,
    `per-credit-file-size` int
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `invoices`
(

    `id`               int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `account-id`       int,
    `price`            int,
    `month`            varchar(100),
    `invoice-number`   int,
    `invoice-media-id` int,
    `invoice-status`   int,
    `created-at`       timestamp DEFAULT CURRENT_TIMESTAMP,
    `updated-at`       timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `accounts`
(

    `account-id`           int AUTO_INCREMENT PRIMARY KEY,
    `account-holder-name`  varchar(100),
    `primary-email`        varchar(100),
    `primary-phone-number` varchar(100),
    `created-at`           datetime DEFAULT CURRENT_TIMESTAMP,
    `updated-at`           datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `account-application-mapping`
(

    `account-id`     int,
    `application-id` int,
    `active`         boolean,
    `created-at`     timestamp DEFAULT CURRENT_TIMESTAMP,
    `updated-at`     timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `credit-limit`   int,

    PRIMARY KEY(`account-id`,`application-id`),

    CONSTRAINT FK_account_id FOREIGN KEY (`account-id`)
    REFERENCES `accounts`(`account-id`),

    CONSTRAINT FK_application_id FOREIGN KEY (`application-id`)
    REFERENCES `master-application`(id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `account-application-usage-limits`
(

    `id`                          int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     `account-application-mapping` int,
    `application-id`              int,
    `account-id`                  int,
    `month`                       varchar(100),
    `created-at`                  timestamp DEFAULT CURRENT_TIMESTAMP,
    `updated-at`                  timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `credit_used`                 int,

--     CONSTRAINT FK_account_application_mapping FOREIGN KEY (`account-application-mapping`)
--     REFERENCES `account-application-mapping`(id),

    CONSTRAINT FK_account_application_mapping FOREIGN KEY (`application-id`,`account-id`) REFERENCES `account-application-mapping`(`application-id`,`account-id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;
