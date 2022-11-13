package cucumber.Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/jsonReports/Report.json"},
glue= {"stepdefinitionTestClass"}
)

public class TestRunner {
	@AfterClass
	public static void tearDown() {
		
	}
	}
	
