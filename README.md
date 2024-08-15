Getting Started
To get started with this Spring Boot project, follow the instructions below to set up MongoDB, configure your application, and run the project.

Prerequisites
Java 17 or higher
Maven  (for building the project)
MongoDB (installed and running)
Java Compatible IDE

Setting Up MongoDB
1. Install MongoDB
Follow the instructions for your operating system to install MongoDB:

Windows: Download the installer from MongoDB Download Center.

2. Start MongoDB
After installing MongoDB, you can start the MongoDB server:

Windows: Open Command Prompt and run mongod.

3. Verify MongoDB Installation
To ensure MongoDB is running, open a new terminal or command prompt and type:


This will open the MongoDB shell, indicating that the server is up and running.

4. Create a Database (Optional)
MongoDB will automatically create the database when you first insert data. However, you can manually create a database:


use mydatabase
Replace mydatabase with the name of your database.

Running the Application
1. Clone the Repository
Clone the project repository to your local machine:



git clone https://github.com/yourusername/your-repository.git
cd your-repository
2. Configure MongoDB Connection
Update the application.properties or application.yml file in the src/main/resources directory with your MongoDB connection details:


# application.properties
spring.data.mongodb.uri=mongodb://localhost:27017/mydatabase
Or in application.yml:

# application.yml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/mydatabase
Replace mydatabase with your actual database name. If MongoDB is running on a different host or port, update the uri accordingly.

3. Build and Run the Application
Using Maven:

Copy code
mvn clean install
mvn spring-boot:run
Using Gradle:


The application should start and be accessible at http://localhost:8080.

API Endpoints
Here are some of the API endpoints available in this project:

POST /register: Register a new user
GET /getUser/{id}: Retrieve a user by ID
GET /fetchUsers: Retrieve all users
PUT /updateUser: Update an existing user
DELETE /deleteUser/{id}: Delete a user by ID
You can use tools like Postman or curl to interact with these endpoints.

Project Structure
plaintext
Copy code
src
├── main
│   ├── java
│   │   └── com
│   │       └── Team4
│   │           └── SWENG455
│   │               └── Project
│   │                   ├── model
│   │                   │   └── User.java
│   │                   ├── controller
│   │                   │   └── UserController.java
│   │                   └── repository
│   │                       └── UserRepo.java
│   └── resources
│       ├── application.properties
│       └── static
│           └── index.html
└── test
    └── java
        └── com
            └── Team4
                └── SWENG455
                    └── Project
                        └── UserControllerTest.java
model: Contains the domain models like User.
controller: Handles HTTP requests and maps them to methods.
repository: Contains the interfaces for MongoDB operation
