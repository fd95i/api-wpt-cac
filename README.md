# WillowPatisserie API

Hey! This repository represents the Backend structure of Willow Patisserie. In order to host this container locally via docker you will need the following:

- [Docker / Docker Desktop](https://docs.docker.com/get-docker/)  🐳
- A MySQL server to create the database schema. 🛢
- An [.env-file](https://docs.docker.com/engine/reference/commandline/run/#set-environment-variables--e---env---env-file) containing db host:port and username/password credentials 🔓

# Steps (Assuming you have the previous requirements)

 1. Let's begin by creating our schema. In src/main/resources there is a file called wpt-cac-schema.sql . This file contains the MySQL sentences needed to use this small API. Just execute this sentences in your favorite Database Tool and you are ready to go 😁 .
 
 2.  Now that we have the Database, let's begin with the container. You can find the images of this project in [Dockerhub](https://hub.docker.com/r/fd95i/api-wptcac). I recommend using LATEST version. Pull this image via docker using:

	 `docker pull fd95i/api-wptcac:latest`
 
 3. Let's get to the .env file. We need to create this file in order to authenticate us to the MySQL database we just created minutes ago. In the root of this project there is an example .env file that contains the following variables, just download that file and complete the keys with your values:
 
	|  Key | Value(i.e) |
	|-------------------------|--------|
	| 	WPTCAC_DATABASE_HOST | localhost |
	| 	WPTCAC_DATABASE_PORT | 3306 |
	| 	WPTCAC_DATABASE_USER | root |
	| 	WPTCAC_DATABASE_PASSWORD | root |


 4.  Finally, to run this image properly we'll need this command:
 
	 `docker run --env-file <your-file-path> -p 8080:8080 fd95i/api-wptcac:latest`
 
 5. And done! Everything should be running right now.



# Comments

There is also a Postman Collection in the resources folder which has every endpoint available in case you want to test this API. 

Ports 8080 and 8888 are exposed if you want to change them.
