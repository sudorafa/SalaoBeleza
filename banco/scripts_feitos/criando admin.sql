
use SalaoBeleza;
go
insert into Admin (login, nome, cpf, telefone, nascimento, senhaAtual, senhaAnterior) values ('rafa', 'Rafael', '090', '999', '1993-10-18', '123', 'nenhuma');
go

select login, senhaAtual, idAdmin from Admin where login = 'rafa';

select * from Admin;