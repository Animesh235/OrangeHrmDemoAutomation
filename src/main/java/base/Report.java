package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
    // Static ExtentReports instance to be reused
    private static ExtentReports extent;
    private static ExtentSparkReporter spark;

    // Initialize Extent Report once
    public static void initReport() {
        if (extent == null) {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("ExtentReport.html");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Test Results");
            extent.attachReporter(spark);
        }
    }

    // Create and return an ExtentTest instance for each test
    public static ExtentTest createTest(String testName) {
        if (extent == null) {
            initReport(); // Initialize if not done
        }
        return extent.createTest(testName);
    }

    // Flush the report at the end of all tests
    public static void flushReport() {
        if (extent != null) {
            extent.flush(); // Write everything to the report
        }
    }
}
