package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")

@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "stepdefinitions,hooks"
)

@ConfigurationParameter(
        key = Constants.FILTER_TAGS_PROPERTY_NAME,
        //value = "@regression"
        value = "@smoke"
)
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value =
                "pretty," +
                        "html:reports/cucumber-report.html," +
                        "json:reports/cucumber.json," +
                        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)

public class TestRunner {
}