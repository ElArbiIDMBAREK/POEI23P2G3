@REQ_POEI23P2G3-6
Feature: Déconnexion
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Me déconnecter 
	#
	#*Afin de* 
	#
	#Ne plus pouvoir accèder à mon espace client 
	#
	#*_Règles de gestion :_* 
	#
	#*RG1* : Dans l'espace "My Account" un lien "Logout" permet la déconnexion, la page Account affiche les pavé de "Login" et de "Register"

	@TEST_POEI23P2G3-60 @TNR
	Scenario Outline: Valider que l’utilisateur peut se déconnecter via le lien “Logout”
		Given je suis sur le espace My Account
		And je me connecte avec le "<login>" et le "<motDePasse>"
		When je me deconnecte
		Then je verifie que je suis sur le espace My Account
		
		Examples:
		| login                       | motDePasse     |
		| poei23p2g3.elarbi@gmail.com | Projet2Groupe3 |
