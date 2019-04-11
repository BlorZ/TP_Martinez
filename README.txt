Bonjour, 
Voici mon TP intergiciel. C'est une revisite de street fighter 2.

voici les fonctionnalités du site: 

- Instructions pour faire un combat:  
	1) créer un compte
	2) créer un personnage
	3) créer ou intégrer(si il en existe une) une ligue
	4) 2 choix pour combattre : 	
		a) choisir un personnage ennemi via la page ligue 
		b) depuis la page d'accueil
	5) choisir votre personnage 
	6) le combat se lance, et appuyer sur next après les animations

- Partie personnages: 
	- vous pouvez créer un personnage avec le nombre de points que vous souhaitez (avec une limite de point suivant les points de votre compte)
	- vous pouvez modifier un personnage. Lors d'une modification, vous pouvez changer le personnage ainsi que ses points. Les points du personnage reviennent sur le compte 
			et le personnage se met a jour avec le nombre de points souhaité.
	- vous pouvez aussi supprimer le personnage, les points reviennent sur le compte. 

-Partie Ligue : 
	- quand le compte vient d'être créé, vous n'avez pas de ligue, un message s'affiche l'indiquant.
	- vous pouvez créer une ligue, en faisant "Changer de ligue", puis "Créer une ligue".
	- quand vous créez une ligue, celle-ci prend en référence votre personnage le plus fort et
			pour pouvoir combattre, des bots sont créés avec un personnage chacun qui possède un nombre de points 
			entre +/- 20% des points de votre personnage.
	- vous pouvez également intégrer un ligue seulement si vous avez un personnage ayant un nombre de points cohérent avec ceux de la ligue.
	- vous pouvez quitter votre ligue courrante. Si vous êtes le seul joueur dans cette ligue (vrai utilisateur), la ligue se supprime également.
	- vous ne pouvez pas vous attaquer vous meme.
	- vous pouvez consulter toutes les ligues créées.
	- vous ne pouvez pas accéder à la page ligue tant que vous n'avez pas créé de personnage.
	- une erreur est affichée si vous essayez de rejoindre votre ligue courrante.
	- vous ne pouvez pas créer de ligue si vous êtes déjà dans une ligue. Quittez d'abord votre ligue pour en créer une.
	- vous ne pouvez pas attaquer un joueur qui n'est pas dans votre ligue.
	
-Partie Combat:
	- Vous avez deux choix pour combattre :
			- en passant par la page de ligue: vous pouvez voir les personnages de votre ligue et appuyer sur le bouton avec un poing pour le combattre.
			- en passant par la page d'accueil, où ici cela sera un joueur aléatoire de votre ligue.
	- Ensuite vous devez choisir le personnage que vous voulez faire combattre : sur cette page, il n'y a que les personnages avec des points 
			correspondant aux points moyens de la ligue. Vous pouvez en avoir un ou plusieurs. Les personnages qui ne sont pas dans la fourchettes de points ne sont pas affichés.
	- Ensuite l'écran de combat, ici un nombre de points aléatoire entre +/- 20% des points du personnage est généré pour les deux combattant. Celui avec la valeur la plus grande gagne.
			Cela permet aussi qu'un personnage moins fort puisse gagner avec de la chance.
	- Après le combat, les points des deux joueurs sont modifiés. Lors d'une victoire, le joueur gagne 100 points sinon il en perd 100. (/!\ ce sont bien les points
			 des joueurs qui sont modifiés et pas ceux des personnages). Quand les points des joueurs sont inférieurs à 0, des personnages sont supprimés jusqu'à 
			 ce que les points du joueur soient positifs. Si le joueur n'a plus de personnage et qu'il a des points négatifs, c'est le game over. L'utilisateur a encore accès à
			 ce super site mais il ne pourra plus faire d'action.
			
- Partie Historique:
	- En apuyant sur la touche "next" après les animations du combat, cela va enregistrer le résultat du combat dans l'historique du joueur principal mais aussi dans
			 l'historique du 2e joueur	si celui ci n'est pas un bot. Le résultat impacte aussi les points du joueur adverse et celui ci verra le résultat dans son historique.
	- l'historique sera également visible depuis la page d'accueil via le bouton "Historique des combats".
	- dans l'historique, les 5 derniers combats seront affichés.
			

- Divers: 
	- une page tous les personnages affiche les personnages que l'ont peut créer et utiliser.
	- Pour manipuler plusieurs compte a la fois, il faut ouvrir une page du navigateur en mode privée. (sous firefox Crtl+Maj+P). En effet, on dirait qu'il y a des cookies
			 qui sont sauvegardés et si l'on ouvre un simple onglet et retourne sur le site, on sera directement connecté sur le compte que l'on manipule déjà.
	- divers message d'erreurs lorsque l'on essaie des choses douteuses.		 
	- en cas d'égalité lors d'un combat (qui est extrèmement rare), c'est le joueur qui a lancé l'attaque qui remporte le combat, car il a pris l'avantage en attaquant par surprise!
	- petit tuyau si vous vous prenez au jeu, quand vous avez lancé un combat depuis l'écran d'accueil, vous pouvez faire un f5 pour changer d'adversaire jusqu'à gagner la partie,
			le traitement du résultat se lance à partir du bouton next. J'aurais pu faire le traitement avant l'écran de combat mais je ne voulais pas que vous tombiez 
			game over pendant les tests du site ;)
	
	