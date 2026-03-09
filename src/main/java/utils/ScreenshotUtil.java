package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

public static String captureScreenshot(WebDriver driver,String stepName){

String timestamp =
new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

String folderPath =
System.getProperty("user.dir") + "/screenshots/";

File folder = new File(folderPath);

if(!folder.exists()){
folder.mkdirs();
}

String filePath =
folderPath + stepName + "_" + timestamp + ".png";

try{

File src =
((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

File dest = new File(filePath);

FileUtils.copyFile(src,dest);

}catch(Exception e){

System.out.println("Screenshot failed");

}

return filePath;

}
}