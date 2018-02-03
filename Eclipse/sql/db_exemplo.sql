create database db_exemplo
default character set utf8
default collate utf8_general_ci;

use db_exemplo;

create table usuario(
id int auto_increment,
nome varchar(35) not null,
email varchar(35) not null,
nascimento date not null,
constraint usuario_id_pk primary key(id)
) 
engine = InnoDB 
default charset = utf8;

insert into usuario (nome, email, nascimento) values ('admin', 'admin@email.com', '2018-02-02');

select * from usuario;