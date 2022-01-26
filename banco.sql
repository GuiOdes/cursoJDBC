create database loja_virtual;

use loja_virtual;

create table pessoa (
    id int not null auto_increment,
    nome varchar(200) not null,
    primary key(id)
);