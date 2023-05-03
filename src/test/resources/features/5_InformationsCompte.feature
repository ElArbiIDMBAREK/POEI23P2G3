@REQ_POEI23P2G3-5
Feature: Informations du compte
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Depuis la page "My Account" visualiser mes informations de compte 
	#
	#*Afin de* 
	#
	#Pouvoir gérer mon compte 
	#
	#*_Règles de gestion :_* 
	#
	#*RG1* : Dans la page "My Account", un lien "Account Details" redirige vers les informations de comptes (nom prénom, mail) 
	#
	#*RG2* : Un espace permet de changer son mot de passe, l'utilisateur doit saisir son mot de passe actuel, saisir un nouveau mot de passe et le confirmer. En cas de succés un message "Account details changed successfully." s'affiche, sinon un message d'erreur s'affiche suivant la nature du problème ("Your current password is incorrect.", "New passwords do not match.")

	@TEST_POEI23P2G3-42 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que les informations de compte “nom, prénom, e-mail” sont présentes dans la page “Account Details”
		Given je suis sur le espace My Account
		And je me connecte avec le "<login>" et le "<motDePasse>"
		When je accede a la page Account Details
		Then je verifie que le "<prenom>" est saisi dans le champ Account Details Prenom
		And je verifie que le "<nom>" est saisi dans le champ Account Details Nom
		And je verifie que le "<login>" est saisi dans le champ Account Details Login
		
		Examples:
		| prenom | nom      | login                       | motDePasse     |
		| ElArbi | IDMBAREK | poei23p2g3.elarbi@gmail.com | Projet2Groupe3 |
	@TEST_POEI23P2G3-47 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider qu’un espace permettant le changement de mot de passe est présent dans la page “Account details” et que l’utilisateur à la capacité de saisir son mot de passe actuel et son nouveau mot de passe ainsi que la confirmation de son nouveau mot de passe
		Given je suis sur le espace My Account
		And je me connecte avec le "<login>" et le "<motDePasse>"
		When je accede a la page Account Details
		And je saisi un "<motDePasse>" dans le champ Account Details Current Password
		And je saisi un "<nouveauMotDePasse>" dans le champ Account Details New Password
		And je saisi un "<nouveauMotDePasse>" dans le champ Account Details Confirm New Password
		Then je verifie que le "<motDePasse>" est saisi dans le champ Account Details Current Password
		And je verifie que le "<nouveauMotDePasse>" est saisi dans le champ Account Details New Password
		And je verifie que le "<nouveauMotDePasse>" est saisi dans le champ Account Details Confirm New Password
		
		Examples:
		| login                       | motDePasse     | nouveauMotDePasse |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 | Projet2Groupe3    |
	@TEST_POEI23P2G3-54 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider qu'un message "Account details changed successfully" s'affiche lorsque l'utilisateur a réussi à changer son mot de passe
		Given je suis sur le espace My Account
		And je me connecte avec le "<login>" et le "<motDePasse>"
		When je accede a la page Account Details
		And je saisi un "<motDePasse>" dans le champ Account Details Current Password
		And je saisi un "<nouveauMotDePasse>" dans le champ Account Details New Password
		And je saisi un "<nouveauMotDePasse>" dans le champ Account Details Confirm New Password
		And je clique sur le bouton SAVE CHANGES
		Then je verifie que le "<message>" se affiche
		
		Examples:
		| login                       | motDePasse     | nouveauMotDePasse | message                               |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 | Projet2Groupe3    | Account details changed successfully. |
	@TEST_POEI23P2G3-58 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que le message “Your current password is incorrect” s’affiche lorsque l’utilisateur saisie un mot de passe actuel incorrect
		Given je suis sur le espace My Account
		And je me connecte avec le "<login>" et le "<motDePasse>"
		When je accede a la page Account Details
		And je saisi un "<motDePasse>" dans le champ Account Details Current Password
		And je saisi un "<nouveauMotDePasse>" dans le champ Account Details New Password
		And je saisi un "<nouveauMotDePasse>" dans le champ Account Details Confirm New Password
		And je clique sur le bouton SAVE CHANGES
		Then je verifie que le "<message>" de erreur se affiche
		
		Examples:
		| login                       | motDePasse | nouveauMotDePasse | message                             |
		| poei23p2g3.elarbi@gmail.com | XXXXXXXX   | Projet2Groupe3    | Your current password is incorrect. |
	@TEST_POEI23P2G3-117 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que le message “New passwords do not match” s’affiche si les deux nouveaux mots de passe ne correspondent pas
		Given je suis sur le espace My Account
		And je me connecte avec le "<login>" et le "<motDePasse>"
		When je accede a la page Account Details
		And je saisi un "<motDePasse>" dans le champ Account Details Current Password
		And je saisi un "<nouveauMotDePasse>" dans le champ Account Details New Password
		And je saisi un "<motDePasse>" dans le champ Account Details Confirm New Password
		And je clique sur le bouton SAVE CHANGES
		Then je verifie que le "<message>" de erreur se affiche
		
		Examples:
		| login                       | motDePasse     | nouveauMotDePasse | message                     |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 | XXXXXXXX          | New passwords do not match. |
