package com.endava;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" },
	format = { "json:cucumber.json" })
public class RunCucumberTest {
}
