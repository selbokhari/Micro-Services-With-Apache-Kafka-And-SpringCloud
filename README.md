# Microservices Project

Ce projet implémente deux microservices : `User-MS` et `Departement-MS`.

## Description des Microservices

- **User-MS :** Gère les opérations relatives aux utilisateurs (CRUD).
- **Departement-MS :** Gère les opérations concernant les départements.

### Communication entre Microservices

- `User-MS` communique avec `Departement-MS` pour :
  - Récupérer le département d'un utilisateur (en utilisant l'identifiant du département).
  - Persister un département.

### Modes de Communication

- **Synchrone :** À travers des appels REST en utilisant OpenFeign.
- **Asynchrone :** Via le Message Broker Apache Kafka.

## Patterns Microservices / Spring Cloud

Le projet intègre Spring Cloud en mettant en œuvre les patterns suivants :

- **Service Registry and Discovery Pattern :** Enregistrement des adresses IP et des ports des applications pour les rendre accessibles. Utilisation de Netflix Eureka.
- **Config Server Pattern :** Centralisation des configurations des microservices. Utilisation de Spring Cloud Config Server avec Git comme repository.
- **Circuit Breaker Pattern :** Prévention des appels répétés aux services indisponibles. Utilisation du framework Resilience4J.
- **Retry Pattern :** Tentative répétée en cas d'appel échoué à un composant. Utilisation du framework Resilience4J.
- **Distributed Tracing Pattern :** Gestion de la traçabilité des appels qui passent par plusieurs composants distribués. Utilisation de Spring Cloud Sleuth avec Zipkin.
- **API Gateway :** Point d'entrée de l'application distribuée, acheminant les requêtes des clients vers les microservices appropriés en fonction de la configuration.
- **Spring Cloud Bus :** Chargement automatique de la configuration pour toutes les instances/microservices via l'appel "POST /actuator/busrefresh". Utilisation de RabbitMQ comme bus.

## Implémentations

Le projet inclut aussi les implémentations suivantes :

- **Spring Data :** Utilisé pour interagir avec la base de données.
- **Validation des DTO :** Utilisation de la bibliothèque Jakarta Validation.
- **Mapping :** Utilisation de la bibliothèque Selma Mapper.

N'hésitez pas à explorer le code source et les configurations pour plus de détails sur l'implémentation de chaque composant.
