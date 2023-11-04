# Student Information Management System

## Architecture Diagram

![效果图](https://github.com/userqizegao/student_crud/blob/master/student-crud/%E6%9E%B6%E6%9E%84%E5%9B%BE.png)

## Technology Stack

The project is structured using Maven, developed with JSP + Servlet, and incorporates the Spring + SpringMVC + MyBatis frameworks. It utilizes the c3p0 open-source JDBC connection pool to connect to the MySql database. AJAX requests are sent to retrieve JSON data, which is then dynamically loaded onto the page via the DOM. Unit testing code is written using Spring-Test and Junit. The system employs a Restful design style, sending PUT and DELETE requests via AJAX. Dual-side validation is implemented, with front-end validation using JQuery and back-end validation conforming to the JSR303 standard.
