DROP TABLE TEST cascade constraint;
DROP SEQUENCE test_code_seq;
DROP TABLE MEMBER cascade constraint;
DROP SEQUENCE member_code_seq;
DROP TABLE LOG cascade constraint;
DROP SEQUENCE log_code_seq;

CREATE SEQUENCE test_code_seq;
CREATE TABLE TEST
(
	test_code           NUMBER(10) PRIMARY KEY,
	detail               VARCHAR2(500) NULL 
);

CREATE SEQUENCE member_code_seq;
CREATE TABLE MEMBER
(
	member_code           NUMBER(10) PRIMARY KEY,
	username               VARCHAR2(500) NOT NULL,
	password               VARCHAR2(500) NOT NULL
);

CREATE SEQUENCE log_code_seq;
CREATE TABLE LOG
(
	log_code           NUMBER(10) PRIMARY KEY,
	username               VARCHAR2(500) NOT NULL,
	news_code				VARCHAR2(500) NOT NULL,
	viewing_time			VARCHAR2(100) NOT NULL
)

