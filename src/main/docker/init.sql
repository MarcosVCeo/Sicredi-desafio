CREATE TABLE associado
(
    id        SERIAL PRIMARY KEY,
    nome      varchar,
    sobrenome varchar,
    idade     int,
    email     varchar
);

CREATE TYPE tipo_conta AS ENUM ('Corrente', 'Poupança', 'Investimento');

CREATE TABLE conta
(
    id           SERIAL PRIMARY KEY,
    tipo         tipo_conta,
    data_criacao timestamp,
    id_associado int,

    CONSTRAINT fk_conta_associado FOREIGN KEY (id_associado) REFERENCES associado (id) ON DELETE CASCADE
);

CREATE TABLE cartao
(
    id           SERIAL PRIMARY KEY,
    num_cartao   bigint,
    nom_impresso varchar(100),
    id_conta     int,
    id_associado int,

    CONSTRAINT fk_cartao_conta FOREIGN KEY (id_conta) REFERENCES conta (id) ON DELETE CASCADE,
    CONSTRAINT fk_cartao_associado FOREIGN KEY (id_associado) REFERENCES associado (id) ON DELETE CASCADE
);

CREATE TABLE movimento
(
    id             SERIAL PRIMARY KEY,
    vlr_transacao  decimal(10, 2),
    des_transacao varchar,
    data_movimento timestamp,
    id_cartao      int,

    CONSTRAINT fk_movimento_cartao FOREIGN KEY (id_cartao) REFERENCES cartao (id) ON DELETE CASCADE
);


INSERT INTO associado (nome, sobrenome, idade, email)
VALUES ('João', 'Silva', 30, 'joao.silva@example.com'),
       ('Maria', 'Oliveira', 25, 'maria.oliveira@example.com'),
       ('Carlos', 'Pereira', 40, 'carlos.pereira@example.com'),
       ('Ana', 'Souza', 35, 'ana.souza@example.com');

INSERT INTO conta (tipo, data_criacao, id_associado)
VALUES ('Corrente', NOW(), 1),     -- João Silva
       ('Poupança', NOW(), 2),     -- Maria Oliveira
       ('Investimento', NOW(), 3), -- Carlos Pereira
       ('Poupança', NOW(), 4);

-- Inserindo registros na tabela cartao
INSERT INTO cartao (num_cartao, nom_impresso, id_conta, id_associado)
VALUES (1234567890123456, 'João Silva', 1, 1),     -- Cartão de João
       (2345678901234567, 'Maria Oliveira', 2, 2), -- Cartão de Maria
       (3456789012345678, 'Carlos Pereira', 3, 3), -- Cartão de Carlos
       (4567890123456789, 'Ana Souza', 4, 4);
-- Cartão de Ana

-- Inserindo registros na tabela movimento
INSERT INTO movimento (vlr_transacao, des_transacao, data_movimento, id_cartao)
VALUES (100.00, 'Compra em supermercado', NOW(), 1), -- Movimento do cartão de João
       (50.00, 'Pagamento de conta', NOW(), 2),      -- Movimento do cartão de Maria
       (200.00, 'Transferência', NOW(), 3),          -- Movimento do cartão de Carlos
       (75.00, 'Compra online', NOW(), 4); -- Movimento do cartão de Ana
