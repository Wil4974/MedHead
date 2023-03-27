Suggestions for a good README

Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.
Ce projet est une POC pour les services hospitaliers anglais qui leur permettra de vérifier la faisabilité et l'efficacité d'une nouvelle application de liaison entre les équipes d'ambulancier et les hôpitaux.

Name
POC MedHead

Description
Cette POC met en place une API qui lorsque nous lui envoyons des coordonnées et une spécialité médicale nécessaire à l'intervention, nous réponds par la nom de l'hôpital le plus proche avec cette spécialité.

Badges

On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

Installation
Cette POC est développé en Java avec le framework Spring Boot et la base de données est conteneurisée. Pour pouvoir la lancer, il est donc nécessaire d'installer :
-Java 19
-Docker

Usage
Pour utiliser l'application, il faut d'abord lancer la base de données de test conteneurisée avec :

    docker run -d -p 5432:5432 -e POSTGRES_USER=wil -e POSTGRES_PASSWORD=wil -e POSTGRES_DB=medhead postgres:latest

Puis lancer l'application via :

    mvn spring-boot:run

Ensuite, vous pourrez interroger l'application à l'adresse suivante avec les paramètres souhaités :

    http://localhost:8080/hospital/{latitude}/{longitude}/{Spécialité}

Les éléments entre {} sont les paramètres à passer. Par exemple si vous souhaitez un hôpital proche de 51.48312:-0.11593 avec la spécialité 'Neuropathologie diagnostique', l'adresse sera :

    http://localhost:8080/hospital/51.48312/-0.11593/Neuropathologie diagnostique

Tests
Les résultats des test unitaires et d'intégration sont consultables au format html dans le dossier : htmlReport

Support
Cette POC a été développé par Wilfrid Boudia, architecte logiciel pour MedHead. Vous pouvez le contacter à cette adresse mail :

    poc_medhead@outlook.com

Ou via le Github de la POC :

    https://github.com/Wil4974/MedHead/

Roadmap

If you have ideas for releases in the future, it is a good idea to list them in the README.

Contributing

State if you are open to contributions and what your requirements are for accepting them.
For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.
You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

Authors and acknowledgment
Merci à toutes les équipes de MedHead, et des organisations partenaires, Ursa Major Health, Jupiter Scheduling Inc, Emergency Expert Systems, Schedule Shed pour leur temps et leur patience.

License
Ce projet est une POC appartenant à MedHead.

Project status
Le développement est stoppé en attendant la validation par les directions.
