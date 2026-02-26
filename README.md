# 📁 Gestion Fichier — Invite de Commande Java

Un simulateur d'invite de commande en Java permettant de gérer un système de fichiers virtuel en mémoire, avec persistance via sérialisation. Réalisé dans le cadre du cours de **Programmation Orientée Objet (POO)** — S3.

---

## 🗂️ Structure du Projet

```
gestion-fichier2/
├── src/
│   └── gestion/fichier2/
│       ├── Main.java                  # Point d'entrée
│       ├── cli/                       # Couche commandes (interface utilisateur)
│       │   ├── Commande.java          # Classe abstraite de base
│       │   ├── Navigateur.java        # Singleton — gestion du répertoire courant
│       │   ├── ParseurCommande.java   # Parseur de la saisie utilisateur
│       │   ├── CmAide.java            # HELP
│       │   ├── CmCD.java              # CD
│       │   ├── CmCp.java              # CP
│       │   ├── CmMv.java              # MV
│       │   ├── CmRm.java              # RM
│       │   ├── CmLs.java              # LS
│       │   ├── CmMkdir.java           # MKDIR
│       │   ├── CmTouch.java           # TOUCH
│       │   ├── CmQuitter.java         # EXIT
│       │   └── CmInconnue.java        # Commande non reconnue
│       └── metier/                    # Couche métier (modèle)
│           ├── Fichier.java           # Classe abstraite — entité de base
│           ├── FichierSimple.java     # Fichier avec contenu texte
│           └── Repertoire.java        # Dossier contenant d'autres fichiers
├── build.xml
└── manifest.mf
```

---

## ✨ Fonctionnalités

| Commande | Description |
|----------|-------------|
| `HELP` | Affiche la liste des commandes disponibles |
| `LS [rep]` | Liste le contenu du répertoire courant (ou d'un sous-répertoire) |
| `CD <chemin>` | Change le répertoire courant (supporte `.`, `..`, et chemins multi-niveaux) |
| `MKDIR <nom>` | Crée un nouveau répertoire dans le répertoire courant |
| `TOUCH <nom>` | Crée un fichier simple dans le répertoire courant |
| `CP <source> <dest>` | Copie un fichier vers un répertoire de destination |
| `MV <source> <dest>` | Déplace un fichier vers un répertoire de destination |
| `RM <nom>` | Supprime un fichier ou répertoire |
| `EXIT` | Sauvegarde l'état et quitte le programme |

---

## 🏗️ Architecture & Concepts POO Appliqués

### Héritage
`Fichier` (abstraite) est la classe de base dont héritent `FichierSimple` et `Repertoire`. Chaque sous-classe implémente les méthodes abstraites `copier()`, `getTaille()`, et `estRepertoire()`.

### Patron de conception — Commande *(Command Pattern)*
Chaque commande CLI est une classe concrète héritant de `Commande`. Le `ParseurCommande` instancie la bonne commande selon la saisie, et `executer()` est appelé de manière uniforme.

### Patron de conception — Singleton
`Navigateur` est un singleton qui maintient l'état du répertoire courant tout au long de l'exécution.

### Composite *(implicite)*
Un `Repertoire` contient une liste de `Fichier` (qui peuvent eux-mêmes être des `Repertoire`), formant ainsi une structure arborescente récursive.

### Persistance
Le système de fichiers virtuel est sauvegardé et restauré via **sérialisation Java** (`ObjectOutputStream` / `ObjectInputStream`). La sauvegarde est déclenchée à la sortie du programme (`EXIT`).

---

## ▶️ Lancement

### Prérequis
- **JDK 25** (configuré via NetBeans comme plateforme `JDK_25`)
- **Apache Ant** (intégré à NetBeans)

### Depuis NetBeans
1. Ouvrir le projet `gestion-fichier2`
2. Cliquer sur **Run Project** (F6)

### Depuis le terminal (avec Ant)
```bash
ant run
```

### Depuis le JAR compilé
```bash
java -jar dist/gestion-fichier2.jar
```

---

## 💡 Exemple d'utilisation

```
        ---INVITE DE COMMANDE : Gestion Fichier---
C:\Users\EDOHB\\root>mkdir documents
Repertoire documents cree avec succes
C:\Users\EDOHB\\root>cd documents
C:\Users\EDOHB\\root\documents>touch rapport.txt
Fichier simple rapport.txt cree avec succes
C:\Users\EDOHB\\root\documents>ls
rapport.txt
C:\Users\EDOHB\\root\documents>cd ..
C:\Users\EDOHB\\root>exit
Voulez-vous vraiment quitter (o/n) ? o
A bientot !
```

---

## 📌 Notes

- Le fichier de sauvegarde est stocké localement à l'emplacement défini dans `Fichier.java` (`fichier.ser`). Pensez à adapter ce chemin si vous changez de machine.
- La navigation multi-niveaux avec `/` est supportée : `cd dossierA/dossierB`.
- Le répertoire racine est `\root` et ne peut pas être supprimé.

---

## 👤 Auteur

**EDOH BEDI Komi Godwin** — Semestre 3 (2025-2026), cours de Programmation Orientée Objet — EPL
