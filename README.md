# Acodemy student app tests
> This test automation project has been created during Acodemy.lv courses and will be continuously updated covering the page with more autotests.
## Table of contents
1)  <a href="#Prerequisites">Prerequisites</a>
2)  <a href="#Technologies">Technologies</a>
3)  <a href="#Setup">Setup</a>
4)  <a href="#Usage">Usage</a>



## Prerequisites
Before you begin, ensure you have met following requirements:
* Installed Java 11 or above
* Configured Maven in order to run **mvn** commands
* Installed Google Chrome browser
* Have all necessary libraries are added to **pom.xml** and downloaded to **IDE** using **Maven** menu


## Technologies
* Java
* Selenium
* Cucumber

* TestNG
* DataFaker

## Setup
Here You have 2 options:
* Download whole repository to any folder and open the folder using any **IDE** of your choice
* Clone repository and open it using any **IDE** of your choice
```sh
git clone https://github.com/github_username/repo_name.git
```


## Usage
After completing **Setup** step, You should open directory in any **IDE** and find file "configuration.properties" and by changing boolean value of **run.locally** to **true** You can execute the autotest on your machine locally.

To run the test remotely, you need to change boolean value of **run.locally** to **false** and enter Your **Username** and **Accesskey** from <a href="https://saucelabs.com/">saucelabs.com<a/> into corresponding variables in the same file.

After Deciding which way you want to run the program, you should execute either **StudentAppTest.java** to run the test written using **Selenium** framework
which is located : 
```sh
src\test\java\StudentAppTest.java
```

Or the test with BDD approach **Cucumber** which is located : 
```sh
\src\test\resources\features\create_student.feature
```