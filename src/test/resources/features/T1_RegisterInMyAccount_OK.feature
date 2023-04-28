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

	@TEST_POEI23P2G3-24 @TNR
	Scenario Outline: Valider que le pavé Register est présent sur l’espace My Account
		When je entre le "<url>" dans la barre de recherche
		Then je verifie que le pave Register est present sur le espace My Account
		
		Examples:
		| url                                    |
		| https://practice.automationtesting.in/ |
