package com.test.lambda;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Daft {
	public boolean status=false; 
	public static void main(String[] args) throws InterruptedException{
		//public boolean status=false; 
		String url="https://www.daft.ie/";
		String email="rswa@gmail.com";
		String password="Viak@123";
		By acceptall_loc=By.xpath("//button[contains(text(),'Acc')]");
		By share_loc=By.xpath("//li[contains(text(),'Share')]");
		By enter_loc=By.xpath("//input[contains(@aria-labelledby,'search')]");
		By list_loc=By.xpath("//ul[contains(@data-testid,'re')]//li[2]");
		By signin_loc=By.xpath("//a[contains(text(),'Sign')]");
		By username_loc=By.xpath("//input[contains(@id,'username')]");
		By password_loc=By.xpath("//input[contains(@id,'password')]");
		By login_btn=By.xpath("//div//input[contains(@name,'login')]");
		By email_loc=By.xpath("//button[contains(@aria-label,'Email')]");
		By send_btn=By.xpath("//button[contains(@aria-label,'Send')]");
		By next_btn=By.xpath("//button[contains(@aria-label,'Next')]//span[contains(text(),'Nex')]");
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_109.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(acceptall_loc).click();
		Thread.sleep(1500);
		driver.findElement(signin_loc).click();
		Thread.sleep(1500);
		driver.findElement(username_loc).sendKeys(email);
		Thread.sleep(1500);
		driver.findElement(password_loc).sendKeys(password);
		Thread.sleep(1500);
		driver.findElement(login_btn).click();
		Thread.sleep(3000);
		
		filters(driver,"Dublin 8", "300", "3000", "1", "3");
		
		int getsize=driver.findElements(By.xpath("//ul[contains(@data-testid,'re')]//li")).size();
		for(int i=1;i<=getsize;i++){
				list(driver, i);
				driver.navigate().back();
				//logo(driver);
				//share(driver);
			}
//		ScrollUpOrDown(driver, Display);
		Thread.sleep(3000);
		boolean Display = driver.findElement(By.xpath("//p[contains(@data-testid,'pag')]")).isDisplayed();
		if(Display){
		Thread.sleep(3000);
		ScrollUpOrDown(driver, next_btn);
		Thread.sleep(3000);
		driver.findElement(next_btn).click();
		int getsizee=driver.findElements(By.xpath("//ul[contains(@data-testid,'re')]//li")).size();
		for(int z=1;z<=getsizee;z++){
			list(driver, z);
			Thread.sleep(3000);
			driver.navigate().back();
			//logo(driver);
			//share(driver);
		}
		}else{
			driver.quit();
		}
		Thread.sleep(10000);
		driver.quit();
	}
	
	public static boolean ScrollUpOrDown(WebDriver driver,By ele){
		try{
			WebElement element=driver.findElement(ele);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(ele).isDisplayed();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean list(WebDriver driver,int list){
		try{
//			String email="vin7@gmail.com";
			String phone="+353893445521";
//			String phone="+353844444457";
//			String email="ka@gmail.com";
//			String email="cufhomes@gmail.com";
			String email="amr@gmail.com";
//			String phone="+353844444463";
			By list_loc=By.xpath("//ul[contains(@data-testid,'re')]//li["+list+"]");
			By email_loc=By.xpath("//button[contains(@aria-label,'Email')]");
			By send_btn=By.xpath("//button[contains(@aria-label,'Send')]");
			By fullname=By.xpath("//input[contains(@name,'name')]");
			By youremail_loc=By.xpath("//input[contains(@name,'email')]");
			By phone_loc=By.xpath("//input[contains(@name,'phone')]");
			By msg_loc=By.xpath("//textarea[contains(@id,'message')]");
			By close_loc=By.xpath("//button[contains(@class,'styles__Close')]");
			
			Thread.sleep(3000);
			ScrollUpOrDown(driver, list_loc);
			driver.findElement(list_loc).click();
			Thread.sleep(3000);
			ScrollUpOrDown(driver, email_loc);
			driver.findElement(email_loc).click();
			Thread.sleep(3000);
			driver.findElement(fullname).sendKeys("test");
			Thread.sleep(3000);
			driver.findElement(youremail_loc).sendKeys(email);
			Thread.sleep(3000);
			driver.findElement(phone_loc).sendKeys(phone);
			Thread.sleep(3000);
			driver.findElement(msg_loc).clear();
//			driver.findElement(msg_loc).sendKeys("Hello , Me and my Sister are looking for a permanent accommodation. " + '\n' + " We came across your advertisement and we are very much interested in renting it. " + '\n' + " We are  working in the Dublin.  " + '\n' + " Earning more than 60000+ euros and we have access to funds more than 50000 euros combinely we can provide pay slips and references. " + '\n' + " We are clean, peaceful, non party and non smokers. " + '\n' + " We don’t have pets with us. We maintain the cleanliness standard of the house. " + '\n' + " I would like to know if you can arange viewing.  " + '\n' + " We can move in immediately as well.  " + '\n' + " Thank you,  " + '\n' + " Kavya");
  //   		driver.findElement(msg_loc).sendKeys("Hello , Me and my partner and more 2 our friends are looking for a permanent accommodation. " + '\n' + " We came across your advertisement and we are very much interested in renting it." + '\n' + " We all are  working in the Dublin. " + '\n' + " Earning more than 80000+ euros combinely yearly and can provide pay slips and references." + '\n' + " We are clean, peaceful, vegetarian, non party and non smokers. " + '\n' + " We don’t have pets with us. We maintain the cleanliness standard of the house. " + '\n' + " I would like to know if you can arange viewing." + '\n' + " We can move in immediately as well. " + '\n' + " Thank you, " + '\n' + " Kajal");
     		driver.findElement(msg_loc).sendKeys("Hello ,I am looking for a permanent accommodation." + '\n' + " We came across your advertisement and we are very much interested in renting it." + '\n' + " I am working in the Dublin." + '\n' + " Earning more than 30000+ euros and we have access to funds more than 30000 euros," + '\n' + " I can provide pay slips and references." + '\n' + " I am clean, peaceful, non party and non smoker. " + '\n' + "I don’t have pets with us. " + '\n' + "I maintain the cleanliness standard of the house." + '\n' + " I would like to know if you can arange viewing." + '\n' + " I can move in immediately as well. " + '\n' + " Thank you," + '\n' + "Amey");
//			driver.findElement(msg_loc).sendKeys("Hello , Me and my fiancé are looking for a permanent accommodation. " + '\n' + " We came across your advertisement and we are very much interested in renting it. " + '\n' + " We both are full time working professionals earning more than 70000+ euros yearly and can provide pay slips and references. " + '\n' + " We are clean, peaceful, vegetarian, non party and non smokers." + '\n' + " We don’t have pets with us. " + '\n' + " We maintain the cleanliness standard of the house. " + '\n' + " I would like to know if there is any possibility that we can have a viewing. " + '\n' + " We can move in immediately as well.  " + '\n' + " Thank you," + '\n' + " Swati");
			Thread.sleep(3000);
			driver.findElement(send_btn).click();
			Thread.sleep(3000);
			driver.findElement(close_loc).click();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean logo(WebDriver driver){
		try{
			By logo=By.xpath("//a//img[contains(@alt,'Daft')]");
			Thread.sleep(3000);
			driver.findElement(logo).click();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean share(WebDriver driver){
		try{
			By share_loc=By.xpath("//li[contains(text(),'Share')]");
			By enter_loc=By.xpath("//input[contains(@aria-labelledby,'search')]");
			By list_loc=By.xpath("//ul[contains(@data-testid,'re')]//li[2]");
			driver.findElement(share_loc).click();
			Thread.sleep(3000);
			driver.findElement(enter_loc).sendKeys("Dublin 24");
			Thread.sleep(3000);
			driver.findElement(enter_loc).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean filters(WebDriver driver,String location,  String minprice,String maxprice,String maxbed,String minbed){
		try{
			By share_loc=By.xpath("//li[contains(text(),'Rent')]");
			By enter_loc=By.xpath("//input[contains(@aria-labelledby,'search')]");
			By list_loc=By.xpath("//ul[contains(@data-testid,'re')]//li[2]");
			By price_btn=By.xpath("//button[contains(text(),'Price')]");
			By done_btn=By.xpath("//button//span[contains(text(),'Done')]");
			By beds_btn=By.xpath("//button[contains(text(),'Beds')]");
			
			
			driver.findElement(share_loc).click();
			Thread.sleep(3000);
			driver.findElement(enter_loc).sendKeys(location);
			Thread.sleep(3000);
			driver.findElement(enter_loc).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			driver.findElement(price_btn).click();
			Thread.sleep(3000);
			WebElement tstdrpdwn=driver.findElement(By.name("rentalPriceFrom"));
			Select dropdown=new Select(tstdrpdwn);
			dropdown.selectByValue(minprice);
			Thread.sleep(3000);
			
			WebElement tstdrpdwn2=driver.findElement(By.name("rentalPriceTo"));
			Select dropdown2=new Select(tstdrpdwn2);
			dropdown2.selectByValue(maxprice);
			
			Thread.sleep(3000);
			driver.findElement(done_btn).click();
			
			Thread.sleep(3000);
			driver.findElement(beds_btn).click();
			
			Thread.sleep(3000);
			WebElement tstdrpdwn3=driver.findElement(By.name("numBedsFrom"));
			Select dropdown3=new Select(tstdrpdwn3);
			dropdown3.selectByValue(maxbed);
			
			Thread.sleep(3000);
			WebElement tstdrpdwn4=driver.findElement(By.name("numBedsTo"));
			Select dropdown4=new Select(tstdrpdwn4);
			dropdown4.selectByValue(minbed);
			By bedsdone_btn=By.xpath("//div[contains(@data-testid,'numBedsMenu')]//button//span[contains(text(),'Done')]");
			Thread.sleep(3000);
			
			driver.findElement(bedsdone_btn).click();
			
			
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	
}


