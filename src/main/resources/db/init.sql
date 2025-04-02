CREATE TABLE conta
(
    id           SERIAL PRIMARY KEY,
    tipo         ???,
    data_criacao timestamp,
    id_associado int
)

CREATE TABLE cartao
(
    id           SERIAL PRIMARY KEY,
    num_cartao   int,
    nom_impresso varchar(100),
    id_conta     int,
    id_associado int
)

CREATE TABLE movimento
(
    id             SERIAL PRIMARY KEY,
    vlr_transacao  decimal(10, 2) des_transacao varchar,
    data_movimento timestamp,
    id_cartao      int
);
