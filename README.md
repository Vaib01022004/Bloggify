# Bloggify
Personal Blog Website

Bloggify is a Blog style personal journal web application created by leveragaing java servlets for backend and database connectivity and JSPs for frontend. 

### Features : 

1. Authentication provided using login and password.
2. Persisting user state using sessions and cookies.
3. Minimalistic UI Design.
4. Permanent Storage of Journals using database connectivity.

### Technologies used : 

Java Servlets : To implement the backend features like database connetivity, processing requestion, managing user sessions. Storage and retrieval of data, user authentication. 

Java Servlet Pages : For presenatation logic. Displaying user data, journals, User Interface etc.

Java Classes : For using DAO to abstract database implementation from business logic. 

## Design Patterns used, advantages leveraged: 

### 1. Model View Controller
We have used the Model View Controller (MVC) software design pattern to implement this project to separate the business logic from the presentation logic. This helped us to get a clean and simplified design of the web app and also allowed us to modify the presentation logic without interfereing with the backend. We were also able to easily integrate newer features into application without disturbing the existing functionalities.


### 2.Data Abstraction Object
On the other hand we have used Data Abstraction Object (DAO) another software design pattern which helped us to abstract away the implementation details of the data base and also provides us with an additional layer of security as it prevents users or the controller from directly interacting with the database. 

### The following diagram illustrates how the MVC architecture and DAO compliment each other and how theyre used. 
![image](https://github.com/user-attachments/assets/26b74852-4182-41f4-b63c-c1e1fbac6bc9)


Each jsp is associated with a page whose fucntion is obvious from the names like CreateBlog, logout, register etc. Details about the Backend implementation are provided in the readme file inside WEB-INF.

A basic flow of the pages would be as follows : 

index.jsp -> register.jsp -> home.jsp -> CreateBlog.jsp -> ReadMore.jsp-> logout.jsp


