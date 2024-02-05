package testrunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = 	"src/test/resources/features",
		glue = {"stepdefenitions"},
		monochrome = true)

public class TestRunner {

}
