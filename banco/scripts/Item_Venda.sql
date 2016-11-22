use SalaoBeleza;
go
CREATE TABLE Item_Venda(idItemVenda integer identity PRIMARY KEY,
						valorTotal numeric(10,2),
						qtdItem integer,
						idVenda integer references Venda(idVenda),
						idItem integer references Item(idItem)

);