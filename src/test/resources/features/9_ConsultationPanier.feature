@REQ_POEI23P2G3-9
Feature: Consultation du panier
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Consulter mon panier 
	#
	#*Afin de* 
	#
	#Finaliser mes achats 
	#
	#*_Règles de gestion :_* 
	#
	#*RG1* : La page panier affiche un récapitulatif des articles ajoutés spécifiant la quantité, le prix unitaire et le prix total 
	#
	#*RG2* : Chaque article peut être supprimé par un bouton, la quantité de chaque article peut être modifié par le champ quantité 
	#
	#*RG3* : Au-dessous du récapitulatif des articles, un champ "Coupon code" et un bouton "APPLY COUPON" permettant d’apppliquer un code promotionnel sur la commande 
	#
	#*RG4* : Un pavé récapitulatif "Basket Totals" spécifie le prix total et la taxe associée 
	#
	#*RG5* : Un bouton "Proceed to Checkout" permet de valider la commande et de passer au paiement"

	@TEST_POEI23P2G3-22 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que l'utilisateur peut accéder à la page du panier et Vérifier qu’elle affiche un récapitulatif des articles ajoutés, avec la quantité, le prix unitaire et le prix total pour chaque article.
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le bouton Panier
		Then je verifie que un article est dans le panier
		And je verifie que un article a une quantite
		And je verifie que un article a un prix unitaire
		And je verifie que un article a un prix total
	@TEST_POEI23P2G3-23 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que chaque article peut être supprimé à l'aide d’un bouton
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le bouton Panier
		And je clique sur Supprimer Article
		Then je verifie que aucun article ne est present
	@TEST_POEI23P2G3-26 @TESTSET_POEI23P2G3-129 @TNR
	Scenario Outline: Valider que la quantité de chaque article peut être modifiée à l’aide d’un champ de quantité
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le lien View Basket
		And je modifie la case Quantity a "<quantite>"
		Then je verifie que la quantite egale a "<quantite>"
		
		Examples:
		| quantite |
		| 4        |
	@TEST_POEI23P2G3-30 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider la présence d’un pavé récapitulatif  “Basket Totals” indiquant le prix total et la taxe associée
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le bouton Panier
		Then je verifie que je suis sur la page Basket
	@TEST_POEI23P2G3-32 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que le bouton "Proceed to Checkout " est présent et qui permet de valider la commande et passer au paiement
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le bouton Panier
		And je clique sur le bouton Proceed to Chekout
		Then je verifie que je suis sur la page Paiement
