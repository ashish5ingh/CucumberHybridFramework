package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	
	WebDriver driver;
	//private ConfigReader cr;
	//private DriverFactory df;

	@Before
	public void setup() {
		
		Properties prop = new ConfigReader().initializeProperties();  //this step reduce code
		//cr = new ConfigReader();
		//Properties prop=cr.initializeProperties();
		//df = new DriverFactory();
	    //driver = df.initializeBrowser(prop.getProperty("browser"));
	    driver= new DriverFactory().initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) {
			
			byte[] srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		driver.quit();
	}
}
