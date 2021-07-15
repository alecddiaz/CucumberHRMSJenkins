package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class AddJobTitlesPage extends CommonMethods {

    @FindBy(id="btnAdd")
    public WebElement addbtn;

    @FindBy(id="jobTitle_jobTitle")
    public WebElement jobTitleTxtbox;

    @FindBy(id="jobTitle_jobDescription")
    public WebElement jobTitleJobDescriptionTxtBox;

    @FindBy(id="jobTitle_jobSpec")
    public WebElement jobSpecificationFileDrop;

    @FindBy(id="jobTitle_note")
    public WebElement noteTextbox;

    @FindBy(id="btnSave")
    public  WebElement saveBtn;

    @FindBy(xpath = "//table[@id=\'resultTable\']/tbody/tr/td[2]")
    public List<WebElement> listJobTitleTable;


    public AddJobTitlesPage(){
        PageFactory.initElements(driver,this);
    }

}
