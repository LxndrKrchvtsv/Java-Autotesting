package com.stv.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/stv/bdd/features",
		glue = "com.stv.bdd.steps",
		tags = "@task8",
		plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunnerTask8 extends AbstractTestNGCucumberTests {
}