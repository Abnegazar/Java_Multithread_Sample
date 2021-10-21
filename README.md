# Java_Multithread_Sample

# Système d’emprunt automatique de vélos

## **Contexte**

La ville de Rennes dispose d’un système automatique d’emprunt de vélos. Ce système est composé de plusieurs sites répartis sur l’ensemble de la ville, ou les clients disposant d’une carte peuvent emprunter un vélo. Une fois, le vélo emprunte, le client peut se rendre à un autre site ou il restituera son vélo.
Afin d´éviter que certains sites ne se trouvent en rupture de stock ou en surplus, un camion se d´place de site en site afin d'équilibrer le nombre de vélos sur l’ensemble des sites.

## **Les clients**

Un client choisit un site de départ et un site d’arrivée. Si le site de départ ne dispose plus de vélos, le client attend jusqu’à ce qu’un vélo soit disponible. Une fois le vélo emprunté, le client se déplace jusqu’au site d’arrivée. Une fois sur place, il restitue le vélo. Si le site ne dispose plus de places pour stocker le vélo, le client attend qu’un emplacement se libère.

### **Les sites**
Le système d’emprunt de vélos est composé de NB_SITES sites, numérotés de 0 à NB_SITES 1. Chaque site dispose de STOCK_MAX emplacements à vélo. On suppose que chaque site dispose initialement de STOCK_INIT vélos (STOCK_INIT≤STOCK_MAX). Pour qu’un vélo puisse être placé sur un site, celui-ci doit obligatoirement disposer d’un emplacement libre.
Un site ne peut servir qu’un seul client à la fois. Lorsque le camion d’équilibrage arrive sur un site, celui-ci ne peut plus servir de clients (emprunt et restitution) jusqu’au départ du camion.

## **Le camion d’équilibrage**

Le camion d’équilibrage se déplace de site en site dans l’ordre de leurs numéros. Après être passé sur le dernier site, il revient au premier site et parcourt à nouveau les sites dans l’ordre de leurs numéros.
Lorsque le camion arrive sur un site, il détermine le nombre de vélos présents. 

- Si celui-ci est supérieur à un certain seuil BORNE_SUP, les vélos excédentaires sont chargés sur le camion (le stock est ramené à la valeur STOCK_INIT). 
- Si le nombre de vélos est inférieur à un certain seuil BORNE_INF, des vélos sont déposés sur le site afin de reconstituer le stock (dans la mesure du possible, le stock est ramené à sa valeur initiale STOCK_INIT).
- Si le nombre de vélos se trouve entre ces deux bornes, le camion, ne fais rien et poursuis sa tournée.

♦ On supposera que la taille du camion est toujours suffisante pour lui permettre de reprendre tous les vélos en excédent sur les différents sites. En revanche, le camion ne peut déposer des vélos sur un site que dans la limite du nombre de vélos qu’il transporte à ce moment-là.

## Le programme

Le programme demandé réalisé la simulation du fonctionnement de ce système d’emprunt de vélos en présences de clients. Chaque nouveau client est un nouveau thread.

Pour simuler la durée du trajet des cyclistes et du camion, vous pouvez utiliser la méthode Thread.sleep(int duration). La durée de ce trajet sera proportionnelle a la distance entre les sites. Cette distance sera simplement calculée grâce à la différence entre les numéros des sites de départ et d’arrivée. Votre programme devra réaliser des affichages judicieux afin de pouvoir suivre l’exécution de la simulation.
Votre programme devra intégrer un m´mécanisme de contrôle de la simulation qui assure la terminaison de tous les threads. En particulier, le thread Camion se termine lorsque tous les threads clients sont terminés (en réalité, le processus mettant en œuvre le camion est constitué d’une boucle infinie, il parcourt l’ensemble des sites tant que des processus clients existent.). Vous veillerez à l’absence d’interblocage dans votre simulation.

## License

[ GNU General Public License v3.0](https://choosealicense.com/licenses/gpl-3.0/)

