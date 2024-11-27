package com.wakesmart.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.wakesmart.base.BaseClass;

public class Action extends BaseClass {

	public Properties prop;
	
	public void getSelectOptionFromDropdown(List<WebElement> ele , String AttributrValue) throws InterruptedException {
		
		try {
			for (WebElement element :ele) {

				if (element.getText().equalsIgnoreCase(AttributrValue)) {
					element.click();
					break;
				}
			}
			Thread.sleep(500);
		} catch (StaleElementReferenceException  e) {
			
			for (WebElement element : ele) {
				
				if (element.getText().equalsIgnoreCase(AttributrValue)) {
					element.click();
					break;
				}
			}
			
		}
	}

	public List<String> verifyDropdown(List<WebElement> dropdown) {
		
		List<String> lstString = new ArrayList<>();

		for (WebElement ele : dropdown) {
			lstString.add(ele.getText());
		}
		return lstString;
	}

	public List<String> verifyDropdownList() {

		List<String> lstString = new ArrayList<>();
		
		lstString.add("No");
		lstString.add("CSV");
		lstString.add("PDF");
		
		return lstString;
	}

	public static String removeFirstLetter(String str) {

		StringBuilder sb = new StringBuilder(str);

		sb.deleteCharAt(0);
		return sb.toString();
	}

	public void dropdown(WebElement ele, String str) {

		Select sel = new Select(ele);

		List<WebElement> lst = sel.getOptions();

		for (WebElement option : lst) {
			if (option.getText().equals(str)) {
				option.click();
				break;
			}
		}
	}

	public String nameVerifyFromTable(List<WebElement> ele, String str) throws InterruptedException {

		String tablename = "";
		for (WebElement option : ele) {
//			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase(str)) {
				tablename = option.getText();
				System.out.println("Plociy table name "+tablename);
				break;
			}
		}
		return tablename;
	}
	
	public void ClickOnGroup(List<WebElement> ele, String str) {

		for (WebElement option : ele) {

			if (option.getText().equalsIgnoreCase(str)) {
				option.click();
				break;
			}
		}
	}
	public void ClickOnEditGroup(List<WebElement> ele, String str,WebElement editElement) {

		for (WebElement option : ele) {

			if (option.getText().equalsIgnoreCase(str)) {
				editElement.click();
				break;
			}
		}
	}
	
	public void nameVerifyFromTableAndClick(List<WebElement> ele, String str) {

		for (WebElement option : ele) {

			if (option.getText().equalsIgnoreCase(str)) {
				option.click();
				break;
			}
		}
	}

	public String dateFormat(String MDY) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("MMM dd, yyyy");

		Date date = format1.parse(MDY);
		return format2.format(date);
	}

	public String currentDate() throws ParseException {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		String str = formatter.format(date);
		return str;
	}

	public String currentDateMinusone() throws ParseException {

		Date currentDate = new Date();
		Date oneDayFromCurrentDate = new Date(currentDate.getTime() - Duration.ofDays(1).toMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		String str = formatter.format(oneDayFromCurrentDate);
		return str;
	}

	public String currentDateMinusSeven(int Days) throws ParseException {

		Date currentDate = new Date();
		Date oneDayFromCurrentDate = new Date(currentDate.getTime() - Duration.ofDays(Days).toMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		String str = formatter.format(oneDayFromCurrentDate);
		return str;
	}
	
	public String currentDatePlusSeven(int Days) throws ParseException {

		Date currentDate = new Date();
		Date oneDayFromCurrentDate = new Date(currentDate.getTime() + Duration.ofDays(Days).toMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		String str = formatter.format(oneDayFromCurrentDate);
		return str;
	}

	public String colorVerify(WebElement ele, String value) {

		String color = ele.getCssValue(value);

		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

	public void dateSelector(WebElement YearList, List<WebElement> monthList, String year, String month) {
		Select s = new Select(YearList);
		s.selectByVisibleText(year);

		List<WebElement> monthlist = monthList;
		Select selectmonth = new Select((WebElement) monthlist);
		selectmonth.selectByVisibleText(month);
	}

	public void getWindowHandles(WebDriver driver) {

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
	}

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	public static void scrollToTop(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0);");
            System.out.println("Scrolled to the top of the page.");
        } catch (Exception e) {
            System.out.println("Exception occurred while scrolling to the top: " + e.getMessage());
        }
    }

	public void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	public void keyBoardKeys(WebDriver driver, Keys KeysToSend) {
		Actions act = new Actions(driver);
		act.sendKeys(KeysToSend).perform();
	}

	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		}

		return flag;
	}

	public void leftKeyType(WebDriver driver, WebElement ele, String text) throws InterruptedException {
		ele.click();
		Actions act = new Actions(driver);
		for (int i = 0; i < 11; i++) {
			act.keyDown(Keys.LEFT);
		}
		// act.keyUp(Keys.UP);
		ele.sendKeys(text);
	}

	public void type(WebElement ele, String text) {
			
		ele.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

			ele.sendKeys(text);
	
	}
	public void typeAndHitEnter(WebElement ele, String text) {
        try {
        	ele.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            ele.sendKeys(text);
            Thread.sleep(4000);
            ele.sendKeys(Keys.ENTER);
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	public boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("The element is Selected");
			} else {
				System.out.println("The element is not Selected");
			}
		}
		return flag;
	}

	public boolean isEnabled(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return flag;
	}

	public boolean selectBySendkeys(String value, WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");
			} else {
				System.out.println("Not Selected value from the DropDown");
			}
		}
	}

	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
			}
		}
	}

	public boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	public boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}

	public boolean JSClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			
			executor.executeScript("arguments[0].click();", ele);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	public boolean switchToFrameById(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

	public void mouseHoverElement(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}

	}

	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);

			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean mouseHover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {

			return false;

		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \"" + source + "\"");
			} else if (!flag) {
				System.out.println("Draggable action is not performed on \"" + source + "\"");
			}
		}
	}

	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if (!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}

	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}

	public boolean rightclick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}

	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count - 1]);

			if (driver.getTitle().contains(windowTitle)) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			// flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}

	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s = driver.getWindowHandles();
			Object popup[] = s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s = driver.getWindowHandles();
			Object popup[] = s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Focus navigated to the window with title");
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}

	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}

	public boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");
			} else {
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}

	public boolean launchUrl(WebDriver driver, String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \"" + url + "\"");
			} else {
				System.out.println("Failed to launch \"" + url + "\"");
			}
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public String getCurrentURL(WebDriver driver) {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \"" + text + "\"");
		}
		return text;
	}

	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \"" + text + "\"");
		}
		return text;
	}

	public boolean click1(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \"" + locatorName + "\"");
			} else {
				System.out.println("Click Unable to click on \"" + locatorName + "\"");
			}
		}
	}

	public void fluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(element));
			e.printStackTrace();
		}

	}
	public void fluentWait1(WebDriver driver, List<WebElement> element) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(element));

		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			e.printStackTrace();
		}

	}
	
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));

	}

	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void explicitWaitForInvisibility(WebDriver driver, WebElement element, int timeOut) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}


	public  void moveToElementClickClearAndSendValue(WebDriver driver, WebElement element, String value) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = '';", element);
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, value);
    }
	public String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}

	 public void selectDateFromCalendar(WebDriver driver, WebElement monthYearElement, WebElement nextButton, String desiredDay, String desiredMonth, String desiredYear) throws InterruptedException  {
	        String currentMonthYearValue = monthYearElement.getText();
	        String[] currentMonthYear = getMonthYear(currentMonthYearValue);
	        List<String> days = new ArrayList<String>();

	        while (!(currentMonthYear[0].equalsIgnoreCase(desiredMonth) && currentMonthYear[1].equalsIgnoreCase(desiredYear))) {
	            nextButton.click();
	            currentMonthYearValue = monthYearElement.getText();
	            currentMonthYear = getMonthYear(currentMonthYearValue);
	        }
	        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(monthYearElement));
	        List<WebElement> daysElements = driver.findElements(By.xpath("//div[@class='PrivatePickersSlideTransition-root MuiDayPicker-slideTransition css-1cnkspq']/div/div/button"));
