**1. Prerequisites:**<br>
Java JDK 17 or higher installed
Maven installed
PostgreSQL installed and running
<br><br>

**2. Clone the repository from GitHub using the following command:**<br>
`git clone https://github.com/lifelongeducation/Rest_API.git`
<br><br>

**3. Open the project in your favorite IDE or text editor.**<br>
<br><br>

**4. Configure the database connection in the ClientController class:**<br>
`String url = "jdbc:postgresql://localhost:5432/sql_injection";`<br>
`String uname = "postgres";`<br>
`String pwd = "root";`<br>
<br>
Replace the values with your own database connection details.<br>
<br><br>

**5. Use a REST client such as Postman to interact with the API. Here are some example requests you can try:**<br>
<br>
To create a new client:<br>
POST http://localhost:8080/client<br>
Body:<br>
```
 {
        "name": "John Doe",
        "password": "password123"
 }
 ```
To retrieve a client by ID:<br>
`GET http://localhost:8080/client?id=1`<br>

