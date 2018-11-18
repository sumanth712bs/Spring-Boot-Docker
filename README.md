# Spring-Boot-Docker

# To Build docker image and run Docker execute below commands:

docker images

docker build -f DockerFile.txt -t springbootdocker .


docker run -p 8080:8080 springbootdocker


# To Push the docker image in docker hub

docker tag Image_ID dockerhub_username/image_name:docker_tag_name

docker push docerhub_username/image_name      
