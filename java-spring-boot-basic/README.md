# Spring Hackathon

Bienvenue dans le Spring Hackathon dédié au Ministère des Armées !

## Sommaire

<!-- TOC -->
* [Accès à la plateforme](#accès-à-la-plateforme)
* [Initialiser votre Application](#initialiser-votre-application)
* [Démarrer votre Application localement](#démarrer-votre-application-localement)
* [Déployer votre Application dans Kubernetes](#déployer-votre-application-dans-kubernetes)
* [Concours](#concours)
  * [Somme de deux entiers](#somme-de-deux-entiers)
  * [Consommation d'un API externe](#consommation-dun-api-externe)
<!-- TOC -->

## Accès à la plateforme

* Si vous n'en avez pas déjà, créer un compte [VMware Customer Connect](https://customerconnect.vmware.com/account-registration)
* Se connecter sur [VMware Customer Connect](https://customerconnect.vmware.com/login)
* Se connecter sur la [Tanzu Academy](https://tanzu.academy/) en utilisant le compte créé précédemment
* Accéder au Lab dédié [ici](https://tanzu.academy/guides/tap-freeform)

## Initialiser votre Application

* Se rendre dans l'onglet `Editor`
* Cliquer sur l'icône Tanzu App Accelerator
* Sélectionner `Spring Hackathon`
* Dans `project-name` mettez votre nom d'équipe
* Next Step > Generate Project > Valider tous les paramètres par défaut _(cliquer sur Ok)_
* Cliquer sur `No` sur toutes les Popups qui s'ouvriront

Votre application est initialisée !

## Démarrer votre Application localement

* Déplier le sous menu `Java Projects`
* Dans `src/main/java` dans le package `com.example.springboot` > Application.java
* Cliquer sur `Run` au dessus de `public static void main(String[] args)`
* Cliquer sur `Disable` sur les Popup qui s'ouvrent
* Ne pas cliquer sur `Open in Browser`
* Se rendre dans l'onglet `Terminal` et tester que votre application est fonctionnelle

```shell
http localhost:8080/hello
```

* Se rendre dans l'onglet `Editor` et arrêter l'application avec `Ctrl+c`, ou cliquer sur l'icône de fermeture de Terminal _(poubelle)_

## Déployer votre Application dans Kubernetes

* Se rendre dans le l'onglet `Terminal`

```shell
# Se déplacer dans le bon dossier
cd <your_app_path> # Doit être sous /home/eduk8s/

# Déployer l'Application
tanzu apps workload apply --file ./config/workload.yaml --local-path . --update-strategy replace

# Suivre le statut - Utilisez le nom de votre App !
tanzu apps workload get spring-hackathon
tanzu apps workload tail spring-hackathon --timestamp --since 1h
```

* Attendre que votre Application soit déployée _(la première fois, cela peut prendre environ 5 minutes)_
* Récupérer l'url de votre Application

```shell
tanzu apps workload get spring-hackathon
```
![status.png](doc/status.png)

* Accédez à votre application sur cette url
* Renseigner cette url dans le [formulaire d'inscription d'équipe](https://docs.google.com/forms/d/e/1FAIpQLSdSvywAeJG8FpwL8718BDbUp8AsIzyQY_j9WaNa5r2emm9UqQ/viewform)

> 🚀 Félicitations vous venez de réaliser avec succès la première étape !

> 🎁 Faites signe aux organisateurs pour comptabiliser vos points bonus.

* Vous pouvez supprimer le déploiement de votre application si vous le souhaitez.

```shell
tanzu apps workload delete spring-hackathon
```

## Concours

Vous allez désormais devoir réaliser deux APIs.

Avec les éléments que nous avons vu précédemment, nous vous invitons à développer les APIs localement, puis à les déployer sur la plateforme afin de valider vos points !

### Somme de deux entiers

Vous allez devoir développer une API qui retourne la somme de deux entiers.

* L'API à la signature suivante: `/calc/add?a=int1&b=int2`
* Elle répond sur `/calc/add`
* Prend en paramètre deux entiers sous les paramètres a et b
* Elle retourne un résultat au format json avec le format suivant :

```json
{"value":35}
```

> 🎁 Faites signe aux organisateurs pour comptabiliser vos points bonus.

### Consommation d'un API externe

Vous allez développer un API qui va récupérer des informations depuis un site externe.

* L'API à la signature suivante: `/todos/{todoId}`
* Prend en paramètre un identifiant de tâche représenté par `{todoId}`
* Va récupérer les informations depuis https://jsonplaceholder.typicode.com/todos/{todoId}
* Retourne le résulat tel que lu sur l'API externe sous forme de String

```json
{
  "userId": 1,
  "id": 5,
  "title": "laboriosam mollitia et enim quasi adipisci quia provident illum",
  "completed": false
}
```

> 🎁 Faites signe aux organisateurs pour comptabiliser vos points bonus.
