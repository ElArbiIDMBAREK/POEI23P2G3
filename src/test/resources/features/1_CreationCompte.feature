@REQ_POEI23P2G3-1
Feature: Création de compte
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Créer un compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	# *_Règles de gestion :_* 
	#
	#*RG1* : Dans l'espace "My Account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" : 
	#
	#- En saisissant son nom et prénom 
	#
	#- En saisissant un mail et un mot de passe
	#
	# - En validant avec un bouton "REGISTER" 
	#
	#*RG2* : Le mot de passe doit être composé à minima de 7 caractères et contenir à minima une majuscule, une minuscule, un chiffre et un caractère spécial

	@TEST_POEI23P2G3-16 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que la création d'un compte ne se fait pas avec un mot de passe non conforme (à minima de 7 caractères et contenir à minima une majuscule, une minuscule, un chiffre et un caractère spécial)
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Register Mail
		And je saisis un "<motDePasse>" dans le champ Register Mot De Passe
		And je clique sur le bouton REGISTER
		Then je verifie que je suis sur le espace My Account
		
		Examples:
		| mail                    | motDePasse  |
		| poei23p2g3.16.03@gmail.com | aqzsedrftgy |
	@TEST_POEI23P2G3-24 @TESTSET_POEI23P2G3-126 @TNR
	Scenario: Valider que le pavé Register est présent sur l’espace My Account
		Given je suis sur la page Home
		When je clique sur le bouton My Account
		Then je verifie que le pave Register est present
	@TEST_POEI23P2G3-31 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que l'utilisateur peut saisir son nom et son prénom dans les champs appropriés
		Given je suis sur le espace My Account
		When je saisis un "<nom>" dans le champ Register Nom
		And je saisis un "<prenom>" dans le champ Register Prenom
		Then je verifie que le "<nom>" est saisi dans le champ Register Nom
		And je verifie que le "<prenom>" est saisi dans le champ Register Prenom
		
		Examples:
		| nom      | prenom |
		| idmbarek | elarbi |
	@TEST_POEI23P2G3-33 @TESTSET_POEI23P2G3-126 @TNR
	Scenario: Valider que le bouton « REGISTER » est présent
		Given je suis sur le espace My Account
		Then je verifie que le bouton REGISTER est present
	@TEST_POEI23P2G3-34 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que l'utilisateur peut valider la création du compte en cliquant sur le bouton REGISTER
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Register Mail
		And je saisis un "<motDePasse>" dans le champ Register Mot De Passe
		And je clique sur le bouton REGISTER
		Then je verifie que je suis sur la page Dashboard
		
		Examples:
		| mail                    | motDePasse     |
		| poei23p2g3.34.03@gmail.com | Projet2Groupe3 |
	@TEST_POEI23P2G3-38 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que le système détecte les doublons pour le mail et empêche la création de plusieurs comptes avec le même mail
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Register Mail
		And je saisis un "<motDePasse>" dans le champ Register Mot De Passe
		And je clique sur le bouton REGISTER
		And je me deconnecte
		And je saisis un "<mail>" dans le champ Register Mail
		And je saisis un "<motDePasse>" dans le champ Register Mot De Passe
		And je clique sur le bouton REGISTER
		Then je verifie que je suis sur le espace My Account
		And je verifie que le "<message>" de erreur se affiche
		
		Examples:
		| mail                    | motDePasse     | message                                                                        |
		| poei23p2g3.38.03@gmail.com | Projet2Groupe3 | Error: An account is already registered with your email address. Please login. |
	@TEST_POEI23P2G3-108 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que l'utilisateur peut saisir un mail et un mot de passe dans les champs appropriés
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Register Mail
		Then je saisis un "<motDePasse>" dans le champ Register Mot De Passe
		And je verifie que le "<mail>" est saisi dans le champ Register Mail
		And je verifie que le "<motDePasse>" est saisi dans le champ Register Mot De Passe
		
		Examples:
		| mail                     | motDePasse    	|
		| poei23p2g3.108.03@gmail.com | Projet2Groupe3 |
