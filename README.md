# API Automation Test BDD framework
API Automation Test is RestAssured based Cucumber framework to perform API testing. This project is useful as an example of API Testing with RestAssured and Java playing nicely together.

## Getting Started
```
1. git clone git@github.com:grassato/RestasssuredCucumber.git"
2. Navigate to RestasssuredCucumber
```

## Run project and Generate Report
**In terminal from root project folder (RestasssuredCucumber), run below commands as required**
- To run all features `mvn clean test verify`
- To pass environment variable from command line `mvn clean test verify`

`mvn clean test verify -DargLine=-DENVIRONMENT=dev`

### Reports used
- `Spark HTML Report`
- `Cucumber PDF Report`
- `Cucumber HTML Report`
