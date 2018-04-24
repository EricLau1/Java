create database javaimages
default character set utf8 
default collate utf8_general_ci;

use javaimages;

create table tb_images(
id int auto_increment,
descricao varchar(100),
imagem mediumblob not null,
constraint tb_images_id_pk primary key(id)
)
engine = InnoDB
default charset = utf8;