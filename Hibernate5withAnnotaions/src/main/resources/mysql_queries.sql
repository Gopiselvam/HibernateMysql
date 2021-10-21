create table MOVIE_MANAGER (MOVIEID varchar(20) primary key, MOVIENAME varchar(20), LANGUAGE varchar(20), RELEASEDIN DATE, REVENUEINDOLLARS  int);
alter table MOVIE_MANAGER MODIFY REVENUEINDOLLARS DOUBLE;
insert into MOVIE_MANAGER values ('1001', 'Avatar 2', 'English', '2022-12-16', 2.74);
alter table movie_manager MODIFY column MOVIEID int;
describe movie_manager;
alter table movie_manager MODIFY column MOVIEID int AUTO_INCREMENT;