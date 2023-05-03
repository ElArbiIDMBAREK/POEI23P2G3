@REQ_POEI23P2G3-2
Feature: Connexion à un compte
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Me connecter à mon compte 
	#
	#*Afin de* 
	#
	#Gérer mes commandes et mes informations personnelles 
	#
	#*_Règles de gestion_* : 
	#
	#*RG1* : Dans l'espace ""My Account"" un pavé ""Login"" permet de saisir son login et son mot de passe et de valider avec un bouton ""LOGIN"" 
	#
	#*RG2* : En se connectant à son compte l'écran ""Dashboard"" doit s'afficher, et des liens renvoyant aux pages suivantes sont présentes : Dashboard, Orders, Download, Adresses, Account Details, Logout 
	#
	#*RG3* : En cas de connexion avec un mot de passe erroné, un message ""ERROR: The password you entered for the username ""Email"" incorrect s'affiche 
	#
	#*RG4* : Une case à cocher ""Remember me"" permet de garder son login pré-rempli à la prochaine connexion

	@TEST_POEI23P2G3-45 @TESTSET_POEI23P2G3-127 @TNR
	Scenario Outline: Valider que l’utilisateur peut saisir son login, son mot de passe et se connecter via le bouton “LOGIN”
		Given je suis sur le espace My Account
		When je saisis un "<login>" dans le champ Login
		And je saisis un "<motDePasse>" dans le champ Login Mot De Passe
		And je clique sur le bouton LOGIN
		Then je verifie que je suis sur la page Dashboard
		
		Examples:
		| login                       | motDePasse     |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 |
	@TEST_POEI23P2G3-46 @TESTSET_POEI23P2G3-127 @TNR
	Scenario Outline: Valider que l'écran "Dashboard" s'affiche après la connexion
		Given je suis sur le espace My Account
		When je me connecte avec le "<login>" et le "<motDePasse>"
		Then je verifie que je suis sur la page Dashboard
		
		Examples:
		| login                       | motDePasse     |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 |
	@TEST_POEI23P2G3-49 @TESTSET_POEI23P2G3-127 @TNR
	Scenario Outline: Valider que les liens renvoyant aux pages Dashboard, Orders, Download, Adresses, Account Details et Logout sont présents
		Given je suis sur le espace My Account
		When je me connecte avec le "<login>" et le "<motDePasse>"
		Then je verifie que les liens sont presents
		And je verifie que le lien Dashboard renvoie a sa page
		And je verifie que le lien Orders renvoie a sa page
		And je verifie que le lien Download renvoie a sa page
		And je verifie que le lien Adresses renvoie a sa page
		And je verifie que le lien Account Details renvoie a sa page
		And je verifie que le lien Logout renvoie a sa page
		
		Examples:
		| login                       | motDePasse     |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 |
	@TEST_POEI23P2G3-52 @TESTSET_POEI23P2G3-127 @TNR
	Scenario Outline: Valider que l’utilisateur ne doit pas se connecter avec un login incorrect et/ou un mot de passe erroné
		Given je suis sur le espace My Account
		When je me connecte avec le "<login>" et le "<motDePasse>"
		Then je verifie que je suis sur le espace My Account
		
		Examples:
		| login                       | motDePasse     |
		| poei23p2g3.elarbi@gmail.com | XXXXXXXX       |
		| XXXX@XX.XX                  | Projet2Groupe3 |
	@TEST_POEI23P2G3-55 @TESTSET_POEI23P2G3-127 @TNR
	Scenario Outline: Valider que le message d’erreur ERROR: The password you entered for the username <Email> incorrect s’affiche en cas de mot de passe erroné
		Given je suis sur le espace My Account
		When je me connecte avec le "<login>" et le "<motDePasse>"
		Then je verifie que le "<message>" de erreur se affiche
		
		Examples:
		| login                       | motDePasse | message                                                                                    |
		| poei23p2g3.elarbi@gmail.com | XXXXXXXX   | Error: the password you entered for the username poei23p2g3.elarbi@gmail.com is incorrect. |
	@TEST_POEI23P2G3-56 @TESTSET_POEI23P2G3-127 @TNR
	Scenario Outline: Valider qu’une case à cocher “Remember me” permet de garder le login pré-rempli à la prochaine connexion
		Given je suis sur le espace My Account
		When je coche la case Remember Me
		And je me connecte avec le "<login>" et le "<motDePasse>"
		And je me deconnecte
		Then je verifie que le "<login>" est saisi
		
		Examples:
		| login                       | motDePasse     |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 |
