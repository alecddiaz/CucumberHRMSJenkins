package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashBoardPage extends CommonMethods {

    @FindBy(id ="welcome")
    public WebElement welcomemessage;

    @FindBy(id ="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id ="menu_pim_addEmployee")
    public WebElement addEmployeeBtn;

    @FindBy(id ="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(id ="menu_admin_viewAdminModule")
    public WebElement adminOption;

    @FindBy(id="menu_admin_Job")
    public WebElement jobDD;

    @FindBy(id="menu_admin_viewJobTitleList")
    public WebElement jobTitleSection;

    @FindBy(xpath="//div[@class='menu']/ul/li")
    public List<WebElement> dashboardtabs;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
