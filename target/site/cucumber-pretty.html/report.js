$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/ApiPostTest.feature");
formatter.feature({
  "name": "Testing API create function",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "",
  "description": "As a httpbin user, i need to validate send data with HTTP post function ",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "setup test data into json \u0026 use post method",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.setup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate test cases",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.postTestCasesValidate()"
});
formatter.result({
  "status": "passed"
});
});