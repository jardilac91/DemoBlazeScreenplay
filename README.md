# DemoBlazeScreenplay

This project performs different E2E tests againts the page https://www.demoblaze.com

This project implements the screenplay pattern using Java with Serenity+Cucumber.

To run the project you must have to install: 

* Java 17.0 +.
* Gradle 8.0 +.

The structure of the project consists in the following paths:

* src/main/java/demoblaze
  * tasks: This folder contains the tasks performed by the user. 
  * ui: This folder contains the representation of the pages and their elements.
  * utils: Utility classes that are used in tasks.
* test/java/demoblaze/
  * runners: Folder that contains the runner for the project.
  * stepdefinitions: This folder contains the step definitions used to run the scenarios.
* test/resources/features: This folder contains the feature file used in the project.

To run the tests, execute the following command:

```bash
gradle clean test
```

