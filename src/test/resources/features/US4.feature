@REQ_POEI23P2G3-4
Feature:  Ré-initialisation du mot de passe
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Ré-initialiser mon mot de passe oublié 
	#
	#*_Règles de gestion :_* 
	#
	#*RG1* : Un lien "Lost your password?" doit rediriger vers une page permettant de saisir son login et de valider la demande de ré-initialisation 
	#
	#*RG2* : La demande validée génére l'envoi automatique d'un lien de réinitialisation dans la boite mail de l'utilisateur 
	#
	#*RG3*: Le lien reçu dans le mail renvoi vers une page de l'application permettant de saisir un nouveau mot de passe. L'utilisateur doit re-confirmer son mot de passe

	@TEST_POEI23P2G3-59 @TESTSET_POEI23P2G3-126 @TNR
	Scenario: Valider que le lien "Lost your password?" redirige vers une autre page
		Given je suis sur le espace My Account
		When je clique sur le lien lost your password
		Then je verifie que je suis rediriger vers la page lost password

	@TEST_POEI23P2G3-61 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Vérifier que la réinitialisation du mot de passe est validée en se reconnectant avec les nouveaux identifiants
		Given je suis sur le espace My Account
		When je saisis un "<login>" dans le champ Login
		And je saisis un "<motDePasse>" dans le champ Login Mot De Passe
		And je clique sur le bouton LOGIN
		Then je verifie que je suis sur la page Dashboard

		Examples:
			| login                        | motDePasse |
			| poei23p2g3.aissa@yopmail.com |            |

	@TEST_POEI23P2G3-62 @TESTSET_POEI23P2G3-126 @TNR
	Scenario Outline: Valider que le lien reçu dans le mail renvoie vers une page de l'application qui permet la saisie d’un nouveau mot de passe
		Given je suis sur le espace My Account
		When je clique sur le lien lost your password
		And je saisis mon "<email>"
		And je clique sur le bouton reset password
		Then je verifie que je recois un lien avec le "<email>" de réinitialisation dans ma boite email
		
		Examples:
			| email                        |
			| poei23p2g3.aissa@yopmail.com |

	@TEST_POEI23P2G3-63 @TESTSET_POEI23P2G3-126 @TNR
	Scenario: Valider que la page de l’application permet à l’utilisateur de saisir un nouveau mot de passe et de re-confirmer son mot de passe

