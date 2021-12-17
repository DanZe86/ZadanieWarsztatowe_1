package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/cucumber/features/", plugin={"pretty","html:out.html"}, glue="stepDefinitions")
//DeleteAddress.feature
//CreateNewAddress.feature
//AddShoppingItem.feature
//"pretty","html:testResults.html"
public class TestRunner {



}