//	        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(dayElements));
	        System.out.println(daysElements.size());    
	        for(WebElement day:daysElements) {
	        	days.add(day.getText());
	        	if(days.contains(desiredDay)) {
	        		day.click();
	        		break;
	        	}
	        }
	 }
	 public void NavigationHelperBack(WebDriver driver) {
		 driver.navigate().back();
	 }
	 public void navigateForward(WebDriver driver) {
	        driver.navigate().forward();
	    }
	 public void refreshPage(WebDriver driver) {
	        driver.navigate().refresh();
	    }
	 public String getElementvalueusingJS(WebDriver driver,WebElement element) {
		 // Use JavaScript to get the text of the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].innerText;", element);
    }
	 public String getElementValue(WebDriver driver,WebElement element) {
		return element.getText();
		 
	 }
		public  void scrollToLeft(WebDriver driver,String aurgment) {
	        // Create a JavaScriptExecutor object
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Execute JavaScript to scroll to the bottom of the table
	        js.executeScript(aurgment);
	        
	        // Sleep for a short duration to allow the scroll to take effect
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
		public void scrollToAndClickProject(WebDriver driver, String projectName, By listLocator) throws InterruptedException {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    WebElement list = driver.findElement(listLocator);

		    while (true) {
		        // Scroll down by a fixed amount (adjust as needed)
		        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", list);

		        // Check if the desired project is now visible within the viewport
		        WebElement project = driver.findElement(By.xpath("//*[text()= '" + projectName + "']"));

		        if (project.isDisplayed()) {
		            // Move to and click the project (optional for better visibility)
		            Actions action = new Actions(driver); // Use 'this' to reference the current object
		            action.moveToElement(project).click().perform();
		            break;
		        }

		        // Optional: Add a check for reaching the end of the scrollable area
		        if (!project.isDisplayed()) {
		            System.out.println("Project not found in the list.");
		            break;
		        }

		        // Add a wait to avoid excessive scrolling (adjust as needed)
		        Thread.sleep(1000); // Adjust the wait time based on your application's speed
		    }
		}
		public void refresPage(WebDriver driver){
			try {
				driver.navigate().refresh(); // Refresh the page
				System.out.println("Page refreshed successfully.");
			} catch (Exception e) {
				System.out.println("An error occurred while refreshing the page: " + e.getMessage());
			}
		}

}
