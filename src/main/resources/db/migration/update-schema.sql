CREATE TABLE liste_postulant
(
    id_liste_postulant BIGINT AUTO_INCREMENT NOT NULL,
    libele             VARCHAR(255) NULL,
    date_liste         datetime NULL,
    CONSTRAINT pk_listepostulant PRIMARY KEY (id_liste_postulant)
);

CREATE TABLE postulant
(
    id_postulant                       BIGINT AUTO_INCREMENT NOT NULL,
    nom                                VARCHAR(255) NULL,
    prenom                             VARCHAR(255) NULL,
    email                              VARCHAR(255) NULL,
    numero                             VARCHAR(255) NULL,
    liste_postulant_id_liste_postulant BIGINT NULL,
    CONSTRAINT pk_postulant PRIMARY KEY (id_postulant)
);

CREATE TABLE postulant_tirage
(
    postulant_id_postulant BIGINT NOT NULL,
    tirage_id_tirage       BIGINT NOT NULL
);

CREATE TABLE postulant_tire
(
    id_postulanttire BIGINT AUTO_INCREMENT NOT NULL,
    nom              VARCHAR(255) NULL,
    prenom           VARCHAR(255) NULL,
    email            VARCHAR(255) NULL,
    numero           VARCHAR(255) NULL,
    CONSTRAINT pk_postulanttire PRIMARY KEY (id_postulanttire)
);

ALTER TABLE postulant
    ADD CONSTRAINT FK_POSTULANT_ON_LISTEPOSTULANT_ID_LISTE_POSTULANT FOREIGN KEY (liste_postulant_id_liste_postulant) REFERENCES liste_postulant (id_liste_postulant);

ALTER TABLE postulant_tirage
    ADD CONSTRAINT fk_postir_on_postulant FOREIGN KEY (postulant_id_postulant) REFERENCES postulant (id_postulant);

ALTER TABLE postulant_tirage
    ADD CONSTRAINT fk_postir_on_tirage FOREIGN KEY (tirage_id_tirage) REFERENCES tirage (id_tirage);
CREATE TABLE tirage
(
    id_tirage BIGINT AUTO_INCREMENT NOT NULL,
    date      datetime              NULL,
    libele    VARCHAR(255)          NULL,
    n_tirage  INT                   NOT NULL,
    CONSTRAINT pk_tirage PRIMARY KEY (id_tirage)
);

ALTER TABLE postulant_tire
    ADD email VARCHAR(255) NULL;

ALTER TABLE postulant_tire
    CHANGE id_tirage id_postulanttire BIGINT;

ALTER TABLE postulant_tire
    ADD nom VARCHAR(255) NULL;

ALTER TABLE postulant_tire
    ADD numero VARCHAR(255) NULL;

ALTER TABLE postulant_tire
    ADD prenom VARCHAR(255) NULL;

ALTER TABLE postulant
    ADD CONSTRAINT FK_POSTULANT_ON_LISTEPOSTULANT_ID_LISTE_POSTULANT FOREIGN KEY (liste_postulant_id_liste_postulant) REFERENCES liste_postulant (id_liste_postulant);

ALTER TABLE postulant_tirage
    ADD CONSTRAINT fk_postir_on_postulant FOREIGN KEY (postulant_id_postulant) REFERENCES postulant (id_postulant);

ALTER TABLE postulant_tirage
    ADD CONSTRAINT fk_postir_on_tirage FOREIGN KEY (tirage_id_tirage) REFERENCES tirage (id_tirage);

ALTER TABLE postulant_tire
    DROP COLUMN id_postulant;