# Coding Test

![image](https://user-images.githubusercontent.com/10988581/189280066-1907fcd1-0d5d-492e-aef0-a7a2b0ec05dc.png)

## Description

Created a simple Spring Boot application and turned it into a valid WAR application deployable on a Tomcat server.

## How to Run Our Spring Boot Application in Spring Tool Suite.

- Spring Tool Suite (STS) is a java IDE tailored for developing Spring-based enterprise applications. 
It is easier, faster, and more convenient. And most importantly it is based on Eclipse IDE. STS is free, open-source, and powered by VMware.

```bash
Prerequisite: Download and Install Spring Tool Suite (Spring Tools 4 for Eclipse) IDE in your system. You may refer to this article:
How to Download and Install Spring Tool Suite (Spring Tools 4 for Eclipse) IDE?
```

## Procedure
1. Create Spring Boot project in Spring Tool Suite
2. Import the Project into STS IDE
3. An entry file named Application file will be created for STS
4. Run the application on the server.

### Step 1: Create Your Spring Boot Project in Spring Tool Suite

You may refer to this article How to Create and Setup Spring Boot Project in Spring Tool Suite and create your first Spring Boot Application. 
Or you may Create Your Spring Boot Project in Spring Initializr and import the project into your STS IDE. 
Please refer to this article to [Create Spring Boot Project in Spring Initializr](https://www.geeksforgeeks.org/spring-initializr/).

### Step 2: How to Import the Project into Your STS IDE?

2.1: Go to your STS IDE > File > Open Project from File System as shown in the below image.

![pic](https://user-images.githubusercontent.com/10988581/189286520-e955f63a-e777-4b9d-8e37-f0ed12880264.png)

2.2: A pop-up window will occur like the following. Here you have to choose the directory that has been generated while creating the spring boot project in Spring Initializr. 
And then click on the Finish button.

![image](https://user-images.githubusercontent.com/10988581/189289751-5ef0a942-8249-4dbb-a411-39fe230d0c5a.png)

### Step 3: After successfully creating or importing the spring boot project a file name CovidDataApplication.java will be created automatically and this is your entry point.You can consider it as the main method of a Spring Boot application. 

![image](https://user-images.githubusercontent.com/10988581/189288187-0051b3b8-0111-4952-b551-6014b02c1f24.png)

### Step 4: In order to run this application now, Right-click on the CovidDataApplication.java > Run As > Spring Boot App as shown in the below image.

![image](https://user-images.githubusercontent.com/10988581/189288520-64291997-e6e8-4464-a795-d13d8d93e181.png)

### Step 5: After successfully running the application you can see the console where the Tomcat server starts on default port number 8080 as shown in the below image. 

![pic](https://user-images.githubusercontent.com/10988581/189289163-92856485-fb8c-4ecc-9563-d92db8526936.png)

### We can change the port number in the application.properties file by using the following line of code as follows:

```bash
## server.port=8988
```
Now re-run the application again and you can see Your Tomcat server started on the port that you have given like the below image.

![image](https://user-images.githubusercontent.com/10988581/189290744-7086297a-6052-474d-80d5-46e364c6f814.png)

## You can access api through postman in below manner.

![pic](https://user-images.githubusercontent.com/10988581/189291286-a55f581b-af47-42fe-8d2e-6b0b32cdfe9c.png)


## Run query on MySQL server resoective to DB Schema and table. Below is the image of data.

![image](https://user-images.githubusercontent.com/10988581/189292958-844d84f0-e454-4d33-9cfc-044894b729af.png)


