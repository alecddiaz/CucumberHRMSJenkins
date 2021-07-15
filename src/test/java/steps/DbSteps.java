package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.DbUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DbSteps extends CommonMethods {
    @Then("query the hrms database")
    public void query_the_hrms_database() {
        String query="select emp_firstname,emp_middle_name,emp_lastname" +
                " from hs_hr_employees where emp_number="+ GlobalVariables.empId;

        List<Map<String,String>> tableDataAsList=DbUtils.getTableDataAsList(query);
        GlobalVariables.dbFirstName=tableDataAsList.get(0).get("emp_firstname");
        GlobalVariables.dbMiddleName=tableDataAsList.get(0).get("emp_middle_name");
        GlobalVariables.dbLastName=tableDataAsList.get(0).get("emp_lastname");
    }

    @When("query hrms database for jobtitle")
    public void query_hrms_database_for_jobtitle() {
        String query="select job_title,job_description,note " +
                "from ohrm_job_title where job_title='"+GlobalVariables.expectedJobTitle+"'";
        List<Map<String,String>> tableDataAsList=DbUtils.getTableDataAsList(query);
        System.out.println(tableDataAsList);
        GlobalVariables.jobTitle=tableDataAsList.get(0).get("job_title");
        GlobalVariables.jobDescription=tableDataAsList.get(0).get("job_description");
        GlobalVariables.note=tableDataAsList.get(0).get("note");
    }
}
