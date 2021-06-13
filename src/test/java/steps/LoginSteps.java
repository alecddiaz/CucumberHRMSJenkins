package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernamebox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordbox, ConfigReader.getPropertyValue("password"));

    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        LoginPage loginPage=new LoginPage();
        click(loginPage.loginBtn);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashBoardPage dash =new DashBoardPage();
        Assert.assertTrue(dash.welcomemessage.isDisplayed());
    }

    @When("user enter valid ess username and password")
    public void user_enter_valid_ess_username_and_password() {
        //johnny1234560000     Syntax1253!!!!
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernamebox,"johnny1234560000");
        sendText(loginPage.passwordbox,"Syntax1253!!!!");

    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashBoardPage dash=new DashBoardPage();
        //Assert.assertTrue(dash.welcomemessage.isDisplayed());
        String expected="Welcome Admin";
        String actual=dash.welcomemessage.getText();

        Assert.assertEquals("values do not match", expected, actual);
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernamebox,"Admin");
        sendText(loginPage.passwordbox,"Syntax1253!!!!");

    }

    @Then("user see invalid credentials text on login page")
    public void user_see_invalid_credentials_text_on_login_page() {
        System.out.println("Error message is displayed");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernamebox,username);
        sendText(loginPage.passwordbox,password);
    }

    @When("{string} is successfully logged in")
    public void is_successfully_logged_in(String firstname) {
        System.out.println("Working fine");
    }

}
