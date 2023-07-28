
# Recipe Management System

The Recipe Management System is a web application that allows users to store and manage their recipes. Users can create, view, update, and delete recipes. They can also add comments to recipes and search for recipes based on various criteria.


## Features

- User Registration and Authentication: Users can sign up and log in to the system.
- Recipe CRUD Operations: Users can create, view, update, and delete their recipes.
- Commenting: Users can add comments to recipes created by others.
- Search: Users can search for recipes based on recipe name, ingredients, or any other criteria.


## Technologies Used
- Java (Spring Boot) for the backend server
- MySQL database for data storage
- Spring Data JPA for data access
- Spring Security for user authentication and authorization
- RESTful API for communication with the frontend
- AWS
## ## Getting Started  

### Prerequisites
- Java Development Kit (JDK) version 8 or higher
- MySQL database
- IDE (e.g., IntelliJ IDEA, Eclipse) for development

### Database Configuration
1. Create a MySQL database for the project. Update the `application.properties` file with the database credentials.

- spring.datasource.url=jdbc:mysql://localhost:3306/recipe_management_system
- spring.datasource.username=your_database_username
- spring.datasource.password=your_database_password

2. The application will automatically create the necessary tables based on the entity classes.

### How to Run

1. Clone this repository to your local machine:
git clone https://github.com/Sach42/Recipe-Management-API-deploy.git


2. Open the project in your IDE and configure the database settings in `application.properties`.

3. Build and run the application. The application will start on `http://localhost:8080/`.

### API Endpoints

- **POST /recipes**: Create a new recipe.
- **GET /recipes**: Get all recipes.
- **GET /recipes/{id}**: Get a recipe by ID.
- **PUT /recipes/{id}**: Update a recipe.
- **DELETE /recipes/{id}**: Delete a recipe.
- **POST /comments**: Add a comment to a recipe.
- **GET /comments/recipe/{recipeId}**: Get all comments for a recipe.

Note: Make sure to implement frontend components to interact with these API endpoints.

## Deployment on AWS

To deploy the Recipe Management System on an AWS machine, follow the steps below:

### Step 1: Set Up AWS Instance

1. Launch an Amazon EC2 instance with the desired specifications (e.g., OS, instance type).

2. Make sure to open the necessary ports (e.g., port 8080 for the application) in the security group associated with the EC2 instance.

### Step 2: Prepare the Environment

1. Connect to your AWS instance using SSH:

```bash
ssh -i /path/to/your/key.pem ec2-user@your-instance-ip


Step 3: Deploy the Application

Transfer the JAR file or build the project on the AWS instance. You can use tools like scp or git:

- Example using scp
scp -i /path/to/your/key.pem /path/to/recipe-management-system.jar ec2-user@your-instance-ip:/path/to/destination/

-- Run the application on the AWS instance:
    java -jar /path/to/recipe-management-system.jar

The application should now be accessible on your AWS instance's public IP address and port 8080 (unless you specified a different port).

Step 4: Access the Application
Open your web browser and enter the AWS instance's public IP address followed by the port number (e.g., http://your-instance-ip:8080/).

You should now be able to access and use the Recipe Management System.



## Authors

- [@Sachin_Shukla](https://github.com/Sach42)

## Additional Configuration
Remember to set up a domain name, SSL certificate, and appropriate security measures based on your deployment requirements. Additionally, consider using a process manager like systemd to manage the lifecycle of the application process on the AWS instance.

## Contribution
Contributions to the project are welcome! Feel free to open issues or submit pull requests.

## License
This project is licensed under the MIT License.
