
/* Drop Tables */

DROP TABLE tb_article CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE seq_article;




/* Create Sequences */

CREATE SEQUENCE seq_article nocache;



/* Create Tables */

CREATE TABLE tb_article
(
	no number NOT NULL,
	name varchar2(30) NOT NULL,
	title varchar2(100) NOT NULL,
	content varchar2(1000) NOT NULL,
	regdate date DEFAULT sysdate NOT NULL,
	pwd varchar2(128) NOT NULL,
	viewcount number DEFAULT 0 NOT NULL,
	PRIMARY KEY (no)
);



