create database test;

use test;

create table produto(
id int auto_increment primary key,
descricao varchar(35) not null,
valor double not null,
data_registro datetime
);

insert into produto (descricao, valor, data_registro) values
('batata', 3.56, now()),
('banana', 2, now()),
('maça', 5, now()),
('ameixa', 4, now()),
('uva', 6, now());

select * from produto;

delimiter //
create procedure find_produto(termo varchar(35))
begin
	select * from produto where descricao like termo;
end //
delimiter ;

CALL `test`.`find_produto`('%b%');




 