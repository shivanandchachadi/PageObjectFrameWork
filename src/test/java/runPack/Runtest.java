package runPack;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/story.feature",glue="stepdef",plugin= {"html:target/cucumber-html-report"})
public class Runtest {

}


