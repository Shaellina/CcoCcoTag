
/* Drop Tables */

DROP TABLE t_memo CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE memo_seq;




/* Create Sequences */

CREATE SEQUENCE memo_seq;



/* Create Tables */

CREATE TABLE t_memo
(
	no number NOT NULL,
	title varchar2(100) NOT NULL,
	content varchar2(1000) NOT NULL,
	name varchar2(20) NOT NULL,
	PRIMARY KEY (no)
);



