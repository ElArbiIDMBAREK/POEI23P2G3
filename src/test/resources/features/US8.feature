@REQ_POEI23P2G3-8
Feature: Détails des articles
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Accéder aux détails des articles 
	#
	#*Afin d'* 
	#
	#Obtenir des informations sur les articles en vente 
	#
	#*_Règles de gestion :_* 
	#
	#*RG1* : Les articles sont présentés par une photographie, un détail descriptif, son prix et le nombre d'exemplaires encore disponible 
	#
	#*RG2* : Un bouton "ADD TO BASKET" permettant d'ajouter l'article au panier. Un champ permet d'indiquer le nombre d'exemplaire voulu 
	#
	#*RG3* : A chaque ajout, un message “'libellé' has been added to your basket." et un bouton "VIEW BASKET" permettant de se rediriger dans l'espace panier, apparaissent au-dessus l'article

	@TEST_POEI23P2G3-18 @TNR
	Scenario Outline: Valider que les articles sont présenté par une photographie, un prix, un details descriptif et le nombre d’exemplaires encore disponible
		Given je suis sur la page Shop
		When je clique sur le article "<indexArticle>"
		Then je verifie que le article a une image
		And je verifie que le article a une prix
		And je verifie que le article a un detail
		And je verifie que le article a le nombre de exemplaire disponible
		
		Examples:
		| indexArticle |
		| 1            |
		| 4            |

	@TEST_POEI23P2G3-20 @TNR
	Scenario: Valider que le bouton ADD TO BASKET permet d’ajouter l’article au panier
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le bouton Panier
		Then je verifie que un article est dans le panier

	@TEST_POEI23P2G3-21 @TNR
	Scenario: Valider la présence d’un champ qui permet à l’utilisateur d'indiquer le nombre d’exemplaire d’articles voulu
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le bouton Panier
		Then je verifie que un champ quantite est present

	@TEST_POEI23P2G3-124 @TNR
	Scenario Outline: Valider qu'à chaque ajout, un message “'libellé' has been added to your basket." et un bouton "VIEW BASKET" permettant de se rediriger dans l'espace panier, apparaissent au-dessus l'article
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		Then je verifie que le "<message>" se affiche
		And je verifie que le lien View Basket est present
		
		Examples:
		| message                        |
		| has been added to your basket. |
