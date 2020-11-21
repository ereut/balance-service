create schema balance_service;

create table
balance_service.tariffs (
id bigint not null auto_increment,
title varchar(255),
primary key (id)
)
engine=InnoDB;

create table balance_service.clients (
Id bigint not null auto_increment,
balance decimal(7,2) not null,
telephone_number varchar(32) not null,
tariff_id bigint not null,
primary key (Id),
foreign key (tariff_id) references tariffs(id)
)
engine=InnoDB;

Insert into balance_service.tariffs (title) values
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000))),
(concat('tariff_', floor(rand()*10000)));


Insert into balance_service.clients (balance, telephone_number, tariff_id) values
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1)),
(round(rand()*100, 2), concat('+3', floor(rand()*10000000000000)), (select id from balance_service.tariffs order by rand() limit 1));
