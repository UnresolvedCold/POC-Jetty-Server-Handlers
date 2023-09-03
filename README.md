# POC Jetty server handlers

This repository can be used as the boilerplate for creating embedded servers in your app using the handlers approach.

## Installation

The app is written for `Java 20+` but can be run using any version of `Java`.

To run it with a different version of `Java`, please change the `Java` version in `pom.xml`.

It also required `maven` for dependency management.

To run the app use the below command.

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.schwiftycold.poc.jettypoc.App"
```
