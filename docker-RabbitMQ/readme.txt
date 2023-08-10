Pour exécuter le conteneur docker de rabitMQ il suffit de : 

	1/- Chercher 'Bash' sur la barre de la recherche 
	2/- Accéder au chemin de 'RabbitMQ', dans mon le fichier docker-compose.yml est sur "D:\SPRING_BOOT_APPS\Microservices-Sync-User-Project\docker-RabbitMQ" je tappe le chemin sous forme de Lunix : 
		> cd /d/SPRING_BOOT_APPS/Microservices-Sync-User-Project/docker-RabbitMQ
	3/- Lancer le conteneur par : 
		> docker pull rabbitmq:3.11.0
		> docker-compose up
	4/- Lancer la commande suivante pour arreter le conteneur : 
		> docker-compose down