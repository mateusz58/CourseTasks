CREATE TABLE USERS
(
     ID bigint NOT NULL primary key,
     FIRST_NAME VARCHAR(50) NOT NULL,
     LAST_NAME VARCHAR(50) NOT NULL
);
 
CREATE TABLE ISSUES_LISTS
(
 id bigint NOT NULL primary key,  
 NAME VARCHAR(50) NOT NULL
);
 
CREATE TABLE ISSUES
(
  id bigint NOT NULL primary key,
  SUMMARY    VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL,
  ISSUES_LISTS_ID    bigint
      references ISSUESLISTS,
 USER_ID   bigint
      references USERS    
);


