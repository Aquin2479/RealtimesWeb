DROP TABLE MEMBER cascade constraint;
DROP SEQUENCE member_code_seq;
DROP TABLE TOPIC cascade constraint;
DROP SEQUENCE topic_code_seq;
DROP TABLE NEWS cascade constraint;
DROP TABLE ALREADYVIEW cascade constraint;
DROP TABLE LOG cascade constraint;
DROP SEQUENCE log_code_seq;

CREATE SEQUENCE member_code_seq;
CREATE TABLE MEMBER
(
	member_code           NUMBER(15) PRIMARY KEY,
	username               VARCHAR2(500) NOT NULL,
	password               VARCHAR2(500) NOT NULL
);

CREATE SEQUENCE topic_code_seq;
CREATE TABLE TOPIC
(
	topic_code NUMBER(15) PRIMARY KEY,
	topic_name		VARCHAR2(200) NOT NULL,
	section			VARCHAR2(500) NOT NULL,
	keyword1         VARCHAR2(200) NOT NULL,
   	keyword2         VARCHAR2(200) NOT NULL,
   	keyword3         VARCHAR2(200) NOT NULL,
   	keyword4         VARCHAR2(200) NOT NULL,
   	keyword5         VARCHAR2(200) NOT NULL,
   	analysis_start_time VARCHAR2(200) NOT NULL,
   	analysis_end_time VARCHAR2(200) NOT NULL,
);

CREATE TABLE NEWS
(
	news_code VARCHAR2(50) PRIMARY KEY,
	topic_name		VARCHAR2(200) NOT NULL,
	section			VARCHAR2(500) NOT NULL,
	title            VARCHAR2(500) NOT NULL,
    writing_time      VARCHAR2(500) NOT NULL,
    company            VARCHAR2(500) NOT NULL,
    img               VARCHAR2(500) NOT NULL,
    content            VARCHAR2(4000) NOT NULL
);

CREATE TABLE ALREADYVIEW
(
	site		VARCHAR2(500) NOT NULL
);

CREATE SEQUENCE log_code_seq;
CREATE TABLE LOG
(
	log_code           NUMBER(15) PRIMARY KEY,
	member_code               NUMBER(15) NOT NULL,
	news_code				VARCHAR2(50) NOT NULL,
	topic_name			VARCHAR2(200) NOT NULL,
	viewing_time			VARCHAR2(100) NOT NULL
);