/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  hkhat
 * Created: 5 Nov, 2022
 */

USE harshLibrary;

/*Data for the table `employees` */
insert  into `user`(`userId`,`userName`, `password`,`email`,`address`,`Occupation`) values 
(1,'Ferreter','12345678','hkhatri731@gmail.com','44 Oriel House Dundalk','Student'),
(2,'Khali','12345678','MeshacWassup@gmail.com','Unit 58 Parkwest Enterprise Centre','Teacher'),
(3,'hardrollshypernova','12345678','rfoley@comcast.net','Swallow Inn Borrisokane','Unemployed'),
(4,'Wyne','12345678','wainwrig@optonline.net','Harringtons Ind. Est.,','Student'),
(5,'Skye','12345678','skythe@sbcglobal.net','Knocknagoshel Tralee','Unemployed'),
(6,'CaleB','12345678','claesjac@yahoo.com',' 29 Marlborough st Cork','Student'),
(7,'Shekira','12345678','sekiya@yahoo.com',' St. Macartans. Carndonagh','Unemployed'),
(8,'VioletBaddy','12345678','violinhi@att.net','6/7 High st Galway','Student'),
(9,'Straighty','12345678','curly@gmail.com','2 The Avenue Bridewood Ovens','Student'),
(10,'NoChin','12345678','yeechingoh@gmail.com',' 14 Teeling St.','Working'),
(11,'Ester','12345678','iamariana@yahoo.com','43 Oriel House Dundalk','Student');

insert  into `book`(`bookId`,`bookName`,`Author`,`bookLength`,`bookCopies`) values 
(42,'The 13 Clocks','James Thurber','1950','3'),
(43,'The Summer Book',' Tove Jansson','900','2'),
(44,'2001: A Space Odyssey',' Arthur C. Clarke','1978','1'),
(45,'Hyperion ','Friedrich Hölderlin','823','5'),
(46,'Labyrinths','James Thurber','600','4'),
(47,'The Man Without Qualities','Jorge Luis Borges','542','2'),
(48,'Memoirs of Martinus Scriblerus','Alexander Pope','342','7'),
(49,'Krapps Last Tape ','Samuel Beckett','823','6'),
(50,'Interview with the Vampire','Anne Rice','2133','5'),
(51,'Coming Up for Air','George Orwell','2134','8'),
(52,'Memory of Fire','Ester Mariet','723','9'),
(53,'Don Quixote','Miguel Cervantes','8213','2'),
(54,'In Cold Blood','Truman Capote','2233','1'),
(55,'W, or the Memory of Childhood','Georges Perec','472','3'),
(56,'No One Writes to the Colonel','Gabriel García Márquez','822','4'),
(57,'Death in Rome','Wolfgang Koeppen','934','1'),
(58,'The Spy Who Came In from the Cold',' Gert Hofmann','876','0');

insert  into `loans`(`loanId`,`userId`,`bookId`,`underLoan`) values 
(101,1,43,0),
(102,2,44,0),
(103,1,57,0),
(104,3,58,1),
(105,5,42,0),
(106,7,50,1),
(107,3,54,0),
(108,9,57,0),
(109,4,56,0),
(110,2,51,1),
(111,6,49,1),
(112,8,48,0),
(113,9,47,0),
(114,9,46,1),
(115,2,53,0),
(116,1,54,0),
(117,1,53,1),
(118,3,57,1),
(119,10,42,0),
(120,11,46,0),
(121,1,44,1);


