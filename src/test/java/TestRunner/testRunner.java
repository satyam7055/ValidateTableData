package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(		
		features= {"src/test/java/featuresfiles/"},		
		glue= {"stepdefinitions"},// Steps file package
		monochrome= true
		)

public class testRunner extends AbstractTestNGCucumberTests{
	
	

}
