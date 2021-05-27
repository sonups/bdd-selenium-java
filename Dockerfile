FROM maven:3.8.1-jdk-8

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN mvn clean compile
CMD mvn test -Dcucumber.filter.tags="@all"