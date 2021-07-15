package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AddEmployeePage;
import pages.AddJobTitlesPage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.GlobalVariables;

public class AddJobTitleSteps extends CommonMethods {

    @When("user navigages to the admin tab")
    public void user_navigages_to_the_admin_tab() {
        DashBoardPage dashBoardPage=new DashBoardPage();
        click(dashBoardPage.adminOption);
        click(dashBoardPage.jobDD);
    }

    @When("user clicks on job titles under the job dd")
    public void user_clicks_on_job_titles_under_the_job_dd() {
        DashBoardPage dashBoardPage=new DashBoardPage();
        click(dashBoardPage.jobTitleSection);
        //jsClick(dashBoardPage.jobTitleSection);
    }

    @When("user clicks on ‘add’ button")
    public void user_clicks_on_add_button() {
        AddJobTitlesPage jobTitlePage=new AddJobTitlesPage();
        click(jobTitlePage.addbtn);
    }

    @When("user enters job title {string} within textbox")
    public void user_enters_job_title_within_textbox(String jobTitle) {
        GlobalVariables.expectedJobTitle=jobTitle;
        AddJobTitlesPage jobTitlePage=new AddJobTitlesPage();
        sendText(jobTitlePage.jobTitleTxtbox,GlobalVariables.expectedJobTitle);
    }

    @When("user enters job description {string} within textbox")
    public void user_enters_job_description_within_textbox(String jobDescription) {
        GlobalVariables.expectedJobDescription=jobDescription;
        AddJobTitlesPage jobTitlePage=new AddJobTitlesPage();
        sendText(jobTitlePage.jobTitleJobDescriptionTxtBox,GlobalVariables.expectedJobDescription);
    }

    @When("user enters note {string} within textbox")
    public void user_enters_notewithin_textbox(String note) {
        GlobalVariables.expectedNote=note;
        AddJobTitlesPage jobTitlePage=new AddJobTitlesPage();
        sendText(jobTitlePage.noteTextbox,GlobalVariables.expectedNote);
    }

    @When("user clicks ’Save’ button")
    public void user_clicks_save_button() {
        AddJobTitlesPage jobTitlePage=new AddJobTitlesPage();
        click(jobTitlePage.saveBtn);
    }

    @Then("job title specified will display on front and backend")
    public void job_title_specified_will_display_on_front_and_backend() {
        System.out.println("DBjobTitle "+GlobalVariables.jobTitle);
        System.out.println("DBjobDescription "+GlobalVariables.jobDescription);
        System.out.println("DBnote "+GlobalVariables.note);
        System.out.println("Front End");
        System.out.println("Expected jobTitle "+GlobalVariables.expectedJobTitle);
        System.out.println("Expected jobDescription "+GlobalVariables.expectedJobDescription);
        System.out.println("Expected note "+GlobalVariables.expectedNote);
        Assert.assertEquals(GlobalVariables.expectedJobTitle,GlobalVariables.jobTitle);
        Assert.assertEquals(GlobalVariables.expectedJobDescription,GlobalVariables.jobDescription);
        Assert.assertEquals(GlobalVariables.expectedNote,GlobalVariables.note);


    }

}
