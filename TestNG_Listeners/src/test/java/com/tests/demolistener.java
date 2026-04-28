package com.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class demolistener implements ITestListener {
	 private static final Logger log = LogManager.getLogger(demolistener.class);

	public void onTestStart(ITestResult result) {
		 log.info(result.getName() + " test started");
	}

	public void onTestSuccess(ITestResult result) {
		 log.info("Test PASSED: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		 log.error("Test FAILED: " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		log.warn("Test SKIPPED: " + result.getName());
	}
}
