use `demo-billing-service`;

# CREATE TABLE IF NOT EXISTS accounts
# (
#     account_id           int AUTO_INCREMENT PRIMARY KEY,
#     account_holder_name  varchar(100),
#     primary_email        varchar(100),
#     primary_phone_number varchar(100),
#     created_at           datetime DEFAULT CURRENT_TIMESTAMP,
#     updated_at           datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
# )
#     ENGINE = InnoDB
#     DEFAULT CHARSET = UTF8;


CREATE TABLE IF NOT EXISTS master_application
(

    id   int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50)

) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS output_media
(

    id               int AUTO_INCREMENT PRIMARY KEY,
    media_id         int,
    account_id       int,
    size             int,
    api              varchar(100),
    credits_consumed int,
    application_id   int,
    created_at       datetime DEFAULT CURRENT_TIMESTAMP,
    updated_at       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS credit_information
(

    id                   int AUTO_INCREMENT PRIMARY KEY,
    application_id       int,
    per_credit_file_size int
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS monthly_usage
(

    id               int AUTO_INCREMENT PRIMARY KEY,
    month            varchar(100),
    account_id       int,
    credits_consumed int,
    invoice_id       int,
    created_at       datetime DEFAULT CURRENT_TIMESTAMP,
    updated_at       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS plans
(

    id                   int AUTO_INCREMENT PRIMARY KEY,
    application_id       int,
    plan_name            varchar(100),
    min_credits          int,
    max_credits          int,
    fix_price            int,
    per_credit_file_size int
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS invoices
(

    id               int AUTO_INCREMENT PRIMARY KEY,
    account_id       int,
    price            int,
    month            varchar(100),
    invoice_number   int,
    invoice_media_id int,
    invoice_status   int,
    created_at       datetime DEFAULT CURRENT_TIMESTAMP,
    updated_at       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS accounts
(

    id                   int AUTO_INCREMENT PRIMARY KEY,
    name                 varchar(100),
    primary_email        varchar(100),
    primary_phone_number varchar(100),
    created_at           datetime DEFAULT CURRENT_TIMESTAMP,
    updated_at           datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS account_application_mapping
(
    id             int AUTO_INCREMENT PRIMARY KEY,
    account_id     int,
    application_id int,
    active         boolean,
    created_at     datetime DEFAULT CURRENT_TIMESTAMP,
    updated_at     datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    credit_limit   int,

#     PRIMARY KEY (account_id, application_id),

    CONSTRAINT FK_account_id FOREIGN KEY (account_id)
        REFERENCES accounts (id),

    CONSTRAINT FK_application_id FOREIGN KEY (application_id)
        REFERENCES master_application (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS account_application_usage_limits
(

    id                          int AUTO_INCREMENT PRIMARY KEY,
    account_application_mapping int,
#     application_id int,
#     account_id     int,
    month                       varchar(100),
    created_at                  datetime DEFAULT CURRENT_TIMESTAMP,
    updated_at                  datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    credit_used                 int,

    CONSTRAINT FK_account_application_mapping FOREIGN KEY (account_application_mapping)
        REFERENCES account_application_mapping (id)

#     CONSTRAINT FK_account_application_mapping FOREIGN KEY (application_id, account_id) REFERENCES account_application_mapping (application_id, account_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = UTF8;
