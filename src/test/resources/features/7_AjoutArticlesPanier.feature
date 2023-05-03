@REQ_POEI23P2G3-7
Feature: Ajout des articles au panier
	#*En tant qu'* 
	#
	#Utilisateur 
	#
	#*Je souhaite* 
	#
	#Depuis la page ""Shop"", ajouter des articles dans mon panier 
	#
	#*Afin de* 
	#
	#Pouvoir passer des commandes 
	#
	#*_Règles de gestion :_* 
	#
	#*RG1* : La page "Shop" contient les articles en vente 
	#
	#*RG2* : Chaque article possède un bouton "ADD TO BASKET" permettant d'ajouter l'article au panier. A chaque ajout, un lien ""VIEW BASKET"" apparaît au-dessous l'article, si l'article n'est pas en stock, un bouton "READ MORE" apparaît à la place du bouton "ADD TO BASKET" 
	#
	#*RG3* : Le lien ""View Basket"" redirige vers le panier. Le panier peut être consulté depuis toutes les pages avec un lien contenu dans une icône en entête 
	#
	#*RG4* : Un filtre permet d'affiner la vue des articles par prix 
	#
	#*RG5* : Un filtre permet d'affiner la vue des articles par thème 
	#
	#*RG6* : Chaque article contient une photo descriptive, un libellé et le prix affiché au-dessous. Un lien actif sur ces 3 éléments redirige vers le détail de l'article

	@TEST_POEI23P2G3-67 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que la page “Shop” contient les articles de vente
		Given je suis sur la page Shop
		Then je verifie que un article existe
	@TEST_POEI23P2G3-69 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que le bouton “ADD TO BASKET” est disponible sur la page “Shop” pour permettre à l'utilisateur d’ajouter un article à son panier
		Given je suis sur la page Shop
		Then je verifie que le bouton ADD TO BASKET est present
	@TEST_POEI23P2G3-76 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que le bouton “READ MORE” apparait sur la page “Shop” quand l’utilisateur ne peut pas ajouter d’article dans le panier 
		Given je suis sur la page Shop
		Then je verifie que le bouton READ MORE est present
	@TEST_POEI23P2G3-80 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que le  lien “View basket” est présent et redirige l’utilisateur vers le panier
		Given je suis sur la page Shop
		When je clique sur le bouton ADD TO BASKET
		And je clique sur le lien View Basket
		Then je verifie que je suis sur la page Basket
	@TEST_POEI23P2G3-81 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que l'icône est présente dans toutes les pages et qui permettant à l’utilisateur  de consulter son panier
		Given je suis sur la page Home
		Then je verifie que la icone Panier est presente
	@TEST_POEI23P2G3-82 @TESTSET_POEI23P2G3-129 @TNR
	Scenario Outline: Valider que le filtre permet d’affiner la vue des articles par prix
		Given je suis sur la page Shop
		When je choisi le filtre "<filtre>"
		Then je verifie que les articles sont tries par ce "<filtre>"
		
		Examples:
		| filtre                     |
		| Sort by price: low to high |
		| Sort by price: high to low |
	@TEST_POEI23P2G3-83 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider que le filtre permet d’affiner la vue des articles par thème
		Given je suis sur la page Shop
		Then je verifie que les articles sont tries par theme
	@TEST_POEI23P2G3-84 @TESTSET_POEI23P2G3-129 @TNR
	Scenario: Valider la présence du lien qui redirige vers le détail de l’article et la présence des éléments  “Photo descriptive” “Libellé” et “Prix” au dessous de l’article
		Given je suis sur la page Shop
		Then je verifie que un article a une Photo
		And je verifie que un article a un Libelle
		And je verifie que un article a un Prix
		And je verifie que un article contient un lien
