# Search GitHub projects by language.

### Steps to run this project
Checkout this maven project from github (https://github.com/sanjaykushwaha83/informaticatest.git)

1. Open command prompt and go to project checkout directory 
2. Clean and build this Maven project using below command
   mvnw clean install
3. Run project using below command
   mvnw spring-boot:run
4. Go to browser and open swagger url: http://localhost:8888/informatica-test/swagger-ui.html
   

5. Once swagger url opened click on "/GET/ /githubprojects/search/{language}" and the click on "try out" and input language and click on execute button. Now you will be able to see list of projects in response.