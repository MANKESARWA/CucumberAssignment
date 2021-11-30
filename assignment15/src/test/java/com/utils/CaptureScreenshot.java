package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.stepdef.StepLogin;


public class CaptureScreenshot {
	public static void captureScreen() throws IOException
	{
		String fileName = "";
		TakesScreenshot ts = (TakesScreenshot) StepLogin.driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		
		fileName = "failscreen"+new Date().getTime()+".jpg";
		FileUtils.copyFile(ss,new File("./ScreenShot/"+fileName));
		
	}
}
