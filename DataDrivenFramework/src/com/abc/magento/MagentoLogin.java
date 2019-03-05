package com.abc.magento;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagentoLogin 
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\java\\Revision\\DataDrivenFramework\\src\\com\\abc\\utilities\\datadriven.properties");
		Properties p =new Properties();
		p.load(fis);
		String urlData = p.getProperty("url");
		String emailData = p.getProperty("email");
		String passData = p.getProperty("password");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(urlData);
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.id("email")).sendKeys(emailData);
		driver.findElement(By.id("pass")).sendKeys(passData);
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();		
	}
}
