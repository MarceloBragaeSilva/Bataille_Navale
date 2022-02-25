# Bataille_Navale

BRAGA E SILVA, Marcelo

Le 25/02/2022

## Introduction
Ce projet fait partie du cours [IN205 : Applications Portables](https://synapses.ensta-paris.fr/catalogue/2020-2021/ue/3741/IN205-applications-portables?from=P1680)
de l'école ENSTA Paris. Il s'agit d'un jeu en Java de [Bataille Navale](https://fr.wikipedia.org/wiki/Bataille_navale_(jeu))
singleplayer contre la machine IA.

## Exécution du code
Le projet a été développé avec Maven. Pour l'installer, utilisez la commande suivante:
- sudo apt-get install maven

Pour lancer le projet, entrez dans le fichier 'bataille navale squelette' et exécuter la commande suivante:
- mvn clean install exec:java

## Problèmes rencontrés lors du développement
- Avec Maven la débugage du code est devenu plus difficile, alors, il m'a fallu d'ajouter des prints pour avoir connaissance
de l'état du projet lorsqu'un problème imprévu apparaît. Aussi, j'ai eu des problèmes pour faire lancer le projet maven pour la prèmière fois.
- Comme le projet a été faite en se basant sur le squelette fourni, il y a eu des décisions de code qui j'ai pris qui marchaient bien pour un exercice donné,
mais que pour le prochain il faudrait changer le squelette pour qu'il puisse bien marcher, dans mon cas, l'énumération du tableau de chaque joueur.

## Ordre des exercices:
À la fin de chaque exercice un commit a été faite dans ce repositoire, alors, si vous voulez regarder le développement au fur et a mésure, vérifiez l'histoire de commits.
- Exercice 1: Affichage du board
- Exercice 2: Création des classes de navires
- Exercice 3: Placement des navires
- Exercice 4: Entrées utilisateur
- Exercice 5: État des navires et des frappes
- Exercice 6: Envoyer des frappes
- Exercice 7: Intelligence artificielle
- Exercice 8: Place au jeu


