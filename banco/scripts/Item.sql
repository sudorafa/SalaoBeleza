use SalaoBeleza;
go
CREATE TABLE Item ( idItem integer identity PRIMARY KEY,
					qtdEstoque integer,
					descricao varchar(50),
					tipoItem char(1),
					valor numeric(10,2),
					valorPromocional numeric(10,2),
					codBarras integer,
					qtdPromocao integer,
					idAdmin integer references Admin(idAdmin)
);