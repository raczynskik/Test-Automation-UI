# Test Automation UI

The project shows how to use a cucumber/selenide to build automated tests.

The project goal is to show an example of implementation with use of a page object model design pattern.

## Requirements

* Java installed - [link](https://aws.amazon.com/corretto/)
* Maven installed- [link](https://maven.apache.org/)

## How to run tests
Open terminal in the project and type:

```
mvn clean test
```

### How to choose a browser


```
 mvn clean test -Dselenide.browser=safari
```
In this case, we use the selenide property.
Link to all selenide properties - [link](https://selenide.org/javadoc/current/com/codeborne/selenide/Configuration.html)