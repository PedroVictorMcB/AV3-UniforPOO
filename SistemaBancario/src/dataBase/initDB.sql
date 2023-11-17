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

