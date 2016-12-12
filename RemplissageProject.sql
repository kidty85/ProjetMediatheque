INSERT INTO MEDIATHEQUE.MEMBRE (NOM, PRENOM, MAIL, MDP, EST_ADMIN)
		VALUES ('NGUYEN', 'Huu Phuong', 'phuonghuunguyen91@yahoo.com', 'hellobaby91', true);
INSERT INTO MEDIATHEQUE.MEMBRE (NOM, PRENOM, MAIL, MDP, EST_ADMIN)
  	VALUES ('NGUYEN', 'Quang Minh', 'nguyenquangminh@hotmail.fr', 'hacler4ever', true);
INSERT INTO MEDIATHEQUE.MEMBRE (NOM, PRENOM, MAIL, MDP)
    VALUES ('LEGROS', 'Mathieu', 'kidty85@gmail.com', 'testerleprogramme');
INSERT INTO MEDIATHEQUE.MEMBRE (NOM, PRENOM, MAIL, MDP)
    VALUES ('VO', 'Cecile', 'vocecile@yahoo.fr', '12345678');



INSERT INTO MEDIATHEQUE.CATEGORIE(NOM ) VALUES ('LIVRE');
INSERT INTO MEDIATHEQUE.CATEGORIE(NOM ) VALUES ('AUDIO');
INSERT INTO MEDIATHEQUE.CATEGORIE(NOM ) VALUES ('VIDEO');


INSERT INTO MEDIATHEQUE.MEDIA( CATEGORIE_ID, TITRE, ANNEE, DESCRIPTION, JOURS_PRET)
		VALUES(SELECT CATEGORIE_ID FROM MEDIATHEQUE.CATEGORIE where NOM = 'LIVRE',
			'Java pour les nuls', 1999, 'Java est un langage de programmation
			 moderne développé par Sun Microsystems (aujourd hui racheté par Oracle).
			 Il ne faut surtout pas le confondre avec JavaScript
			 (langage de scripts utilisé principalement sur les sites web),
			 car Java n a rien à voir.',15);
INSERT INTO MEDIATHEQUE.MEDIA( CATEGORIE_ID, TITRE, ANNEE, DESCRIPTION, JOURS_PRET)
		VALUES(SELECT CATEGORIE_ID FROM MEDIATHEQUE.CATEGORIE where NOM = 'LIVRE',
			'ADMINISTREZ VOS BASES DE DONNÉES AVEC MYSQL', 2014, 'Découvrez MySQL,
			le système de bases de données le plus répandu au monde. Grâce à ce cours
			complètement à jour avec la dernière version de MySQL (5.6),
			vous apprendrez à manipuler vos données, depuis la création d une table
			jusqu à l utilisation des triggers.',15);
INSERT INTO MEDIATHEQUE.MEDIA( CATEGORIE_ID, TITRE, ANNEE, DESCRIPTION, JOURS_PRET)
		VALUES(SELECT CATEGORIE_ID FROM MEDIATHEQUE.CATEGORIE where NOM = 'LIVRE',
			'CONCEVEZ VOTRE SITE WEB AVEC PHP ET MYSQL',2012,'Vous connaissez le HTML
			et vous avez toujours rêvé de créer un site web dynamique, avec votre propre blog,
			vos forums et votre espace membres ? Ne cherchez plus ! Découvrez dans ce cours
			dédié aux débutants comment utiliser les outils les plus célèbres du web
			dynamique : PHP et MySQL !',15);
INSERT INTO MEDIATHEQUE.MEDIA( CATEGORIE_ID, TITRE, ANNEE, DESCRIPTION, JOURS_PRET)
		VALUES(SELECT CATEGORIE_ID FROM MEDIATHEQUE.CATEGORIE where NOM = 'LIVRE',
			'DÉCOUVREZ LE LANGAGE SWIFT',2016,'Ce livre a été rédigé pour permettre à
			n importe qui d apprendre le langage de programmation Swift, conçu pour développer
			des applications iPhone, iPad, iPod Touch ou encore Mac OS X. De ce fait,
			aucune connaissance préalable n est nécessaire. Un parfait débutant saura très bien
			à la fin de ce livre programmer dans ce langage.',15);
INSERT INTO MEDIATHEQUE.MEDIA( CATEGORIE_ID, TITRE, ANNEE, DESCRIPTION, JOURS_PRET)
		VALUES(SELECT CATEGORIE_ID FROM MEDIATHEQUE.CATEGORIE where NOM = 'AUDIO',
			'TOEIC FOR TODAY',2000,'Le pack réussite Nouveau TOEIC Choisi par plus
			de 5 millions de candidats chaque année et reconnu par des milliers d entreprises,
			le TOEIC vous permet d évaluer et de valoriser vos compétences en anglais professionnel.',7);
INSERT INTO MEDIATHEQUE.MEDIA( CATEGORIE_ID, TITRE, ANNEE, DESCRIPTION, JOURS_PRET)
		VALUES(SELECT CATEGORIE_ID FROM MEDIATHEQUE.CATEGORIE where NOM = 'VIDEO',
			'NASA : L Epopée de la Conquête Spatiale',2010,'Espace est plein de suprises
			que les hommes ne connaissent toujours pas encore.',10);


INSERT INTO MEDIATHEQUE.STOCK( media_id, quantite, date_intervenant) VALUES
		(SELECT media_id from MEDIATHEQUE.MEDIA where TITRE = 'Java pour les nuls', 5,2016-11-08 );
INSERT INTO MEDIATHEQUE.STOCK( media_id, quantite, date_intervenant) VALUES
		(SELECT media_id from MEDIATHEQUE.MEDIA where TITRE = 'ADMINISTREZ VOS BASES DE DONNÉES AVEC MYSQL', 15,2015-09-08 );
INSERT INTO MEDIATHEQUE.STOCK( media_id, quantite, date_intervenant) VALUES
		(SELECT media_id from MEDIATHEQUE.MEDIA where TITRE = 'DÉCOUVREZ LE LANGAGE SWIFT', 21,2016-10-23 );
INSERT INTO MEDIATHEQUE.STOCK( media_id, quantite, date_intervenant) VALUES
		(SELECT media_id from MEDIATHEQUE.MEDIA where TITRE = 'CONCEVEZ VOTRE SITE WEB AVEC PHP ET MYSQL', 9,2013-01-23 );
INSERT INTO MEDIATHEQUE.STOCK( media_id, quantite, date_intervenant) VALUES
		(SELECT media_id from MEDIATHEQUE.MEDIA where TITRE = 'TOEIC FOR TODAY', 20,2012-08-26 );
INSERT INTO MEDIATHEQUE.STOCK( media_id, quantite, date_intervenant) VALUES
		(SELECT media_id from MEDIATHEQUE.MEDIA where TITRE = 'NASA : L Epopée de la Conquête Spatiale', 30,2014-07-15 );
