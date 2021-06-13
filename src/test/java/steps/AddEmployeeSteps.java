package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.pimOption);
    }

    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.addEmployeeBtn);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add=new AddEmployeePage();
        sendText(add.firstName,"Nelson1235");
        sendText(add.middleName,"Ms3");
        sendText(add.lastName,"M321");
    }


    @When("user enters first name {string} middle name {string} and last name {string}")
    public void user_enters_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
        AddEmployeePage add=new AddEmployeePage();
        sendText(add.firstName,firstName);
        sendText(add.middleName,middleName);
        sendText(add.lastName,lastName);
    }

    @When("user enters {string} {string} and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage add=new AddEmployeePage();
        sendText(add.firstName,FirstName);
        sendText(add.middleName,MiddleName);
        sendText(add.lastName,LastName);
    }

    @When("user clicks on save button option")
    public void user_clicks_on_save_button_option() {
        AddEmployeePage add=new AddEmployeePage();
        click(add.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added Successfully");
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String,String>> employeeNames = employees.asMaps();
        for(Map<String, String> employeename : employeeNames){
            String firstnamevalue= employeename.get("FirstName");
            String middlenamevalue= employeename.get("MiddleNameName");
            String lastnamevalue= employeename.get("LastName");
            System.out.println(firstnamevalue+" "+middlenamevalue+" "+lastnamevalue);

            AddEmployeePage addEmployeePage=new AddEmployeePage();
            sendText(addEmployeePage.firstName, firstnamevalue);
            sendText(addEmployeePage.middleName, middlenamevalue);
            sendText(addEmployeePage.lastName, lastnamevalue);
            click(addEmployeePage.saveBtn);

            //assertion do for hw
            Thread.sleep(4000);
            DashBoardPage dash=new DashBoardPage();
            click(dash.addEmployeeBtn);
            Thread.sleep(3000);


        }
    }

}
