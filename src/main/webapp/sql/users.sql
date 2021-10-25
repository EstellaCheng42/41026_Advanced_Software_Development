/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  bababab
 * Created: 2021-5-14
 */
drop table USERS;

create table USERS
(
	ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  primary key,
	FIRSTNAME VARCHAR(100) not null,
	LASTNAME VARCHAR(100) not null,
	EMAIL VARCHAR(200) not null,
	PASSWORD VARCHAR(300) not null,
	TYPE VARCHAR(100) not null default 'customer'
);

insert into USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, TYPE) values( 'chenxi', 'zhang', '13160167@student.uts.edu.au','12345', 'customer');

