$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/GoogleSearchForIPhone.feature");
formatter.feature({
  "line": 1,
  "name": "Search for Iphone and assert results",
  "description": "As an end user I need to be able to search for a keyword in google\nSo that I can see the desired results and act accordingly",
  "id": "search-for-iphone-and-assert-results",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Search for Iphone",
  "description": "",
  "id": "search-for-iphone-and-assert-results;search-for-iphone",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I have launched google homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I search based on a \"\u003ckeyword\u003e\" and navigate to search results page",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "in the search results I look for a specific \"\u003clink\u003e\" and click on it",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I verify the link details",
  "keyword": "And "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "search-for-iphone-and-assert-results;search-for-iphone;",
  "rows": [
    {
      "cells": [
        "keyword",
        "link"
      ],
      "line": 18,
      "id": "search-for-iphone-and-assert-results;search-for-iphone;;1"
    },
    {
      "cells": [
        "Iphone",
        "Amazon"
      ],
      "line": 19,
      "id": "search-for-iphone-and-assert-results;search-for-iphone;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 19,
  "name": "Search for Iphone",
  "description": "",
  "id": "search-for-iphone-and-assert-results;search-for-iphone;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I have launched google homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I search based on a \"Iphone\" and navigate to search results page",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "in the search results I look for a specific \"Amazon\" and click on it",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I verify the link details",
  "keyword": "And "
});
formatter.match({
  "location": "SearcBasedOnKeyWordDefinition.i_have_launched_google_homepage()"
});
formatter.result({
  "duration": 2772258108,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Iphone",
      "offset": 21
    }
  ],
  "location": "SearcBasedOnKeyWordDefinition.i_search_based_on_a_and_navigate_to_search_results_page(String)"
});
formatter.result({
  "duration": 3683385535,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Amazon",
      "offset": 45
    }
  ],
  "location": "SearcBasedOnKeyWordDefinition.in_the_search_results_I_look_for_a_specific(String)"
});
formatter.result({
  "duration": 28718850271,
  "status": "passed"
});
formatter.match({
  "location": "SearcBasedOnKeyWordDefinition.i_verify_the_link_details()"
});
formatter.result({
  "duration": 8433066661,
  "status": "passed"
});
});