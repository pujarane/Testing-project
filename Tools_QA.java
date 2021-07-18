package project;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Tools_QA {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\OneDrive\\Desktop\\Selenium_jar\\chromedriver.exe");

		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://demoqa.com/");
		Thread.sleep(2000);
		
		System.out.println("Current URL: "+ w.getCurrentUrl());   //current url
		
		System.out.println("Title: "+ w.getTitle());  //title
		
		//---------------------------------elements------------------------------------------------------
		
		JavascriptExecutor js = (JavascriptExecutor) w;
		js.executeScript("window.scrollBy(0,1500)");
		w.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]")).click();
		Thread.sleep(2000);
		
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]")).getText());

		// -------------------------------------textbox-------------------------------------------
		
		w.findElement(By.xpath("//*[@id=\"item-0\"]/span")).click();
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
		
		w.findElement(By.id("userName")).sendKeys("abc");
		w.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		w.findElement(By.id("currentAddress")).sendKeys("abc");
		w.findElement(By.id("permanentAddress")).sendKeys("abc");
		Thread.sleep(2000);
		JavascriptExecutor jss = (JavascriptExecutor) w;
		jss.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		w.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(2000);
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[6]/div[1]")).getText());

		//------------------------------------------- check box-------------------------------------------------------------
		

		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(1000);
		
		String s = w.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]")).getText();  //gettext
		System.out.println("Text: " +s);
		
		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click(); // plus
		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")).click(); // notes
		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")).click(); // react
		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[1]/ol[1]/li[2]/span[1]/label[1]/span[1]/*[1]")).click(); // angular
		JavascriptExecutor js1 = (JavascriptExecutor) w;
		js1.executeScript("window.scrollBy(0,1500)");
		w.findElement(By.xpath("//span[contains(text(),'Downloads')]")).click();
		Thread.sleep(2000);
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
		
		//---------------------------------------------- radio button----------------------------------------------------------------------
		

		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]")).click();
		w.findElement(By.xpath("//label[contains(text(),'Yes')]")).click();
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
		Thread.sleep(1000);
	

		//-------------------------------------- webtable--------------------------------------------------------------------

		w.findElement(By.xpath("//*[@id=\"item-3\"]")).click();
		Thread.sleep(1000);
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());

		// add record
		w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")).click();
		w.findElement(By.id("firstName")).sendKeys("a");
		w.findElement(By.id("lastName")).sendKeys("s");
		w.findElement(By.id("userEmail")).sendKeys("as@gmail.com");
		w.findElement(By.id("age")).sendKeys("24");
		w.findElement(By.id("salary")).sendKeys("20000");
		w.findElement(By.id("department")).sendKeys("abc");
		Thread.sleep(3000);
		w.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		System.out.println("Webtable -Add record");

		// edit table
		Thread.sleep(3000);
		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/span[1]/*[1]")).click();
		w.findElement(By.id("age")).clear();
		Thread.sleep(1000);
		w.findElement(By.id("age")).sendKeys("40");
		Thread.sleep(2000);
		w.findElement(By.id("salary")).clear();
		Thread.sleep(2000);
		w.findElement(By.id("salary")).sendKeys("25000");
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(2000);
		System.out.println("Webtable - Edit record");

		// delete record
		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/span[2]/*[1]")).click();
		System.out.println("Webtable - Delete record");
		Thread.sleep(2000);

		// search box

		w.findElement(By.xpath("//input[@id='searchBox']")).sendKeys("Alden");
		Thread.sleep(2000);
		System.out.println("Webtable - Search box");

		// scrolling
		JavascriptExecutor js2 = (JavascriptExecutor) w;
		js2.executeScript("window.scrollBy(0,1500)");

		//-------------------------------------- buttons---------------------------------------------------------

		w.findElement(By.xpath("//*[@id=\"item-4\"]")).click();
		
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());

		// double click
		Actions a = new Actions(w);

		WebElement web = w.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		a.doubleClick(web).build().perform();
		System.out.println(w.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText());
		Thread.sleep(2000);

		// right click

		Actions a1 = new Actions(w);

		WebElement web1 = w.findElement(By.xpath("//button[@id='rightClickBtn']"));

		a.contextClick(web1).build().perform();
		System.out.println(w.findElement(By.xpath("//p[@id='rightClickMessage']")).getText());
		Thread.sleep(2000);

		// click me

		w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/button[1]")).click();
		System.out.println(w.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText());
		Thread.sleep(2000);

			// scrolling
			JavascriptExecutor js3 = (JavascriptExecutor) w;
			js3.executeScript("window.scrollBy(0,1500)");
	
		//------------------------------------- links--------------------------------------------------------------------------
	
			w.findElement(By.xpath("//*[@id=\"item-5\"]")).click();
			Thread.sleep(2000);
			System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());

		// new tab
		
		System.out.println(w.findElement(By.xpath("//strong[contains(text(),'Following links will open new tab')]")).getText());
		w.findElement(By.xpath("//a[@id='simpleLink']")).click();
		Thread.sleep(3000);

		// window handling
		Set<String> ss = w.getWindowHandles();
		Iterator<String> it = ss.iterator();
		String pc = it.next();
		String cc = it.next();
		w.switchTo().window(cc);
		Thread.sleep(2000);
		w.switchTo().window(pc);

		// links will send an api call

		JavascriptExecutor js4 = (JavascriptExecutor) w;
		js4.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		System.out.println(w.findElement(By.xpath("//strong[contains(text(),'Following links will send an api call')]")).getText());

		w.findElement(By.linkText("Created")).click();
		System.out.println("Link has responded with staus 201 and status text Created");
		Thread.sleep(2000);
		
		w.findElement(By.linkText("No Content")).click();
		System.out.println("Link has responded with staus 204 and status text No Content");
		Thread.sleep(2000);
		
		w.findElement(By.linkText("Moved")).click();
		System.out.println("Link has responded with staus 301 and status text Moved Permanently");		
		Thread.sleep(2000);
		
		w.findElement(By.linkText("Bad Request")).click();
		System.out.println("Link has responded with staus 400 and status text Bad Request");
		Thread.sleep(2000);
		
		w.findElement(By.linkText("Unauthorized")).click();
		System.out.println("Link has responded with staus 401 and status text Unauthorized");	
		Thread.sleep(2000);
		
		w.findElement(By.linkText("Forbidden")).click();
		System.out.println("Link has responded with staus 403 and status text Forbidden");
		Thread.sleep(2000);
		
		w.findElement(By.linkText("Not Found")).click();
		System.out.println("Link has responded with staus 404 and status text Not Found");
		Thread.sleep(2000);

		//------------------------------------------ broken link images-------------------------------------------

		w.findElement(By.xpath("//*[@id=\"item-6\"]")).click();
		Thread.sleep(2000);
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());

		//valid
		JavascriptExecutor js5 = (JavascriptExecutor) w;
		js5.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(1000);
		System.out.println("Valid Link");

		w.navigate().back();
		Thread.sleep(2000);
		
		//broken link
		
		JavascriptExecutor js6 = (JavascriptExecutor) w;
		js6.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		w.findElement(By.linkText("Click Here for Broken Link")).click();
		Thread.sleep(2000);
		System.out.println("Broken Link");
		
		w.navigate().back();
		Thread.sleep(2000);

		//------------------------------------------- upload and download------------------------------------------------------------------------
		JavascriptExecutor js7 = (JavascriptExecutor) w;
		js7.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id=\"item-7\"]")).click();
		Thread.sleep(2000);
		
		System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
		
		w.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Asus\\OneDrive\\Pictures\\1.jfif");
		Thread.sleep(2000);
		w.findElement(By.id("downloadButton")).click();
		
		
		//-------------------------------------dynamic property----------------------------------------------------------------------------
		
		JavascriptExecutor js8 = (JavascriptExecutor) w;
		js8.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//span[contains(text(),'Dynamic Properties')]")).click();
		Thread.sleep(7000);
		
		System.out.println(w.findElement(By.xpath("//div[contains(text(),'Dynamic Properties')]")).getText());
		
		
		
		
	//-------------------------------------------------Practice form-----------------------------------------	
		w.get("https://demoqa.com/");
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) w;   //scrolling
		 jse.executeScript("window.scrollBy(0,400)");
		 Thread.sleep(2000);
		 
		 System.out.println("Current URL:" + w.getCurrentUrl());
		 System.out.println("URL of page is:"+w.getTitle());
			
		
		w.findElement(By.xpath("//h5[contains(text(),'Forms')]")).click();     //click forms
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]")).click();  //click practice form
		Thread.sleep(2000);
		
		w.findElement(By.id("firstName")).sendKeys("PPP");    //first and last name
		w.findElement(By.id("lastName")).sendKeys("RRR");
			
		w.findElement(By.id("userEmail")).sendKeys("pbr@gmail.com");             //gmail
		w.findElement(By.xpath("//label[contains(text(),'Female')]")).click();   //gender
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)", ""); 
		w.findElement(By.id("userNumber")).sendKeys("1234567899");               //mb no.
		Thread.sleep(2000);
		
		 //subjects
		 // w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[6]/div[2]/div[1]/div[1]/div[1]")).sendKeys("maths");
		    
		//hobbies
	     w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[7]/div[2]/div[1]/label[1]")).click();
	     w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[7]/div[2]/div[3]/label[1]")).click();
	     Thread.sleep(2000);
	     js.executeScript("window.scrollBy(0,350)", ""); 
	   //file upload
	     w.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Asus\\Pictures\\1.jpg"); 
	    
	     w.findElement(By.id("currentAddress")).sendKeys("Address");     //address
	    
	    // Select s = new Select(w.findElement(By.xpath("//div[contains(text(),'Select State')]")));   //state
	 	//s.selectByIndex(1);
	     
	     w.findElement(By.id("submit")).click();
	     
	     
	     
	//----------------------------------------------Alert, Frames and windows --------------------------------------------------------     
	     
	     w.navigate().to("https://demoqa.com/");
	     Thread.sleep(2000);

	     System.out.println("Title of Page="+w.getTitle());
			System.out.println("URL of Page="+w.getCurrentUrl());
					
			Thread.sleep(1000);
		
			w.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]")).click();
			
			System.out.println(w.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]")).getText());

			System.out.println("Title of Page="+w.getTitle());
			System.out.println("URL of Page=" +w.getCurrentUrl());
				
			//window Handling
			//window 1

			w.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();
			
			w.findElement(By.id("tabButton")).click();
			
			Set <String> window1=w.getWindowHandles();
			Iterator <String> it1=window1.iterator();
			
			String par_win1=it1.next();
			
			String child_win1=it1.next();
			
			
			w.switchTo().window(par_win1);
			
			Thread.sleep(1000);
			
			w.switchTo().window(child_win1);
			System.out.println(w.findElement(By.id("sampleHeading")).getText());
			System.out.println("new tab opened");
			w.switchTo().window(par_win1);
			
			//window2
			
			w.findElement(By.id("windowButton")).click();
			
			Set <String> window2=w.getWindowHandles();
			Iterator <String> it2=window2.iterator();
			
			String par_win2=it2.next();
			
			String child_win2=it2.next();
			
			w.switchTo().window(par_win2);
			
			Thread.sleep(1000);
			w.switchTo().window(child_win2);
			System.out.println(w.findElement(By.id("sampleHeading")).getText());
			System.out.println("New window opened");
			w.switchTo().window(par_win2);
			
			//window3
			
			w.findElement(By.id("messageWindowButton")).click();
			
			Set <String> window3=w.getWindowHandles();
			Iterator <String> it3=window3.iterator();
			
			String par_win3=it3.next();
			                                                                                                                  
			String child_win3=it3.next();
			
			w.switchTo().window(par_win3);
			
			Thread.sleep(1000);
			w.switchTo().window(child_win3);
			System.out.println(w.findElement(By.xpath("/html[1]/body[1]")).getText());
			System.out.println("New Message window opened");
			Thread.sleep(1000);
			w.switchTo().window(par_win3);
			
			//Alert
			
			w.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
			
			//simple alert
			w.findElement(By.id("alertButton")).click();
			
			Thread.sleep(1000);
			
			//for accepting simple alert
			Alert a11=w.switchTo().alert();
			
			System.out.println(a11.getText());
			System.out.println("Simple Alert");
			
			a11.accept();
			System.out.println("Simple Alert accepted");
			
			//wait alert
			
			w.findElement(By.id("timerAlertButton")).click();
			
			Thread.sleep(6000);
			
			//for accepting wait alert
			Alert a2=w.switchTo().alert();
			
			System.out.println(a2.getText());
			System.out.println("wait alert");
			
			a2.accept();
			System.out.println("wait Alert accepted");
			
			//confirm alert
			
			//accepting confirm alert
				
			w.findElement(By.id("confirmButton")).click();
			
			Thread.sleep(1000);
			
			Alert a3=w.switchTo().alert();
			
			System.out.println(a3.getText());
			Thread.sleep(1000);
			System.out.println("confirm alert");
			a3.accept();
			System.out.println("confirm Alert accepted");
			
			//dissmiss confirm alert
			
			w.findElement(By.id("confirmButton")).click();
			Thread.sleep(1000);
					
			a3=w.switchTo().alert();
					
			System.out.println(a3.getText());
			Thread.sleep(1000);
			System.out.println("confirm alert");
			a3.dismiss();
			System.out.println("confirm  Alert dissmissed");
			
			//prompt alert
			
			w.findElement(By.id("promtButton")).click();
			
			Thread.sleep(1000);
			
			Alert a4=w.switchTo().alert();
			a4.sendKeys("abc123");
						
			System.out.println(a4.getText());
			Thread.sleep(1000);
			System.out.println("prompt alert");
			a4.accept();
			System.out.println("prompt  Alert accepted");
			
			//prompt alert dismiss
			w.findElement(By.id("promtButton")).click();
			
			Thread.sleep(1000);
			
			a4=w.switchTo().alert();
			a4.sendKeys("madhuri");
		
			System.out.println(a4.getText());
			Thread.sleep(1000);
			System.out.println("prompt alert");
			a4.dismiss();
			System.out.println("prompt  Alert dismissed");
			
			//Frames
			
				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[3]/span[1]")).click();
				w.switchTo().frame("frame1");
			
				System.out.println(w.findElement(By.id("sampleHeading")).getText());
				System.out.println("from frame1");
				
				w.switchTo().defaultContent();
			
				w.switchTo().frame("frame2");
				
				System.out.println(w.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
				System.out.println("from frame2");
				
				
				//for counting no. of frames
				List<WebElement> l=w.findElements(By.tagName("iframe"));
				
				System.out.println("Total iframes="+ l.size());
				
				
				//nested frames
				w.navigate().back();
				
				JavascriptExecutor js0=(JavascriptExecutor) w;	
				js0.executeScript("window.scrollBy(0,1500)");
				
				w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[4]/span[1]")).click();
				
				
				List<WebElement> l2=w.findElements(By.tagName("iframe"));
				
				System.out.println("Total iframes in nested iframes="+ l2.size());
				
			
				//for dialogue
				
				
				w.get("https://demoqa.com/modal-dialogs");
				
				//for small modal
				w.findElement(By.id("showSmallModal")).click();
				
				System.out.println(w.findElement(By.xpath("/html/body/div[4]/div/div/div[2]")).getText());
				
				w.findElement(By.id("closeSmallModal")).click();
				
				//for large modal
				
				w.findElement(By.id("showLargeModal")).click();
				System.out.println(w.findElement(By.xpath("//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]")).getText());
				
				w.findElement(By.id("closeLargeModal")).click();
				

//----------------------------------------- Widgets ---------------------------------------------------------------------------				
				
				
				w.get("https://demoqa.com/");
				
				w.manage().window().maximize();
				
				Thread.sleep(2000);
				
				w.getTitle();
				System.out.println("Title of page is : "+w.getTitle());
				
				w.getCurrentUrl();
				System.out.println("Current URL is : "+w.getCurrentUrl());

				// Widgets Module
				// for scroll down the page & click on widgets 
				JavascriptExecutor jes= (JavascriptExecutor) w; 
				
				jes.executeScript("window.scrollBy(0, 300)");
				
				w.findElement(By.xpath("//h5[contains(text(),'Widgets')]")).click();
				w.manage().window().maximize();
				jes.executeScript("window.scrollBy(0, 500)");
				Thread.sleep(2000);
				
				w.getTitle();
				System.out.println("Title of Current page is : "+w.getTitle());
				
				w.getCurrentUrl();
				System.out.println("Current URL is : " +w.getCurrentUrl());
						
		// for Accordian
				jes.executeScript("window.scrollBy(0,-400)");
				Thread.sleep(2000);

				w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[1]/span[1]")).click();
				Thread.sleep(2000);

				w.findElement(By.xpath("//div[@id='section1Heading']")).click();
				Thread.sleep(2000);
				
				w.findElement(By.id("section2Heading")).click();
				Thread.sleep(2000);
				                                                                                                                                                                    
				jes.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//*[@id=\"section3Heading\"]")).click();
				Thread.sleep(2000);
				
				List<WebElement> L= w.findElements(By.tagName("a"));
				System.out.println("Total Links are : "+L.size());
				w.navigate().back();
				Thread.sleep(2000);
				
		// for Auto Complete
				jes.executeScript("window.scrollBy(0,500)");
				w.findElement(By.xpath("//span[contains(text(),'Auto Complete')]")).click();
				Thread.sleep(2000);
						
				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
			/*	w.findElement(By.xpath("//div[contains(text(),'Red')]")).click();
				w.findElement(By.xpath("//div[contains(text(),'Purple')]")).click();
				w.findElement(By.xpath("//div[contains(text(),'Indigo')]")).click();
				Thread.sleep(2000);        
				w.findElement(By.xpath("//*[@id=\"autoCompleteSingleContainer\"]/div/div[1]")).click();   //sendKeys("Orange");
				w.findElement(By.xpath("//*[@id=\"autoCompleteSingleContainer\"]/div/div[1]/div[1]")).click();        	//Defect - not accepting data   */ 
			
				w.navigate().back();  
				Thread.sleep(2000); 
		 
		// for Date Picker
				jes.executeScript("window.scrollBy(0,250)");
				Thread.sleep(2000);
				w.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
				Thread.sleep(2000);
				
			// for Select Date
				w.findElement(By.id("datePickerMonthYearInput")).click();
				Select s1= new Select(w.findElement(By.className("react-datepicker__month-select")));
				s1.selectByValue("4");
				Thread.sleep(2000);
				
				Select s2= new Select(w.findElement(By.className("react-datepicker__year-select")));
				s2.selectByVisibleText("1993");
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[5]")).click();
				Thread.sleep(2000);
				System.out.println("05/27/1993 Date is selected");
				
		// for Date And Time
				w.findElement(By.id("dateAndTimePickerInput")).click();
				jes.executeScript("window.scrollBy(0,350)");

				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]")).click();
				Thread.sleep(2000);
				w.findElement(By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[6]")).click();
				Thread.sleep(2000);

				w.findElement(By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/span[1]")).click();
				Thread.sleep(2000);
				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[13]/a[1]")).click();
				Thread.sleep(2000);
				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")).click();
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[6]")).click();
				w.findElement(By.xpath("//div[contains(text(),'10')]")).click();
				Thread.sleep(2000);
				
		//for time	
				w.findElement(By.id("dateAndTimePickerInput")).click();
				jes.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]")).click();
				jes.executeScript("window.scrollBy(0,-200)");
				w.findElement(By.xpath("//li[contains(text(),'17:30')]")).click();
				Thread.sleep(2000);
				System.out.println("June/10/2022 5:30 PM Date & time is selected");
				w.navigate().back();
				Thread.sleep(2000);
					
		// for Slider
				jes.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				w.findElement(By.xpath("//span[contains(text(),'Slider')]")).click();
				System.out.println("Slider WebPage is open");
				Thread.sleep(2000);
				
				WebElement slider=w.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
				Actions act= new Actions(w);
				act.dragAndDropBy(slider,-150, 100).perform();     //move to backward
				Thread.sleep(2000);
				act.dragAndDropBy(slider, 200, 100).perform();     // move to forward
				Thread.sleep(2000);
				
				TakesScreenshot t = (TakesScreenshot) w;
				File src= t.getScreenshotAs(OutputType.FILE);
				Files.copy(src, new File ("E:\\Testing Class\\1.jpg"));
				w.navigate().back();
				Thread.sleep(2000);
			
		// for Progress Bar
				jes.executeScript("window.scrollBy(0,500)");
				w.findElement(By.xpath("//span[contains(text(),'Progress Bar')]")).click();
				System.out.println("Progress Bar WebPage is open");
				Thread.sleep(2000);
				w.findElement(By.xpath("//*[@id=\"startStopButton\"]")).click();
				Thread.sleep(4000);
			//	w.findElement(By.xpath("//div[contains(text(),'100%')]")).click();
				w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]")).click();
				Thread.sleep(2000);
				
				w.navigate().back();
				Thread.sleep(2000);
				
		// for Tabs
				jes.executeScript("window.scrollBy(0,500)");
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//span[contains(text(),'Tabs')]")).click();
				System.out.println("Tabs WebPage is open");
				Thread.sleep(2000);
				
				w.findElement(By.id("demo-tab-origin")).click();
				Thread.sleep(2000);
				w.findElement(By.id("demo-tab-what")).click();
				Thread.sleep(2000);
				w.findElement(By.linkText("Use")).click();
				Thread.sleep(2000);
			//	w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/nav[1]/a[4]")).click();
				boolean eleEnabled=	w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/nav[1]/a[4]")).isEnabled();
				System.out.println(eleEnabled);
				Thread.sleep(2000);

				w.navigate().back();
				Thread.sleep(2000);
				
		// for 	Tool Tips
				jes.executeScript("window.scrollBy(0,500)");
				Thread.sleep(2000);
				w.findElement(By.xpath("//span[contains(text(),'Tool Tips')]")).click();
				System.out.println("Tool Tips WebPage is open");
				Thread.sleep(2000);
				
				Actions A1 = new Actions(w);
				A1.moveToElement(w.findElement(By.xpath("//button[@id='toolTipButton']"))).perform();
				Thread.sleep(2000);
				
				WebElement text=w.findElement(By.xpath("//input[@id='toolTipTextField']"));
				Actions A2 = new Actions(w);
				A2.moveToElement(text).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
				
				Actions A3 = new Actions(w);
				A3.moveToElement(w.findElement(By.xpath("//a[contains(text(),'Contrary')]"))).perform();
				Thread.sleep(2000);
				
				jes.executeScript("window.scrollBy(0,300)");
				Actions A4 = new Actions(w);
				A4.moveToElement(w.findElement(By.xpath("//a[contains(text(),'1.10.32')]"))).perform();
				Thread.sleep(2000);
				w.navigate().back();
				Thread.sleep(2000);
			
			// for Menu
				jes.executeScript("window.scrollBy(0,600)");
				Thread.sleep(2000);
				w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[8]/span[1]")).click();
				System.out.println("Menu WebPage is open");
				Thread.sleep(2000);
				
				w.findElement(By.linkText("Main Item 1")).click();
				Thread.sleep(2000);
				
				Actions A5 = new Actions(w);
				A5.moveToElement(w.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"))).perform();
				w.findElement(By.linkText("Sub Item")).click();
				Thread.sleep(3000);
				
				Actions A6 = new Actions(w);
				A6.moveToElement(w.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"))).perform();

				A6.moveToElement(w.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"))).perform();
				w.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 2')]")).click();
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//a[contains(text(),'Main Item 3')]")).click();
				w.navigate().back();
				w.navigate().back();
				Thread.sleep(2000);
			
		// for Select Menu		
				jes.executeScript("window.scrollBy(0,900)");
				Thread.sleep(2000);
				w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[9]/span[1]")).click();
				System.out.println("Select Menu WebPage is open");
				Thread.sleep(2000);
				
		//select Value
				w.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div/div[1]/div[1]")).click();
				w.findElement(By.xpath("//div[contains(text(),'Group 2, option 1')]")).click();
				Thread.sleep(2000);
		//Select one
				w.findElement(By.xpath("//*[@id=\"selectOne\"]/div/div[1]")).click();
				w.findElement(By.xpath("//div[contains(text(),'Ms.')]")).click();
				Thread.sleep(2000);
		// Old Style Select Menu
				Select s3= new Select(w.findElement(By.xpath("//select[@id='oldSelectMenu']")));
				s3.selectByValue("4");
				Thread.sleep(2000);
		// multiselect Drop down
				
				jes.executeScript("window.scrollBy(0, 400)", "");
				w.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[1]")).click();
				w.findElement(By.xpath("//div[contains(text(),'Blue')]")).click();
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//div[contains(text(),'Black')]")).click();
				Thread.sleep(2000);

				w.findElement(By.xpath("//div[contains(text(),'Green')]")).click();
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/*[1]")).click();
				Thread.sleep(2000);
				
		// Standard multi select
				Select s4= new Select(w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[8]/div[1]/select[1]")));
				s4.selectByVisibleText("Volvo");
				s4.selectByValue("audi");
				Thread.sleep(2000);
			
				System.out.println(w.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div")).getText());
				w.navigate().back();
				w.navigate().back();
	
				
				
				w.get("https://demoqa.com/");
				Thread.sleep(3000);
				
//-------------------------------------------- Intraction----------------------------------------------
				
				JavascriptExecutor jss11 = (JavascriptExecutor) w;
				jss11.executeScript("window.scrollBy(0,1500)");
				
				w.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div/div[3]/h5")).click();
				Thread.sleep(3000);
				System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
				System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]")).getText());
				
				//--------------------------------sortable--------------------------------------------------------------
				
				JavascriptExecutor jss1 = (JavascriptExecutor) w;
				jss1.executeScript("window.scrollBy(0,1500)");
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//span[contains(text(),'Sortable')]")).click();
				Thread.sleep(3000);
				
				System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
				
				//list
				WebElement dr = w.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[1]"));
				WebElement dp = w.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[4]"));
				Actions A = new Actions (w);
				A.dragAndDrop(dr,dp).build().perform();
				Thread.sleep(3000);
				System.out.println("Sortable List");
				
				//grid
				w.findElement(By.linkText("Grid")).click();
				Thread.sleep(3000);
				WebElement dr1 = w.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[2]"));
				WebElement dp1 = w.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[8]"));
				Actions A10 = new Actions (w);
				A10.dragAndDrop(dr1,dp1).build().perform();
				Thread.sleep(3000);
				System.out.println("Sortable Gird");
				
				
//----------------------------------------------------selectable--------------------------------------------------------------------
				

				JavascriptExecutor jss2 = (JavascriptExecutor) w;
				jss2.executeScript("window.scrollBy(0,1500)");
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//span[contains(text(),'Selectable')]")).click();
				Thread.sleep(3000);
				System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
				
				//list
				w.findElement(By.xpath("//li[contains(text(),'Dapibus ac facilisis in')]")).click();
				w.findElement(By.xpath("//li[contains(text(),'Porta ac consectetur ac')]")).click();
				Thread.sleep(3000);
				System.out.println("Selectable List");
				
				//grid
				w.findElement(By.linkText("Grid")).click();
				w.findElement(By.xpath("//li[contains(text(),'Five')]")).click();
				w.findElement(By.xpath("//li[contains(text(),'Three')]")).click();
				w.findElement(By.xpath("//li[contains(text(),'Seven')]")).click();
				Thread.sleep(3000);
				System.out.println("Selectable Grid");
				
//---------------------------------------resizable-------------------------------------------------------------
				
				JavascriptExecutor jss3 = (JavascriptExecutor) w;
				jss3.executeScript("window.scrollBy(0,1500)");
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//span[contains(text(),'Resizable')]")).click();
				Thread.sleep(3000);
				System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
				
				WebElement re = w.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/span"));
				WebElement re1 = w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/span[1]"));
				Actions resize = new Actions(w);
				
				//provide x and y offset
				
				resize.dragAndDropBy(re, 150, 180).build().perform();
				Thread.sleep(3000);
				
				
				JavascriptExecutor jss4 = (JavascriptExecutor)w;
				jss4.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(3000);
				resize.dragAndDropBy(re1, 200, 40).build().perform();
				Thread.sleep(3000);
				
				
//-------------------------------------------------droppable-----------------------------------------------------------------
				
				JavascriptExecutor jss5 = (JavascriptExecutor) w;
				jss5.executeScript("window.scrollBy(0,1500)");
				Thread.sleep(2000);
				
				w.findElement(By.xpath("//span[contains(text(),'Droppable')]")).click();
				Thread.sleep(3000);
				System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
				
				//simple
				WebElement dr2 = w.findElement(By.id("draggable"));
				WebElement dp2 = w.findElement(By.id("droppable"));
				
				Actions A13 = new Actions(w);
				A13.dragAndDrop(dr2, dp2).build().perform();
				Thread.sleep(3000);
				System.out.println("Droppable Simple");
				
				//accept
				
				w.findElement(By.linkText("Accept")).click();
				Thread.sleep(3000);
				
				WebElement dr3 = w.findElement(By.id("acceptable"));
				WebElement dp3 = w.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
				
				Actions A14 = new Actions(w);
				A14.dragAndDrop(dr3, dp3).build().perform();
				Thread.sleep(3000);
				
				WebElement dr4 = w.findElement(By.id("notAcceptable"));
				WebElement dp4 = w.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
				
				Actions A15 = new Actions(w);
				A15.dragAndDrop(dr4, dp4).build().perform();
				Thread.sleep(3000);
				
				System.out.println("Droppable Accept");
				
				//prevent propogation
				
				w.findElement(By.linkText("Prevent Propogation")).click();
				Thread.sleep(3000);
				
				WebElement dr5 = w.findElement(By.id("dragBox"));
				WebElement dp5 = w.findElement(By.id("notGreedyInnerDropBox"));
				
				Actions A66 = new Actions(w);
				A66.dragAndDrop(dr5, dp5).build().perform();
				Thread.sleep(3000);
				
				System.out.println("Droppable prevent propogation");
				
				 //revert draggable
				
				w.findElement(By.linkText("Revert Draggable")).click();
				Thread.sleep(3000);
				
				WebElement dr6 = w.findElement(By.xpath("//div[@id='notRevertable']"));
				WebElement dp6 = w.findElement(By.xpath("//div[@id='revertableDropContainer']//div[@id='droppable']"));
				
				Actions A7 = new Actions(w);
				A7.dragAndDrop(dr6, dp6).build().perform();
				
			
				WebElement dr7 = w.findElement(By.id("revertable"));
				WebElement dp7 = w.findElement(By.xpath("//div[@id='revertableDropContainer']//div[@id='droppable']"));
				
				Actions A8= new Actions(w);
				A8.dragAndDrop(dr7, dp7).build().perform();
				Thread.sleep(3000);
				
				System.out.println("Droppable revert draggable");
				
//---------------------------------------------draggable----------------------------------
				
				JavascriptExecutor jss6 = (JavascriptExecutor) w;
				jss6.executeScript("window.scrollBy(0,1500)");
				Thread.sleep(2000);
				w.findElement(By.xpath("//span[contains(text(),'Dragabble')]")).click();
				Thread.sleep(2000);
				System.out.println(w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]")).getText());
				
				//simple
				
				WebElement dr8 = w.findElement(By.id("dragBox"));
				Actions AA8 = new Actions(w);
				AA8.dragAndDropBy(dr8, 60, 50).build().perform();
				Thread.sleep(3000);
				System.out.println("Draggable Simple");
				
				//Axis Restricted
				
				w.findElement(By.linkText("Axis Restricted")).click();
				Thread.sleep(2000);
				
				WebElement x=w.findElement(By.id("restrictedX"));
				WebElement y=w.findElement(By.id("restrictedY"));
				
				Actions A9 = new Actions(w);
				A9.dragAndDropBy(x, 80, 0).build().perform();
				Thread.sleep(2000);
				A9.dragAndDropBy(y, 0, 110).build().perform();
				
				Thread.sleep(3000);
				System.out.println("Draggable Axis restricted");
				
				//Container Restricted
				
				w.findElement(By.linkText("Container Restricted")).click();
				Thread.sleep(2000);
				
				WebElement within =w.findElement(By.xpath("//div[contains(text(),\"I'm contained within the box\")]"));
				WebElement outside =w.findElement(By.xpath("//span[contains(text(),\"I'm contained within my parent\")]"));
				
				Actions A110 = new Actions(w);
				A110.dragAndDropBy(within, 100, 40).build().perform();
				Thread.sleep(2000);
				A9.dragAndDropBy(outside, 20, 50).build().perform();
				
				Thread.sleep(3000);
				System.out.println("Draggable Container restricted");
				
				//Cursor Style
				
				w.findElement(By.linkText("Cursor Style")).click();
				Thread.sleep(2000);
				
				WebElement center =w.findElement(By.id("cursorCenter"));
				WebElement top =w.findElement(By.id("cursorTopLeft"));
				WebElement bottom =w.findElement(By.id("cursorBottom"));

				Actions A11 = new Actions(w);
				A11.dragAndDropBy(center, 290, 240).build().perform();
				Thread.sleep(2000);
				
				A11.dragAndDropBy(top,0,0).build().perform();
				Thread.sleep(2000);
				
				JavascriptExecutor jss7 = (JavascriptExecutor) w;
				jss7.executeScript("window.scrollBy(0,2000)");
				Thread.sleep(2000);
				A11.dragAndDropBy(bottom, 0, 240).build().perform();
				Thread.sleep(3000);
				System.out.println("Draggable cusor style");
	
//----------------------------------------------Book store---------------------------------------------------------
				
				
				w.navigate().to("https://demoqa.com/");
				Thread.sleep(2000);
				
				JavascriptExecutor jse11=(JavascriptExecutor) w;	
				jse11.executeScript("window.scrollBy(0,1500)");
				
				w.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[2]/*[1]")).click();
				
				System.out.println("from Book Store module");
				System.out.println("URL of page="+w.getCurrentUrl());
				
				JavascriptExecutor jse1=(JavascriptExecutor) w;	
				jse1.executeScript("window.scrollBy(0,1500)");
				
				//for book store login
				
				w.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
				
				//for new user
				
				w.findElement(By.xpath("//button[@id='newUser']")).click();
				
				//for new user registration
				
				//w.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("abdc");
				//w.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("pqrs");
				//w.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("abcdpqrs123");
				//w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abcdpqrs@123");
				
				//	w.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
				
				//	w.findElement(By.id("register")).click();
				
				JavascriptExecutor jse2=(JavascriptExecutor) w;	
				jse2.executeScript("window.scrollBy(0,1500)");
				
				w.findElement(By.xpath("//*[@id=\"gotologin\"]")).click();
				
				w.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Madhuri123");
				w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Madhuripatil@123");
				w.findElement(By.xpath("//*[@id=\"login\"]")).click();
				System.out.println("login done with valid data");
				
				
				w.navigate().to("https://demoqa.com/books");
				
				System.out.println("URL of page="+w.getCurrentUrl());
				
				
				System.out.println("from book store");
				
				w.findElement(By.linkText("Git Pocket Guide")).click();
				
				JavascriptExecutor jse3=(JavascriptExecutor) w;	
				jse3.executeScript("window.scrollBy(0,1500)");
				
				w.findElement(By.id("addNewRecordButton")).click();
				
				System.out.println("Book not added to collection");
				
				w.navigate().to("https://demoqa.com/profile");
				
				System.out.println("From profile");
				
				JavascriptExecutor jse4=(JavascriptExecutor) w;	
				jse4.executeScript("window.scrollBy(0,1600)");
				
				w.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
				
				
				w.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Abc123");
				w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Abc@123");
				w.findElement(By.xpath("//*[@id=\"login\"]")).click();
				//System.out.println(w.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[5]/div[1]/p[1]")).getText());
				System.out.println("Login failed with invalid data");
	
	}

}
