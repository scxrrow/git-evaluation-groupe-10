# Projet Minitrice Git - git-evaluation_groupe-10

Ce projet a été réalisé dans le cadre de l'évaluation du module Git. L'objectif est de créer un programme "Minitrice" capable d'effectuer des opérations arithmétiques de base, tout en suivant l'historique de développement avec Git et le workflow GitFlow.

**Membres du Groupe :**
* FELTEN Noah

## Table des matières

* [Installation](#installation)
* [Exécution](#exécution)
    * [Mode Interactif](#mode-interactif)
    * [Mode STDIN (Pipe)](#mode-stdin-pipe)
    * [Gestion des Erreurs](#gestion-des-erreurs)
    * [Utilisation de Generator](#utilisation-de-generator)


## Installation

Ce projet est développé en Java. Pour le compiler et l'exécuter, vous aurez besoin du **JDK (Java Development Kit)** (version 11 ou supérieure).

1.  **Clonez le dépôt :**
    '''bash
    git clone git@github.com:scxrrow/git-evaluation-groupe-10.git
    cd git-evaluation_groupe-10
    '''

2.  **Compilez les programmes :**
    Il est inutile de complier les sources Java. Cela sera fait par les scripts

3.  **Rendez les scripts exécutables :**
    Les scripts `minitrice`, `generator` doivent avoir les permissions d'exécution.

    chmod +x minitrice
    chmod +x generator

Le projet est maintenant prêt à être utilisé.

## Exécution

Le projet contient deux programmes principaux : minitrice (la calculatrice) et generator (le générateur d'expressions).

### Mode Interactif

Lancez ./minitrice pour démarrer le programme. Vous pouvez entrer des calculs un par un. Quittez avec Ctrl+D.

'''bash
$ ./minitrice
> 3+9
12.00
> 100 / 3
33.33
> Fin des calculs
$ echo $?
0
'''

### Mode STDIN (Pipe)

Le programme minitrice peut lire depuis l'entrée standard (STDIN), lui permettant d'être "pipé" avec d'autres commandes comme echo ou cat.

Avec echo :
bash'''
$ echo "3+12" | ./minitrice
15.00
$ echo $?
0
'''

Avec cat (sur good-expression.txt) :
'''bash
$ cat test/good-expression.txt | ./minitrice
4.00
11.00
35.00
-4.00
12.00
90.00
4.00
8.00
10.00
4.00
$
'''

### Gestion des Erreurs

Le programme gère les erreurs de syntaxe et les divisions par zéro, et retourne un code de sortie 1 en cas d'erreur.

Erreur de syntaxe :
'''bash
$ echo "3+*12" | ./minitrice
Erreur de syntaxe pour le calcul: "3+*12"
$ echo $?
1
'''
Division par zéro :
'''bash
$ echo "3/0" | ./minitrice
Division par zéro
$ echo $?
1
'''
### Utilisation de Generator
Le programme generator prend un entier en argument et génère ce nombre d'expressions aléatoires.
'''bash
$ ./generator 2
7-9
84/12
'''
Il peut être composé avec minitrice pour tester les calculs.
'''bash
$ ./generator 2 | ./minitrice
-2.00
7.00
'''