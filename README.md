# Spring-Boot-Docker

# To Build docker image and run Docker execute below commands:

docker images

docker build -f DockerFile.txt -t springbootdocker .


docker run -p 8080:8080 springbootdocker


# To Push the docker image in docker hub

docker tag <Image ID> <dockerhubusername>/<image name>:<docker tag name>

docker push <dockerhubusername>/<image name>      
