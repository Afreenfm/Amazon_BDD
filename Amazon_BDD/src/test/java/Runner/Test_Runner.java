package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources\\Search_functionality\\search.feature","src\\test\\resources\\Search_history\\searchhistory.feature","src\\test\\resources\\Search_side_bar\\Search_sidebar.feature"},
glue = "StepDefination",


dryRun = false,
monochrome = true,
//tags = "@Searchsidebar_2",
plugin = {"html:testoutput/afreen.html","junit:testoutput/afreen.xml","json:testoutput/afreen.json"}
)
public class Test_Runner {
	
	
}





