CREATE TABLE personagens (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    classe VARCHAR(255) NOT NULL,
    vida_atual INT NOT NULL,
    vida_maxima INT NOT NULL,
    pontos_de_esforco_atuais INT NOT NULL,
    pontos_de_esforco_maximos INT NOT NULL,
    sanidade_atual INT NOT NULL,
    sanidade_maxima INT NOT NULL,
    qtd_municao INT NOT NULL,
    observacoes TEXT,
    campanha_id BIGINT,
    ativo BOOLEAN NOT NULL,
    CONSTRAINT fk_personagem_campanha FOREIGN KEY (campanha_id) REFERENCES campanhas(id)
);

CREATE TABLE itens_amaldicoados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    elemento VARCHAR(255),
    descricao VARCHAR(1000),
    unico BOOLEAN,
    penalidade_customizada BOOLEAN,
    descricao_penalidade_customizada VARCHAR(1000),
    ativo BOOLEAN
);

CREATE TABLE personagem_item (
    personagem_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    PRIMARY KEY (personagem_id, item_id),
    CONSTRAINT fk_personagem_item_personagem FOREIGN KEY (personagem_id) REFERENCES personagens(id),
    CONSTRAINT fk_personagem_item_item FOREIGN KEY (item_id) REFERENCES itens_amaldicoados(id)
);
