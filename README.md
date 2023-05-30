# m2i_frontoffice

## Prérequis

- Avoir un serveur mysql
- Installer apache tomcat 10
```http request
https://tomcat.apache.org/download-10.cgi
```
- Installer une version de java supérieur à 8
- Installer maven


## BDD

Executer le script se trouvant dans le projet Backoffice <br>
src.main.ressources.sql.create_bdd.sql

## Backoffice

Cloner le repository

```
git clone https://github.com/owantdelhiver/m2i_backoffice.git
```

### .env
- Faire une copie du fichier src.main.ressources.appToComplete.properties
- Le placer au même endroit et le nommer app.properties
- Remplir les données envirronnement de connexion à la bdd

### Se connecter au site
username : admin@gmail.com
<br>
password : admin

## Frontoffice

Cloner le repository

```
git clone https://github.com/owantdelhiver/m2i_frontoffice.git
```
### .env
- Faire une copie du fichier src.main.ressources.applicationToComplete.properties
- Le placer au même endroit et le nommer application.properties
- Remplir les données envirronnement de connexion à la bdd
- Laisser les données préremplies

### Se connecter au site
username : user@gmail.com
<br>
password : user