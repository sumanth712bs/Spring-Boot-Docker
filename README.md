# Spring-Boot-Docker

To Build docker image and run Docker execute below commands:

docker images
docker build -f DockerFile.txt -t springbootdocker .
docker run -p 8080:8080 springbootdocker
