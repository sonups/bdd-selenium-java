<!-- PROJECT LOGO -->
<br />
<p align="center">
   <a href="https://github.com/sonups/cypress-todos-automated-test">
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
  * [Clone the repo](#1-clone-the-repo-and-install-npm-dependencies)
  * [Different ways of Building And Executing project](#different-ways-of-building--executing-project)
  	* [1. Running tests in local](#1-running-tests-in-local)
  	 	* [1. Clone the repo and Install npm dependencies](#1-clone-the-repo-and-install-npm-dependencies)
         * [2. Verify Lint](#2-verify-lint)
         * [3. Various Test configurations](#3-various-test-configurations)
         * [4. Structure of BDD feature files](#4-structure-of-bdd-feature-files)
         * [5. Report Generation](#5-report-generation)
  	* [2. Running tests in docker](#2-running-tests-from-docker)
  		* [1. Run docker build](#1-run-docker-build)
         * [2. (Optional) Remove existing running containers](2-optional-remove-existing-running-containers-required-when-there-is-already-a-container-running-with-same-name)
         * [3. Execute tests by passing specific tags](#3-execute-tests-by-passing-specific-tags)
  	* [3. Running tests in Jenkins hosted from docker](#3-running-tests-in-jenkins-hosted-from-docker)
  		* [3.1 Setting up jenkins](#31-setting-up-jenkins)
  	  		* [OPTION A - Running shell script jenkins-run.sh (In linux)](#------option-a----running-shell-script-jenkins-runsh-in-linux)
  	  	 	* [OPTION B - Executing each commands in shell(Windows or Mac)](#------option-b----executing-each-commands-in-shellwindows-or-mac)
         * [3.2 Executing tests in jenkins](#32-executing-tests-in-jenkins)
  	* [4. Running tests in Jenkins hosted in Azure cloud vm](#4-running-tests-in-jenkins-hosted-in-azure-cloud-vm)
- [Contact](#contact)


### Built With

Selenium, Cucumber, mvn , Java8

* [Mvn](https://maven.apache.org/)
* [Selenium](https://www.selenium.dev/)
* [Cucumber](https://cucumber.io/)
* [Java](https://www.java.com/en/)

### Project compilation and execution

<!-- SETTING PROJECT LOCALLY -->

##### 1. To run all cases use tag - @all (tested in windows 10 & ubuntu)
   ```sh
   git clone https://github.com/sonups/cypress-todos-automated-test
   cd cypress-todos-automated-test
   mvn compile test -Dcucumber.filter.tags="@all"
   ```
##### 3. Tags

| Specifc Tag                            | Description                  | Full command                  |
| ------------- |:-------------:| 
| @all | Executes all scenarios | mvn compile test -Dcucumber.filter.tags="@all" |
| @login | Execute login scenario | mvn compile test -Dcucumber.filter.tags="@login" |
| @user-timeline | Execute user timeline scenario |  mvn compile test -Dcucumber.filter.tags="@user-timeline" |
| @user-profile | Execute user profile scenario |  mvn compile test -Dcucumber.filter.tags="@user-profile" |
| @send-tweet | Executes all scenarios | mvn compile test -Dcucumber.filter.tags="@send-tweet" |
| @search-page | Executes all scenarios | mvn compile test -Dcucumber.filter.tags="@search-page" |



 ##### 2. Browser configuration
 
Specifcy the browser in config.properties file ( Ensure the browser is installed and available in OS)

 Location : src\test\resources\config\config.properties
 
 Sample configuration 
   ```sh
   #browser = firefox
    browser = chrome
   ```

 ##### 4. Structure of Files 
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

<!-- CONTACT -->
# Contact

Sonu Sadasivan - sonu.sadasivan@gmail.com
LinkedIn - https://www.linkedin.com/in/sonups/

Project Link: [https://github.com/sonups/cypress-todos-automated-test](https://github.com/sonups/cypress-test-docker)


