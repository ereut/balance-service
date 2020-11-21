create schema test_balance_service;

create table
test_balance_service.tariffs (
id bigint not null auto_increment,
title varchar(255),
primary key (id)
)
engine=InnoDB;

create table test_balance_service.clients (
Id bigint not null auto_increment,
balance decimal(7,2) not null,
telephone_number varchar(32) not null,
tariff_id bigint not null,
primary key (Id),
foreign key (tariff_id) references tariffs(id)
)
engine=InnoDB;

create table test_balance_service.testing (
Id bigint not null auto_increment,
primary key (Id)
)
engine=InnoDB;