/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  hkhat
 * Created: 5 Nov, 2022
 */

DROP DATABASE IF EXISTS harshLibrary;
CREATE DATABASE IF NOT EXISTS harshLibrary;

USE harshLibrary;

/*Table structure for table employees */
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  userId int(11) NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email varchar(100) NOT NULL,
  address varchar(100) NOT NULL,
  Occupation varchar(50) NOT NULL,
  PRIMARY KEY  (userId)
);

DROP TABLE IF EXISTS book;
CREATE TABLE book (
  bookId int(11) NOT NULL,
  bookName varchar(50) NOT NULL,
  author varchar(100) NOT NULL,
  bookLength varchar(100) NOT NULL,
  bookCopies int(11) NOT NULL,
  PRIMARY KEY  (bookId)
);

DROP TABLE IF EXISTS loans;
CREATE TABLE loans (
  loanId int(11) NOT NULL,
  userId int(11) NOT NULL,
  bookId int(11) NOT NULL,
  underLoan int(11) NOT NULL, 
  PRIMARY KEY  (loanId)
);

ALTER TABLE `loans`
  MODIFY `loanId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

