package reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

private static ExtentReports extent;

public static ExtentReports getReport(){

if(extent==null){

String reportPath =
System.getProperty("user.dir") + "/reports/FlightReport.html";

File reportFolder =
new File(System.getProperty("user.dir") + "/reports");

if(!reportFolder.exists()){

reportFolder.mkdirs();

}

ExtentSparkReporter spark =
new ExtentSparkReporter(reportPath);

spark.config().setReportName("Flight Booking Automation Report");

spark.config().setDocumentTitle("Automation Execution Report");

extent=new ExtentReports();

extent.attachReporter(spark);

extent.setSystemInfo("Tester", "Kumar Prakhar");
extent.setSystemInfo("Project", "Flight Booking Automation");
extent.setSystemInfo("Environment", "QA");
extent.setSystemInfo("Browser", "Chrome");
extent.setSystemInfo("Automation Tool", "Selenium");
extent.setSystemInfo("Framework", "TestNG + Maven");

}

return extent;

}

}