use SalaoBeleza;
go
CREATE TABLE Venda (idVenda integer identity PRIMARY KEY,
					dataVenda Date,
					codCliente integer references Cliente(codCliente)
);