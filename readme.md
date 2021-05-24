<!-- PROJECT LOGO -->
<br />
<p align="center">
   <a href="https://github.com/sonups/bdd-selenium-java">
   <img src="https://media-exp1.licdn.com/dms/image/C5112AQHJpZqS4Bxncw/article-cover_image-shrink_423_752/0/1520185868869?e=1627516800&v=beta&t=daIxyIOsFQ8wt43fNjBT6FSnbxOC1az55hC10ae8HLw" alt="Logo" width="300" height="150">
      <img src="https://miro.medium.com/max/8642/1*iIXOmGDzrtTJmdwbn7cGMw.png" alt="Logo" width="250" height="150">
   </a>
   </p>
<h3 align="center">BDD Selenium Test Automation in Java</h3>
<p align="center">
  -- Twitter Website as Use case -- 
</p>

Table of contents
=================

<!--ts-->

  * [Built With](#built-with)
  * [1. To run all cases use tag - @all (tested in windows 10 & ubuntu)](#1-to-run-all-cases-use-tag---all-tested-in-windows-10--ubuntu)
  * [2. Tags](#2-tags)
  * [3. Browser configuration](#3-browser-configuration)
  * [4. Structure of Files](#4-structure-of-files)
  * [Contact](#contact)


### Built With

Selenium, Cucumber, mvn , Java8

* [Mvn](https://maven.apache.org/)
* [Selenium](https://www.selenium.dev/)
* [Cucumber](https://cucumber.io/)
* [Java](https://www.java.com/en/)


### 1. To run all cases use tag - @all (tested in windows 10 & ubuntu)
   ```sh
   git clone https://github.com/sonups/bdd-selenium-java
   cd bdd-selenium-java
   mvn compile test -Dcucumber.filter.tags="@all"
   ```
### 2. Tags

| Specifc Tag    | Description                    | Full command                                             |
|----------------|--------------------------------|----------------------------------------------------------|
| @all           | Executes all scenarios         | mvn compile test -Dcucumber.filter.tags="@all"           |
| @login         | Execute login scenario         | mvn compile test -Dcucumber.filter.tags="@login"         |
| @user-timeline | Execute user timeline scenario | mvn compile test -Dcucumber.filter.tags="@user-timeline" |
| @user-profile  | Execute user profile scenario  | mvn compile test -Dcucumber.filter.tags="@user-profile"  |
| @send-tweet    | Executes all scenarios         | mvn compile test -Dcucumber.filter.tags="@send-tweet"    |
| @search-page   | Executes all scenarios         | mvn compile test -Dcucumber.filter.tags="@search-page"   |




 ### 3. Browser configuration
 
Specifcy the browser in config.properties file ( Ensure the browser is installed and available in OS)

 Location : src\test\resources\config\config.properties
 
 Sample configuration 
   ```sh
   #browser = firefox
    browser = chrome
   ```

 ### 4. Structure of Files 
   ```sh
┣---- src/
┃----┣---- main/
┃----┃----┣---- java/
┃----┃----┃ ┗ automation/
┃----┃----┃----┣---- core/
┃----┃----┃----┣---- pages/
┃----┃----┃----┣---- runner/
┃----┃----┃----┗ steps/
┃----┃----┗ resources/
┃----┗ test/
┃----┣---- java/
┃----┃----┃----┗ runner/
┃----┃----┃----┗ CucumberRunnerTest.java
┃----┗ resources/
┃----┃----┣---- config/
┃----┃----┃----┃ ┗ config.properties
┃----┃----┗ Features/
┃----┃----┃----┣---- searchTwitter.feature
┃----┃----┃----┣---- sendTweet.feature
┃----┃----┃----┣---- twitterLogin.feature
┃----┃----┃----┣---- userprofile.feature
┃----┃----┃----┗ userTimeLine.feature
┣---- .gitignore
┗ pom.xml

   ```
   
<!-- CONTACT -->
# Contact

Sonu Sadasivan - sonu.sadasivan@gmail.com
LinkedIn - https://www.linkedin.com/in/sonups/

Project Link: [https://github.com/sonups/bdd-selenium-java](https://github.com/sonups/bdd-selenium-java)


