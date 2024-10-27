CREATE DATABASE barbearia;
USE barbearia;

CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100),
    data_cadastro DATE DEFAULT CURRENT_DATE
);

CREATE TABLE servicos (
    id_servico INT AUTO_INCREMENT PRIMARY KEY,
    nome_servico VARCHAR(100) NOT NULL,
    preco DECIMAL(6,2) NOT NULL,
    duracao TIME
);

CREATE TABLE profissionais (
    id_profissional INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100),
    telefone VARCHAR(15)
);

CREATE TABLE agendamentos (
    id_agendamento INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_servico INT,
    id_profissional INT,
    data DATE NOT NULL,
    horario TIME NOT NULL,
    status VARCHAR(20) DEFAULT 'Pendente',
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_servico) REFERENCES servicos(id_servico),
    FOREIGN KEY (id_profissional) REFERENCES profissionais(id_profissional)
);
