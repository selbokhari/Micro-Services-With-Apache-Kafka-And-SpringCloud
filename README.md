Ce projet implémente deux microservices : User-MS et Departement-MS.

  User-MS gère les opérations relatives aux utilisateurs (CRUD).
  Departement-MS gère les opérations concernant les départements.

User-MS communique avec le Departement-MS pour :

  => Récupérer le département d'un utilisateur (en utilisant l'identifiant du département).
  => Persister un département.

Le projet prend en charge deux modes de communication :

  ++ Synchrone : à travers des appels REST en utilisant OpenFeign.
  ++ Asynchrone : via le Message Broker Apache Kafka.

En outre, le projet intègre Spring Cloud en mettant en œuvre les patterns suivants :

  ++ Service Registry and Discovery Pattern : pour enregistrer les adresses IP et les ports de nos applications et les rendre accessibles pour les communications. J'ai utilisé Netflix Eureka.
  ++ Config Server Pattern : centralisation des configurations des microservices. J'ai utilisé Spring Cloud Config Server en utilisant Git comme repository.
  ++ Circuit Breaker Pattern : prévention des appels répétés aux services indisponibles. J'ai utilisé le framework Resilience4J.
  ++ Retry Pattern : tentative répétée en cas d'appel échoué à un composant. J'ai utilisé le framework Resilience4J.
  ++ Distributed Tracing Pattern : gestion de la traçabilité des appels qui passent par plusieurs composants (microservices) distribués. J'ai utilisé Spring Cloud Sleuth avec Zipkin.
  ++ API Gateway : point d'entrée de l'application distribuée. Il achemine les requêtes des clients vers les microservices appropriés en fonction de la configuration.
  ++ Spring Cloud Bus : chargement automatique de la configuration pour toutes les instances/microservices via l'appel "POST /actuator/busrefresh". J'ai utilisé RabbitMQ comme bus.

De plus, le projet inclut les implémentations suivantes :

  ** Spring Data pour interagir avec la base de données.
  ** Validation des DTO en utilisant la bibliothèque Jakarta Validation.
  ** Mapping en utilisant la bibliothèque Selma Mapper.
