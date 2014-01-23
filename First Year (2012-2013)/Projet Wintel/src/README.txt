Avancement du projet :

Toutes les fonctionnalités obligatoires ont été implémentées, l'interface graphique est complète.
L'application a été testée, son fonctionnement est correct et correspondant à celui attendu. 


------------------------------------------------------------- fonctionnalités obligatoires -------------------------------------------------------------------------------- 


						A) pour l'interface graphique : 

* l'interface graphique est non-redimensionnable, afin d'éviter des soucis d'ajustement lors de l'agrandissement ou du rétrécissement de la fenêtre.



						B) pour la partie Fichier : 

* La  partie "Sauvegarder" pour pouvoir sauvegarder par sérialisation l'annuaire avec les contacts rajoutés si il y en a dans un fichier annuaire.out
avec une fenêtre de confirmation qui s'affiche une fois la sauvegarde effectuée.

* La partie "Charger" qui permet de charger un fichier Annuaire.out, celui étant un annuaire sous forme binaire (précédemment sauvegardé par exemple).

* La partie "Quitter" qui ferme l'application Wintel après confirmation par l'utilisateur (pour éviter les clics par erreur).



						C) pour la partie Contact :

* affichage des informations du contact dans la partie de droite quand on clique sur celui-ci.

* La partie "Ajouter" qui permet d'entrer un nouveau contact dans l'annuaire (il faut au minimum entrer son nom sinon un message d'erreur s'affiche.

* La partie "Modifier" qui permet de changer les informations d'un contact après clic sur ce contact dans la liste à gauche.
Il faut également ne pas laisser de champ vide pour le nom sinon un message d'erreur s'affiche.
D'autre part, les champs contenant les informations du contact sont directement remplis lors de l'ouverture de la fenêtre "Modifier".
Une vérification du nom du contact à modifier à été mise en place, et un message d'erreur s'affiche si celui-ci n'est pas présent dans l'annuaire 

* La partie "Supprimer" permettant de supprimer un contact de l'annuaire, avec les mêmes conditions de vérification que pour la partie "Modifier".



						D) pour la partie "Aide" : 

* affichage d'une fenêtre d'aide contenant des explications sur le projet Wintel


---------------------------------------------------------- fonctionnalités bonus mises en places --------------------------------------------------------------------------

* Mise en place d'une réaction au bouton "Composer" : une fenêtre de confirmation s'ouvre indiquant que la composition du numéro est en cours.
* Au moment de quitter, si l'utilisateur vient d'ajouter ou de modifier un contact sans avoir sauvegardé, une fenêtre de confirmation
demande à l'utilisateur si il souhaite réaliser une sauvegarde avant de fermer l'application.



