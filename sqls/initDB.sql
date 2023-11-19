CREATE TABLE conta_corrente (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	saldo NUMERIC DEFAULT (0) NOT NULL
);

CREATE TABLE transacao (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	valor NUMERIC,
	operacao TEXT NOT NULL,
	origem TEXT DEFAULT (0),
	destino TEXT DEFAULT (0),
	data_transacao TEXT,
	conta_corrente_id INTEGER NOT NULL,
	CONSTRAINT transacao_FK FOREIGN KEY (conta_corrente_id) REFERENCES conta_corrente(id)
);

INSERT INTO conta_corrente(saldo)
VALUES 
	(290.98),
	(329.68),
	(450.90);

INSERT INTO transacao (valor, operacao, origem, destino, data_transacao, conta_corrente_id) 
VALUES
	(1500.89, "SALARIO", "EastBank", "WBConta1", "2023-11-06T15:30:02", 1),
	(500.89, "DEBITO_TRANSFERENCIA", "WBConta1", "NBConta2", "2023-11-10T10:20:30", 1),
	(200, "DEBITO_CONTA", "WBConta1", "ENELSA", "2023-11-15T10:10:01", 1),
	(200, "DEBITO_CONTA", "WBConta1", "PlazaCentralResidence", "2023-11-25T10:15:25", 1),
	(600, "DEBITO_CONTA", "WBConta1", "LoLOutFitSkinsPackage", "2023-11-30T23:50:59", 1),
	(290.98, "CREDITO_TRANFERENCIA", "NBContaVozinha", "WBConta1", "2023-11-29T07:30:30", 1);

