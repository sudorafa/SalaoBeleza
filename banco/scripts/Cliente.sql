use SalaoBeleza;
go
CREATE TABLE Cliente(codCliente integer identity(1000,1) PRIMARY KEY ,
					 cidade varchar(50),
					 sexo char(1),
					 bairro varchar(50),
					 nome varchar(50),
					 telefone integer,
					 nascimento Date,	
					 cpf varchar(14),
					 idAdmin integer references Admin(idAdmin)
);