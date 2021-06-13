package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user navigates to hrms")
    public void user_navigates_to_hrms() {
        setUp();
    }

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernamebox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordbox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.pimOption);
        click(dash.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage empList=new EmployeeListPage();
        sendText(empList.idEmployee,"15518");

    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage empList=new EmployeeListPage();
        sendText(empList.employeenamefield,"Sofiia Sof Hrustai");
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage empList=new EmployeeListPage();
        jsClick(empList.searchBtn);
        //click(empList.searchBtn);
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Employee is displayed");
        teardown();
    }
}
