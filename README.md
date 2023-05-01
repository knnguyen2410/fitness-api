# Fitness API

### A Spring Boot Mini-Project
* <a href="#about-the-game">About the API</a>
* <a href="#technologies-used">Technologies Used</a>
* <a href="#installation">Installation</a>
* <a href="#features">Features</a>
* <a href="#diagram">Diagram</a>
* <a href="#credits">Credits</a>
---
## About the API

I wanted to combine my love of coding and health to create a fitness API. 

This is an application that helps users track their workouts and exercises. 
Users are able to create multiple workouts, each consisting of multiple exercises. 
The exercises and workouts can also be updated to stay current with users' fitness goals.
---
## Technologies Used

* **Git**: Used for version control on local computer and pushing changes to remote repository.
* **GitHub**: Used to host the remote repository and hosting the live website.
  * **Github Projects**: Used for project planning and documentation of deliverables and timelines: https://github.com/users/knnguyen2410/projects/2/views/1
* **Google Chrome**: The **browser** was used for accessing materials on the internet.
* **Java**: The programming language used for developing this application.
* **IntelliJ IDEA**: This is the IDE (integrated development environment) used to create the application.
    * Build System: IntelliJ
    * JDK: corretto-17, Amazon Correto version 17.0.6
* **Tomcat**: The server on which this application is running.
* **Spring**: The framework for creating this web application.
* **Maven**: The build tool used to source dependencies.
* **PostgreSQL**: The database used for this API.
* **Postman**: Used to test and debug the API.
* **ERD Tool**: https://www.lucidchart.com/
* **Spring Initializer**: https://start.spring.io/
* **JWT secret generator**: https://www.grc.com/passwords.htm
* **Markdown Table Generator**: https://www.tablesgenerator.com/markdown_tables
---
## Installation:

Since there is no front-end yet for this API, please clone this repository to your local machine.

Alternatively, if you would like to manually download the dependencies, here are the following Maven dependencies I used:

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
---
## Features
Project requirements: https://git.generalassemb.ly/java-interapt-3-13-2023/springboot-mini-project

REST API endpoints:

| Request Type | URL                                              | Functionality               | Access  |
|--------------|--------------------------------------------------|-----------------------------|---------|
| POST         | /auth/users/register/                            | User registration           | Public  |
| POST         | /auth/users/login/                               | User login                  | Public  |
| POST         | /api/workouts/                                   | Create a workout            | Private |
| GET          | /api/workouts/                                   | Get all workouts            | Private |
| PUT          | /api/workouts/                                   | Update all workouts         | Private |
| DELETE       | /api/workouts/                                   | Delete all workouts         | Private |
| GET          | /api/workouts/{workoutId}/                       | Get a workout               | Private |
| PUT          | /api/workouts/{workoutId}/                       | Update a workout            | Private |
| DELETE       | /api/workouts/{workoutId}/                       | Delete a workout            | Private |
| POST         | /api/workouts/{workoutId}/exercises/             | Create a workout exercise   | Private |
| GET          | /api/workouts/{workoutId}/exercises/             | Get the workout exercises   | Private |
| PUT          | /api/workouts/{workoutId}/exercises/{exerciseId} | Update a workout exercise   | Private |
| DELETE       | /api/workouts/{workoutId}/exercises/{exerciseId} | Delete the workout exercise | Private |

### User Stories

User Account:
- As a user, I can register for an account using my email address, and set a username and password.
- As a user, I can log into a website using my username and password.

Workout:
- As a user, I can create a new workout with a name, description, and length so that I can quickly pick one that suits my needs.
- As a user, I can see a list of all my workouts for ease of access.
- As a user, I can update all my workouts in case my needs change.
- As a user, I can delete all my workouts in case they no longer suit me, or I want to start over and make new workouts.
- As a user, I can look up a workout by its ID and see its details.
- As a user, I can update a certain workout so that these updates do not affect other workouts.
- As a user, I can delete a certain workout in case it no longer suits my needs.

Exercise:
- As a user, I can create a new exercise for a certain workout, with exercise name, description, sets, reps, and duration.
- As a user, I can get a list of all my exercises for a certain workout for a quick overview.
- As a user, I can update a certain exercise for a certain workout so that my exercises stay challenging.
- As a user, I can delete a certain exercise for a certain workout in case it is no longer appropriate for my workout.

#### Technical Requirements
- [x] The PostgreSQL database should consist of a minimum of three models. 
- [x] Make sure that the environment settings are set up using Spring Profiles.
- [x] A combination of Spring Security and JWT tokens is required in order to authenticate and personalize API endpoints while maintaining the overall security of the application.
- [x] A minimum of one API endpoint must be able to perform complete CRUD operations such as create, read, update, and delete.
- [x] In addition, other API endpoints can perform CRUD tasks based on the business use-case.
- [x] Provide CRUD routes that were built based on rest conventions to be exposed as part of the API.
- [x] Be able to gracefully handle exceptions when they occur.
- [x] In the event that an exception occurs, you should send appropriate error messages back to the user.
- [x] In order to make the application conform to the MVC design pattern, you need to have separate controllers and services.
- [x] Ensure that KISS principles are adhered to and that DRY principles are followed.
---
## Diagram

Here is my Java Classes Diagram, which provides a high-level overview of the structure of the API.

![Screenshot 2023-05-01 at 6.22.50 AM.png](.idea%2FScreenshot%202023-05-01%20at%206.22.50%20AM.png)
ERD can also be found: https://lucid.app/lucidchart/3753e7a2-3081-4937-93bb-c93f2846fcf2/edit?viewport_loc=-55%2C-21%2C2765%2C1558%2C0_0&invitationId=inv_41329a38-d753-495b-b50f-7934f2f3528d

User - Workout relationship: one-to-many
- One user can have many workouts
- Many workouts can belong to one user

User - Exercise relationship: one-to-many
- One user can have many exercises
- Many exercises can belong to one user

Workout - Exercise relationship: one-to-many
- One workout can have many exercises
- Many exercises can belong to one workout
---
## Reflection

Originally when I approached designing the API, I wanted to create a many-to-many relationship between workouts and exercises. 
This is because I believed it made the workouts easier to create (many exercises can be reused in many workouts).
However, I couldn't figure out how to implement this once I was creating the exercise CRUD endpoints.

If I were to approach this API again, I would like to attempt a many-to-many relationship one more time. 
I would also give users a profile so that I could implement a one-to-one relationship, and give users the option of making their exercises and workouts public.
---
## Credits

* Documentation referenced:
    - [RESTFUL JSON API with Java Spring Boot](https://git.generalassemb.ly/sureshmelvinsigera/Java-Spring-Boot-lecture/blob/spring-2-7-8/README.md#one-to-one-relationship)
    - [Spring Boot ToDo Lab](https://git.generalassemb.ly/java-interapt-3-13-2023/spring-boot-todo-lab)
    - [JAVA API](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
    - [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
    - Many-to-many relationships: https://www.baeldung.com/jpa-many-to-many

Thank you to Rachel Ehrlich for providing the Markdown Table Generator: https://github.com/rjehrlich

Thank you to Suresh Sigera for their instruction in learning about Spring and REST APIs.

