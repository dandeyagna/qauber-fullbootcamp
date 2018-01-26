
package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="Feature/addentity.feature",
		glue={"pom1.pages"}
		)
public class TestRunner {

}