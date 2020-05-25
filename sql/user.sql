create table TB_USER
(
    ID               INT auto_increment,
    ACCOUNT_ID       VARCHAR(255) not null,
    NAME             VARCHAR(255),
    TOKEN            VARCHAR(36),
    CREATE_DATE      VARCHAR(50),
    LAST_MODIFY_DATE VARCHAR(50),
    IDS              VARCHAR(255),
    constraint TB_USER_PK
        primary key (ACCOUNT_ID)
);
