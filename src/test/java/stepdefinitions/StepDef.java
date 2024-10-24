package stepdefinitions;

import PageObject.TestBase;
import PageObject.resource_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends TestBase {
	
	private resource_page resource;

	@Given("I navigate to the URL")
	public void i_navigate_to_the_url() {
		initialization();
	}

	@When("I click on the Table Data button")
	public void i_click_on_the_table_data_button() throws InterruptedException {
		resource=new resource_page();
		resource.tabledatabtn_click();
		
	}
	
	@Then("A new input text box is displayed")
	public void a_new_input_text_box_is_displayed() {
	   resource.inputbox();
	}
	
	@When("I insert the data into the input text box")
	public void i_insert_the_data_into_the_input_text_box() throws InterruptedException {
		
		resource.insertdata();
	    
	}

	@When("I click the Refresh Table button")
	public void i_click_the_refresh_table_button() throws InterruptedException {
		resource.refreshclick();
	    
	}
	
	@When("the inserted data should match the displayed data in the table")
	public void the_inserted_data_should_match_the_displayed_data_in_the_table() {
	    resource.fetchdata();
	    tearDown();
	}


}
