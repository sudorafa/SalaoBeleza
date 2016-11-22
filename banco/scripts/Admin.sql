use SalaoBeleza;
go
CREATE TABLE Admin (idAdmin integer identity(1000,1) PRIMARY KEY,
					senhaAnterior varchar(20),
					login varchar(11),
					nome varchar(50),
					cpf varchar(14),
					telefone integer,
					nascimento Date,
					senhaAtual varchar(20)

);