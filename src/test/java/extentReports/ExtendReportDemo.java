package extentReports;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {
	ExtentReports extent;

	ExtentTest test;

	@BeforeTest
	public void start() {

		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\91888\\eclipse\\TestNG_Practice_Session\\Report\\extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@Test
	public void login() {

		test = extent.createTest("user i login to first page");
		test.log(Status.PASS, "signin page got pass");
	}

	@Test
	public void homePage() {

		test = extent.createTest("Homepage test").assignAuthor("Oranium").assignCategory("Regression")
				.assignDevice("Chrome Browser");
		test.pass("user is on homepage successfully");

	}

	@Test
	public void productpage() {
		test = extent.createTest("productpage test").assignAuthor("tech").assignCategory("smoke")
				.assignDevice("edge Browser");
		test.fail("product test case got failed");

	}

	@AfterTest
	public void tearDown() {

		extent.flush();
	}

}
