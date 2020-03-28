CREATE TABLE USERS
(
     ID bigint not null primary key,
     FIRSTNAME VARCHAR(50) NOT NULL,
     LASTNAME VARCHAR(50) NOT NULL
);

create table ISSUES_LISTS
(
 id bigint not null primary key,
 name varchar(50) NOT NULL
);

create table ISSUES
(
  id bigint not null primary key,
  SUMMARY    varchar(255) NOT NULL,
  DESCRIPTION varchar(255) NOT NULL,
  ISSUES_LISTS_ID    bigint
      references ISSUES_LISTS,
 USER_ID  bigint
      references USERS
);