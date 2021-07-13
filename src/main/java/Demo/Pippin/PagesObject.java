package Demo.Pippin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagesObject extends BasePage{

	public PagesObject(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="Email_Address")
	public WebElement Email;
	
	@FindBy(id="User_Password")
	public WebElement password;
	
	@FindBy(id="loginBtnLogin")
	public WebElement login;
	
	@FindBy(xpath="//strong[contains(text(),'Place Order')]")
	public WebElement Place_order;
	
	@FindBy(id="Property_First_Name")
	public WebElement Property_First_Name;
	
	@FindBy(id="search-box")
	public WebElement search_box;
	
	@FindBy(xpath="//div[@class='pac-container pac-logo']//div[2]")
	public WebElement search_box_Adress;

	@FindBy(id="Property_Order_Number")
	public WebElement Property_Order_Number;

	@FindBy(xpath="//button[contains(text(),'Upload Documents')]")
	public WebElement Upload_Documents;

	@FindBy(xpath="//label[contains(text(),'Documents')]/following::div[2]//button//span")
	public WebElement delete_Document;
	
	@FindBy(id="conOk")
	public WebElement Confirm;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	public WebElement Continue;

	@FindBy(id="mat-checkbox-2-input")
	public WebElement accept_terms;

	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement Submit;
	
	@FindBy(id="ordDetBtnSendMsg")
	public WebElement message;
	
	@FindBy(id="msg-area")
	public WebElement msg_area;

	@FindBy(id="msgSend")
	public WebElement msg_send;
	
	@FindBy(xpath="//i[contains(text(),'arrow_drop_down')]")
	public WebElement drop_down;
	
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	public WebElement logout;

}
