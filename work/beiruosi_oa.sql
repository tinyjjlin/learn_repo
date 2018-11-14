# db beiruosi_oa
create database beiruosi_oa  character  SET utf8 collate  utf8_general_ci;

#company
create table if not exists  brs_company(
  id int unsigned auto_increment not null,
  code varchar(10) not null,
  name varchar(20) not null,
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#department 
create table if not exists brs_department(
  id int unsigned auto_increment not null,
  code varchar(10) not null,
  name varchar(20) not null,
    primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#user
create table if not exists brs_user(
  id int unsigned auto_increment not null,
  name varchar(30) not null,
  pwd varchar(50) not null,
  dept_code varchar(10),
    primary key(id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#position
create table if not exists brs_position(
   id int unsigned auto_increment not null,
   code varchar(10) not null,
   name varchar(20) not null,
   description varchar(50) not null,
   parent_position varchar(10) ,
   dept_code varchar(10),
     primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
