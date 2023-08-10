# On peut utiliser la commande suivante si on veut pas utiliser Dockerfile
# docker run -d -p 9411:9411 custom-zipkin-image
# Use the official Zipkin Docker image as the base image
FROM openzipkin/zipkin

# Set the desired port for Zipkin server
ENV SERVER_PORT=9411

# Expose the specified port for Zipkin server
EXPOSE $SERVER_PORT