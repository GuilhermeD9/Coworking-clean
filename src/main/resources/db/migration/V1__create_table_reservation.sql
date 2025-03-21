-- V1: Criação da tabela reservation

CREATE TABLE reservation (
    id BIGSERIAL PRIMARY KEY,
    sala VARCHAR(50) NOT NULL,
    locador VARCHAR(150) NOT NULL,
    inicio TIMESTAMP,
    fim TIMESTAMP,
    status VARCHAR(30)
);