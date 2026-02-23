package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        // Rerun failed tests from rerun.txt file
        features = {"@target/rerun.txt"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        }
)


public class ReRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return super.scenarios();
        }

        @BeforeSuite
        public void beforeSuite(){
                System.out.println("========Test Execution Started===========");
        }

        @AfterSuite
        public void afterTest(){
                System.out.println("========Test Execution Completed===========");
        }
}
