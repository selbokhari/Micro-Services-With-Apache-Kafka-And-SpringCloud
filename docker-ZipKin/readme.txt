OPTION  01 :

Afin d'exécuter l'image de Zinpkin, il suffit de :

1/- Builder et tagger l'image docker par un lebelle personalisé "custom-zipkin-image" :
    > docker build . -t custom-zipkin-image
2/- Exécuter l'image par :
    > docker run -d -p 9411:9411 custom-zipkin-image


==============================================================================================

OPTION  02 :

Pour éviter l'utilisation de Dockerfile il suffit de lancer la commande suivante
    > docker run --rm -it --name zipkin -p 9411:9411 openzipkin/zipkin