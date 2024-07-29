### Description of the functions of the classes

UserDAO class : Defines the Data Abstraction Object of user.
BlogDAO : Defines the Data Abstraction Object of Blogs. 
JDBCUserDAO : Used to communicate with the mysql database to send and retrieve user data. It receives data from client as a UserDAO object and sends it to database after formatting. Also used to retrieve a UserDAO object based on the query gicen to it.Used in regostartion and authentication.
JDBCBlogDAO : same use as JDBCUserDAO but for storage ad retrieval of blogs. 
CreateBlogServlet : Processes requests of creating a blog. 
HomeServlet : Processes requests of home page.
LoginServlet : Used to authenticate user and upon successful login, create a session for the user. 
ReadMoreServlet : Provides functionality of reading the full ournal when a snippet is shows.
RegisterServlet : Registers a new user and adds their data to database. 

