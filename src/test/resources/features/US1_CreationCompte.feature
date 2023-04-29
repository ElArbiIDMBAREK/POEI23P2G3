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

	@TEST_POEI23P2G3-16 @TNR
	Scenario Outline: Valider que la création d'un compte ne se fait pas avec un mot de passe non conforme (à minima de 7 caractères et contenir à minima une majuscule, une minuscule, un chiffre et un caractère spécial)
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Mail
		And je saisis un "<motDePasse>" dans le champ Mot De Passe
		And je clique sur le bouton REGISTER
		Then je verifie que la creation du compte a echouee
		
		Examples:
		| mail                    | motDePasse  |
		| 01poei23p2g3.16@gmail.com | aqzsedrftgy |

	@TEST_POEI23P2G3-24 @TNR
	Scenario Outline: Valider que le pavé Register est présent sur l’espace My Account
		When je entre le "<url>" dans la barre de recherche
		Then je verifie que le pave Register est present sur le espace My Account
		
		Examples:
		| url                                    |
		| https://practice.automationtesting.in/ |

	@TEST_POEI23P2G3-31 @TNR
	Scenario Outline: Valider que l'utilisateur peut saisir son nom et son prénom dans les champs appropriés
		Given je suis sur le espace My Account
		When je saisis un "<nom>" dans le champ Nom
		And je saisis un "<prenom>" dans le champ Prenom
		Then je verifie que le "<nom>" est saisi dans le champ Nom
		And je verifie que le "<prenom>" est saisi dans le champ Prenom
		
		Examples:
		| nom      | prenom |
		| idmbarek | elarbi |

	@TEST_POEI23P2G3-33 @TNR
	Scenario: Valider que le bouton « REGISTER » est présent
		Given je suis sur le espace My Account
		Then je verifie que le bouton REGISTER est present

	@TEST_POEI23P2G3-34 @TNR
	Scenario Outline: Valider que l'utilisateur peut valider la création du compte en cliquant sur le bouton REGISTER
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Mail
		And je saisis un "<motDePasse>" dans le champ Mot De Passe
		And je clique sur le bouton REGISTER
		Then je verifie que le compte est cree
		
		Examples:
		| mail                    | motDePasse     |
		| 01poei23p2g3.34@gmail.com | Projet2Groupe3 |

	@TEST_POEI23P2G3-38 @TNR
	Scenario Outline: Valider que le système détecte les doublons pour le mail et empêche la création de plusieurs comptes avec le même mail
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Mail
		And je saisis un "<motDePasse>" dans le champ Mot De Passe
		And je clique sur le bouton REGISTER
		And je me deconnecte
		And je saisis un "<mail>" dans le champ Mail
		And je saisis un "<motDePasse>" dans le champ Mot De Passe
		And je clique sur le bouton REGISTER
		Then je verifie que le compte ne pas ete cree
		And je verifie que le "<messageErreur>" se affiche
		
		Examples:
		| mail                    | motDePasse     | messageErreur                                                                  |
		| 01poei23p2g3.38@gmail.com | Projet2Groupe3 | Error: An account is already registered with your email address. Please login. |

	@TEST_POEI23P2G3-108 @TNR
	Scenario Outline: Valider que l'utilisateur peut saisir un mail et un mot de passe dans les champs appropriés
		Given je suis sur le espace My Account
		When je saisis un "<mail>" dans le champ Mail
		Then je saisis un "<motDePasse>" dans le champ Mot De Passe
		And je verifie que le "<mail>" est saisi dans le champ Mail
		And je verifie que le "<motDePasse>" est saisi dans le champ Mot De Passe
		
		Examples:
		| mail                     | motDePasse    	|
		| 01poei23p2g3.108@gmail.com | Projet2Groupe3 |
