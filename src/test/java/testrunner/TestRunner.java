package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"step"},
        dryRun = false,
        strict = true,
        monochrome = true,
//		tags = "@AddPlace",
        plugin = {"json:target/jsonReports/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish = false
)
public class TestRunner {

    @BeforeClass
    public static void setupClass() {
        System.out.println("------- JUnit BeforeClass hook started");

    }

    // A method with annotation @AfterClass runs at test class completion time, i.e. after the whole bunch of all tests
    @AfterClass
    public static void teardownClass() {
        System.out.println("--------- JUnit AfterClass hook started; gracefully shutting down hamster");
    }

    // A method with annotation @Before runs at test method initialization time, i.e. before every single test
    // for Cucumber testrunner.Runner it will never appear
    @Before
    public void setupMethod() {
        System.out.println("----------- JUnit Before hook called");
    }

    // A method with annotation @After runs at test method completion time, i.e. after every single test
    // for Cucumber testrunner.Runner it will never appear
    @After
    public void teardownMethod() {
        System.out.println("----------- JUnit After hook called");
    }
}
