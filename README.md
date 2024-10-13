# XDR Application (Full Stack - Spring Boot and Angular)

This repository contains a full-stack application built with a Java Spring Boot back-end and an Angular front-end. The back-end uses Gradle for build automation and MySQL as the database.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
  - [Clone the Repository](#clone-the-repository)
  - [Back-end Setup](#back-end-setup)
  - [Front-end Setup](#front-end-setup)
- [Running the Application](#running-the-application)
- [Additional Notes](#additional-notes)

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

- **Java Development Kit (JDK) 17**
- **Gradle**
- **Node.js and npm**
- **Angular CLI**
- **MySQL Server**

## Installation

### Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/enharmonique/extended-detection-and-response.git
```

### Back-end Setup

#### 1. Navigate to the Back-end Directory

```bash
cd xdr-backend
```

#### 2. Configure the Database

- Ensure MySQL is installed and running.
- Create a database named `xdr_database`:

  ```sql
  CREATE DATABASE xdr_database;
  ```

- Update `src/main/resources/application.properties` with your MySQL credentials:

  ```properties
  spring.application.name=xdr-backend
  spring.datasource.url=jdbc:mysql://localhost:3306/xdr_database
  spring.datasource.username=root
  spring.datasource.password=your_mysql_password
  spring.jpa.show-sql=true
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
  ```

#### 3. Build the Back-end Application

```bash
gradle build
```

#### 4. Run the Back-end Application

```bash
gradle bootRun
```

The back-end server will start on `http://localhost:8080`.

### Front-end Setup

#### 1. Navigate to the Front-end Directory

```bash
cd xdr-frontend
```

#### 2. Install Dependencies

```bash
npm install
```

#### 3. Run the Front-end Application

```bash
ng serve
```

The front-end application will run on `http://localhost:4200`.

## Running the Application

1. **Start the Back-end Server**:

   Make sure the back-end server is running on `http://localhost:8080`.

2. **Start the Front-end Application**:

   Ensure the front-end is running on `http://localhost:4200`.

3. **Access the Application**:

   Open your web browser and navigate to `http://localhost:4200`.

## Additional Notes

- **Port Conflicts**: If `8080` or `4200` are already in use, you may need to adjust the port settings in the application configurations.
