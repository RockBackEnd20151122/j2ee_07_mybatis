
#in MAC
brew install mysql

mysql.server start

mysql -u root -p

create database userTest;

use userTest;

CREATE TABLE `userMyBatis` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table userMyBatis;

INSERT INTO `userMyBatis` VALUES ('01', 'Rock01', '33', '02' );
delete from userMyBatis where id='01';
UPDATE userMyBatis t set user_name='Rock', password='fuck' where t.user_id in ('01','2') and t.user_name='Rock01';