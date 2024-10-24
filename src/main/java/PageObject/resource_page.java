package PageObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utils.inputdata;

public class resource_page extends TestBase
{
	
	@FindBy(xpath="//summary[text()=\"Table Data\"]")
	WebElement tabledata_btn;
	
	@FindBy(css="textarea[id=\"jsondata\"]")
	WebElement input_box;
	
	@FindBy(css="button[id=\"refreshtable\"]")
	WebElement refresh_btn;
	
	@FindBy(xpath="//table[@id='dynamictable'] //tr")
	List<WebElement> rows;

	
	//////////////////////////////Method///////////////////////
	public resource_page()
	{
		PageFactory.initElements(driver, this);
	}
	public void tabledatabtn_click() throws InterruptedException
	{
		//for showing functionality
		Thread.sleep(2000);
		tabledata_btn.click();
	}
	
	public void inputbox()
	{
		input_box.isDisplayed();
	}
	
	public void insertdata() throws InterruptedException
	{
		//for showing functionality
		Thread.sleep(2000);
		input_box.clear();
		//for showing functionality
		Thread.sleep(2000);
		input_box.sendKeys(inputdata.tabledata());
	}
	
	public void refreshclick() throws InterruptedException
	{
		//for showing functionality
		Thread.sleep(2000);
		refresh_btn.click();
	}
	
	public void fetchdata()
	{
		for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
//            System.out.println(cells.size());

            String name = cells.get(0).getText();
            String age = cells.get(1).getText();
            String gender = cells.get(2).getText();

            Map<String, String> actualPerson = createPerson(name,age, gender);
//            System.out.println(actualPerson);   
            Map<String, Object> expected = inputdata.expecteddata().get(i-1).toMap();
//            System.out.println(expected);
            Assert.assertEquals(expected, actualPerson);
            
           
           
     }
	}
	private Map<String, String> createPerson(String name, String age, String gender) 
	{
        Map<String, String> person = new HashMap<>();
        person.put("name", name);
        person.put("age", age);
        person.put("gender", gender);
        return person;
        
     }
	
	}
