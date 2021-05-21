# HRMS

> ## Human Resource Management System
>
> ### Frameworks
> - <img alt="fatihdal | Java" src="https://img.shields.io/badge/-Spring%20Boot-succes?logoWidth=40?style=for-the-badge&logo=spring&logoColor=white"></img>
> ### Tools
> - <img alt="fatihdal | Java" src="https://img.shields.io/badge/-Maven-lightgrey?logoWidth=40?style=for-the-badge&logo=apache-maven&logoColor=white"></img>
> ### Database
> - <img alt="fatihdal | Java" src="https://img.shields.io/badge/-PostgreSQL-9cf?logoWidth=40?style=for-the-badge&logo=postgresql&logoColor=white"></img>
> ### Dependencies
> - Spring DevTools.
> - Spring Actuator
> - Spring Data JPA.
> - Spring Web.
> - Lombok.

## Usage

*Can be used with any rest client application*

> #### To list all job categories
> ```
> GET
> http://localhost:8080/hrms/jobcategories/categories
> ``` 

 
> #### To list all jobs
>```
>GET
>http://localhost:8080/hrms/jobs/jobs
>```

>#### To list all job seekers
>```
>GET
>http://localhost:8080/hrms/jobseekers/jobseekers
>```