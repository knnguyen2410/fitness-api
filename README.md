# Fitness API

### A Spring Boot Mini-Project
* <a href="#about-the-game">About the API</a>
* <a href="#how-to-play">How to Use</a>
* <a href="#technologies-used">Technologies Used</a>
* <a href="#features">Features</a>
* <a href="#diagram">Diagram</a>
* <a href="#reflection">Reflection</a>
* <a href="#credits">Credits</a>
---
## About the API

Text Here

## How to Use

#### Installation:

Dependencies

```
		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<version>3.0.5</version>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.5</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
```



#### Instructions:

* Text Here
    * Text Here
    * Text Here
    * Text Here
---
## Technologies Used

* **Git**: Used for version control on local computer and pushing changes to remote repository.
* **GitHub**: Used to host the remote repository and hosting the live website.
* **Google Chrome**: The **browser** was used for accessing materials on the internet.
* **Java**: The programming language used for developing this application.
* **IntelliJ IDEA**: This is the IDE (integrated development environment) used to create the application.
    * Build System: IntelliJ
    * JDK: corretto-17, Amazon Correto version 17.0.6
* **pgAdmin 4**
* ERD Tool: https://www.lucidchart.com/
* Spring Initializer: https://start.spring.io/
* JWT secret generator: https://www.grc.com/passwords.htm
---
## Features
Project requirements: https://git.generalassemb.ly/java-interapt-3-13-2023/springboot-mini-project

#### User Stories and Endpoints

User:
- http://localhost:9092/auth/users/register/
- As a user, I can register for an account using my email address, and set a username and password.
- http://localhost:9092/auth/users/login/
- As a user, I can log into a website using my username and password

Category:
- http://localhost:9092/api/workouts/
- (POST) As a user, I can create a new workout
- http://localhost:9092/api/workouts/
- (GET) As a user, I can see a list of all my workouts
- http://localhost:9092/api/workouts/{workoutId}/
- (GET) As a user, I can see a certain workout
- http://localhost:9092/api/workouts/{workoutId}/
- (PUT) As a user, I can update a certain category
- http://localhost:9092/api/workouts/{workoutId}/
- (DELETE) As a user, I can delete a certain workout

Product:
- http://localhost:9092/api/workouts/{workoutId}/exercises/
- (POST) As a user, I can create a new exercise in a certain workout
- http://localhost:9092/api/workouts/{workoutId}/exercises/
- (GET) As a user, I can get a list of all my exercises for a certain workout
- http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
- (GET) As a user, I can get a certain exercise for a certain workout
- http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
- (DELETE) As a user, I can delete a certain exercise for a certain workout

#### Technical Requirements (MVP)

- [x] Text Here
- [x] Text Here
- [x] Text Here
---
## Diagram

Here is my Java Classes Diagram, which provides a high-level overview of the structure of my code.

ERD Here: https://lucid.app/lucidchart/3753e7a2-3081-4937-93bb-c93f2846fcf2/edit?viewport_loc=-55%2C-21%2C2765%2C1558%2C0_0&invitationId=inv_41329a38-d753-495b-b50f-7934f2f3528d

- One user can have many workouts
- Many workouts can belong to one user


- One user can have many exercises
- Many exercises can belong to one user


- Many workouts can have many exercises
- Many exercises can belong to many workouts
---
## Reflection

**My biggest takeaway**:

**What I would do differently**:

---
## Credits

* Documentation referenced:
    - [RESTFUL JSON API with Java Spring Boot](https://git.generalassemb.ly/sureshmelvinsigera/Java-Spring-Boot-lecture/blob/spring-2-7-8/README.md#one-to-one-relationship)
    - [Spring Boot ToDo Lab](https://git.generalassemb.ly/java-interapt-3-13-2023/spring-boot-todo-lab)
    - [JAVA API](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
    - [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)

* Acknowledgements:
    - Suresh Sigera 