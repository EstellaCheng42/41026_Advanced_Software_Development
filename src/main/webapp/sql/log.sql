/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  bababab
 * Created: 2021-5-14
 */
drop table LOG;

create table LOG
(
	ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  primary key,
	USERID Int not null,
	logTime Timestamp not null default current_timestamp,
	TYPE VARCHAR(100) not null default 'login'
);

insert into LOG(USERID, TYPE) values( 1, 'login');

