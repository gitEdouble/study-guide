drop table P_USER if exists;

CREATE TABLE P_USER
(
  ID INT IDENTITY PRIMARY KEY
, FIRST_NAME VARCHAR2(50)
, USERNAME VARCHAR2(50) NOT NULL
, LAST_NAME VARCHAR2(50)
, PASSWORD VARCHAR2(50) NOT NULL
, ADDRESS VARCHAR2(100)
, EMAIL VARCHAR2(50) NOT NULL
, UNIQUE(EMAIL)
, UNIQUE(USERNAME)
)

