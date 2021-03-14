### System under test:
www.ss.com/en - portal of private ads, widely used in Latvia (where most of our current QA crew belong), and quite often used as a test polygon. We encourage you to use its mobile version as well.


### Feature to test:
Adding ad to memo as a favorite. Go to any category, search for an ad, open it, scroll down to see “Add to favorites”. Once you click it, it gets added to the “Memo" section (on the top in the header menu). Alternatively, you can select ads from the list and add several to Memo at once. You can do that while searching as well - the advanced search from the header menu. Please be sure to achieve a reasonable coverage of the feature to test. Feel free to do any other use case that you feel could demonstrate your testing decisions better.


### Limitations:
Task preferably have to be implemented with stack described in Recommended  stack section, but if you realize that it is not comfortable for you, feel free to choose your own and explain your choice. Beware that unlike the test site, the product you'll mainly be testing at us is built with TypeScript as a HTML5 front-end and Scala in the back-end. So would be wise to chose something along the lines of Scala or JavaScript.


### Acceptance criteria:
- feature is reasonably tested with asserts that make business sense;
- spec is readable and not too verbose;
- solution is well structured, test logic decoupled from app specifics (like page object pattern or other alternatives);
- solution works on any platform (windows, linux, mac);
- solution uploaded to GitHub private repository and access is granted to task reviewers.


### Recommended  stack:
- Webdriverio (https://webdriver.io/)
- Typescript (https://www.typescriptlang.org/),
- Gherkin (https://cucumber.io/)  or Mocha (https://mochajs.org/).