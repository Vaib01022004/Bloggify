### Description of the functions of the classes

UserDAO class : Defines the Data Abstraction Object of user.<br>
BlogDAO : Defines the Data Abstraction Object of Blogs. <br>
JDBCUserDAO : Used to communicate with the mysql database to send and retrieve user data. It receives data from client as a UserDAO object and sends it to database after formatting. Also used to retrieve a UserDAO object based on the query gicen to  it.Used in regostartion and authentication. <br>
JDBCBlogDAO : same use as JDBCUserDAO but for storage ad retrieval of blogs. <br> 
CreateBlogServlet : Processes requests of creating a blog. <br>
HomeServlet : Processes requests of home page.<br>
LoginServlet : Used to authenticate user and upon successful login, create a session for the user.<br> 
ReadMoreServlet : Provides functionality of reading the full ournal when a snippet is shows.<br>
RegisterServlet : Registers a new user and adds their data to database. <br>

