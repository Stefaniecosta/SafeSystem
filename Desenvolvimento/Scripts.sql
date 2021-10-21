CREATE TABLE banco(
    idBanco INT PRIMARY KEY IDENTITY NOT NULL,
    nomeBanco VARCHAR(40),
    cnpj VARCHAR(20)
);

CREATE TABLE agencia (
    idAgencia INT PRIMARY KEY IDENTITY NOT NULL,
    nomeAgencia VARCHAR(100),
    localizacaoAgencia VARCHAR(200),
    codigoAgencia VARCHAR(50),
    fkBanco INT,
    senha VARCHAR (45),
    FOREIGN KEY (fkBanco) REFERENCES banco(idBanco)
);

CREATE TABLE usuario (
    idUsuario INT PRIMARY KEY IDENTITY NOT NULL,
    email VARCHAR(255),
    senha VARCHAR(255),
    fkAgencia INT,
    FOREIGN KEY (fkAgencia) REFERENCES agencia(idAgencia)
);

CREATE TABLE maquina (
    idMaquina INT PRIMARY KEY IDENTITY NOT NULL,
    patrimonio VARCHAR(20),
    fkAgencia int NOT NULL,
    quantDispositivo int,
    sistemaOperacional VARCHAR(40),
    FOREIGN KEY (fkAgencia) REFERENCES agencia(idAgencia)
);

CREATE TABLE registroMaquina (
    idRegistro INT PRIMARY KEY IDENTITY NOT NULL,
    totalRam float,
    usoRam float,
    totalDisco float,
    usoDisco float,
    dispositivoEstranho bit,
    dataHora datetime,
    nomeCPU varchar(100),
    usoCPU int,
    fkMaquina int,
    FOREIGN KEY (fkMaquina) REFERENCES maquina(idMaquina)
);

INSERT INTO
    usuario
VALUES
    (null, 'login@gmail.com', '1234', 100);

INSERT INTO
    maquina(
        patrimonio,
        fkAgencia,
        quantDispositivos,
        sistemaOperacional
    )
VALUES
    ('12345', 100, 3, 'Windows 7');

INSERT INTO
    registroMaquina(
        totalRam,
        usoRam,
        totalDisco,
        usoDisco,
        dispositivoEstranho,
        dataHora,
        nomeCPU,
        usoCPU,
        fkMaquina
    )
VALUES
    (
        1.0,
        1.0,
        1.0,
        1.0,
        0,
        '20120618 10:34:09 AM',
        'processador',
        1,
        1
    );