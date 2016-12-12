/*DROP TABLE MEDIATHEQUE.BLOCAGE;
DROP TABLE MEDIATHEQUE.EMPRUNT;
DROP TABLE MEDIATHEQUE.MEDIA;
DROP TABLE MEDIATHEQUE.MEMBRE;*/

CREATE SCHEMA MEDIATHEQUEDB;

CREATE TABLE MEDIATHEQUEDB.MEMBRE(
	membre_id integer not null generated always as identity primary key,
	nom varchar(30) not null,
	prenom varchar(30) not null,
	mail varchar(50) not null,
	mdp varchar(20) not null,
	est_admin boolean not null
);
ALTER TABLE MEDIATHEQUEDB.MEMBRE ADD CONSTRAINT membre_mail_unique UNIQUE (mail);
ALTER TABLE MEDIATHEQUEDB.MEMBRE ALTER COLUMN est_admin SET DEFAULT false;


CREATE TABLE MEDIATHEQUEDB.MEDIA(
	media_id integer not null generated always as identity primary key,
	categorie varchar(30),
	titre varchar(50) not null,
	annee varchar(4),
	description varchar(255),
	jours_pret integer not null,
	stock integer not null
);
ALTER TABLE MEDIATHEQUEDB.MEDIA ADD CONSTRAINT media_categorie_titre_annee_description_unique UNIQUE (categorie, titre, annee, description);
ALTER TABLE MEDIATHEQUEDB.MEDIA ADD CONSTRAINT media_categorie_check CHECK (categorie IN ('LIVRE','AUDIO','VIDEO', 'JOURNAL', 'ARCHIVES'));


CREATE TABLE MEDIATHEQUEDB.EMPRUNT(
	emprunt_id integer not null generated always as identity primary key,
	media_id integer,
	membre_id integer,
	date_emprunt date not null
);
ALTER TABLE MEDIATHEQUEDB.EMPRUNT ADD CONSTRAINT emprunt_media_foreign_key FOREIGN KEY (media_id) REFERENCES MEDIATHEQUEDB.MEDIA;
ALTER TABLE MEDIATHEQUEDB.EMPRUNT ADD CONSTRAINT emprunt_membre_foreign_key FOREIGN KEY (membre_id) REFERENCES MEDIATHEQUEDB.MEMBRE;

CREATE TABLE MEDIATHEQUEDB.BLOCAGE(
	blocage_id integer not null generated always as identity primary key,
	membre_id integer,
	emprunt_id integer,
	fin_blocage date not null
);
ALTER TABLE MEDIATHEQUEDB.BLOCAGE ADD CONSTRAINT blocage_membre_foreign_key FOREIGN KEY (membre_id) REFERENCES MEDIATHEQUEDB.MEMBRE;
ALTER TABLE MEDIATHEQUEDB.BLOCAGE ADD CONSTRAINT blocaget_emprunt_foreign_key FOREIGN KEY (emprunt_id) REFERENCES MEDIATHEQUEDB.EMPRUNT;
