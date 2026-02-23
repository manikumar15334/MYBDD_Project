package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        // Rerun failed tests from rerun.txt file
        features = {"src/test/resources/features/"},
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"  // Save Failed test scenarios in rerun.txt file
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
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

