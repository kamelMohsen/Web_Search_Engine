-----------------------SearchEngine Data-Base creation query------------------
DROP DATABASE IF EXISTS SearchEngine;

-----------------------------------------------------------------------
CREATE DATABASE SearchEngine;

-----------------------------------------------------------------------
USE SearchEngine;
GO

-----------------------------------------------------------------------
CREATE TABLE Link (
    LinkURL CHAR(256) PRIMARY KEY,
    LinkType INT, /*0-Unknown 1-News 2-Governoment 3-Education 4-Social Media*/
    LinkWordCount INT	
);

-----------------------------------------------------------------------
CREATE TABLE Word (
    Word CHAR(256)  PRIMARY KEY,
    WordCount INT
);

-----------------------------------------------------------------------
CREATE TABLE Indexer (
	Word CHAR(256) ,
	LinkURL CHAR(256) ,
	LinkWordCount INT ,
	TitleWordCount INT , 
	HeadWordCount INT ,
	PlainTextWordCount INT ,
	WordFrequency INT ,
	CONSTRAINT Word_Link_PK PRIMARY KEY (Word,LinkURL),
	FOREIGN KEY (Word) REFERENCES Word(Word),
	FOREIGN KEY (LinkURL) REFERENCES Link(LinkURL)
);

