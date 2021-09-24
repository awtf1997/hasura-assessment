# hasura-assessment
this repository contains java code and sql scripts used to a develop a springboot project that performs basic CRUD operations.

Database used: MySql on Amazon RDS
Dataset used: Chinook dataset(only the artist and album data have been used)

Basic Functionalities of the application:
1) GET -> to fetch the albums along with their artist information from the database. Album id can be provided but not mandatory. Upon providing album id, only the specific album will be retrieved, else all the albums will be retrieved.

2) POST -> to save new albums along with their corresponding artists to the database. Providing artist information is mandatory along with the albumm information. User needs to explicitly mention the album id and artist id.

3) PUT -> to update existing albums along with their corresponding artists to the database. Providing artist information is mandatory along with the album information. User needs to explicitly mention the album id & artist id.

4) DELETE -> to delete the albums along with their artist information from the database. Album id can be provided but not mandatory. Upon providing album id, only the specific album will be deleted, else all the albums will 	be deleted.

Application has been hosted on an AWS EC2 instance.
All the api endpoints can be accessed through the swagger link => http://ec2-54-152-55-119.compute-1.amazonaws.com:9091/swagger-ui/

Deploying the application =>
Deployment of the application has been done using AWS S3. To deploy the application, 
1) Build the jar file using mvn clean compile install.
2) Create a new bucket on AWS S3. Allow public access to the bucket. 
3) Upload the jar file to the bucket and make it public.
4) Copy the link from the bucket associated with the jar.
SSH into the ec2 instance and run : "wget <s3-link>"
5) Once the jar is downloaded, run : "java -jar <jar-name>"

Accessing the application =>
To access the application, the swagger endpoint can be used.
If the application is hosted on a separate EC2 instance, the application can be accessed by modifying the modifying the url as "http://<public dns of the ec2 instance>:9091/swagger-ui/"

Using a separate database =>
The database used here is a mysql database hosted on amazon rds. If a separate database needs to be used, then
1) Clone the repository by running the command git clone https://github.com/awtf1997/hasura-assessment.git
2) Navigate to the application.yml file in the src/main/resources/ folder
3) Change the database url, username and password to the appropriate credentials. You can also add/modify other parameters as required.
4) Deploy the appication using the deployment steps provided above

List of things that would be different in production environment:
1) A separate VPC should be deployed, with a public and a private subnet. Amazon RDS and EC2 services are to be deployed in the private subnet. Access to the private subnet should be restricted to only from the public subnet in that VPC.
2) API gateway, Load Balancing and Auto Scaling of the EC2 instances should be implemented on the public subnet.
3) Security groups and Network Access Control Layers should be in place to check the incoming and outgoing traffic through the instances and the gateways.
4) API endpoints should be secured under some security provisions(e.g., by using spring security). The access to the APIS should be restricted to certain roles and entitlements only, instead of global access. 
5) Usernames, passwords should be used in an encrypted format in the application.
6) SSL protection needs to be implemented.
7) GitHub repository should not be public. Access to the repository should be restricted to certains users only.
