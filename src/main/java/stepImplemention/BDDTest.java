package stepImplemention;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Demo.Pippin.BaseAction;
import Demo.Pippin.PagesObject;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDDTest extends BaseAction {
	PagesObject pg= new PagesObject(driver);
	WebDriverWait wait=new WebDriverWait(driver, 10);
	Actions act=new Actions(driver);
	@Given ("^user is on pippintitle login page and login with given (.*) and (.*)$")
	public void user_Login_Page(String username, String password) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.pippintitle.com/");
		driver.findElement((By)pg.Email).sendKeys(username);
		driver.findElement((By)pg.password).sendKeys(password);
		driver.findElement((By)pg.login).click();
	}
	
	@When ("^select the product and enter  details (.*) and (.*) and (.*)$")
	public void select_product_and_user_details(String Firstname,String Address,String Clientreference) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) pg.Place_order));
		act.click(pg.Place_order).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) pg.Property_First_Name));
		act.moveToElement(pg.Property_First_Name).sendKeys(Firstname).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.moveToElement(pg.search_box).sendKeys(Address).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) pg.search_box_Adress));
		act.moveToElement(pg.search_box_Adress).perform();
		act.moveToElement(pg.Property_Order_Number).sendKeys(Clientreference).perform();
	}
	
	@And ("^then upload (.*) pfd$")
	public void upload_pdf(String DocFilePath){
		act.moveToElement(pg.Upload_Documents).click();
		upload(DocFilePath);
		upload(DocFilePath);
		upload(DocFilePath);
	}
	public void upload(String DocFilePath) {
		File f1= new File(DocFilePath);
		pg.Upload_Documents.sendKeys(f1.getAbsolutePath());
	}
	@And ("^Delete 2 pdf from list$")
	public void delete_pdf() throws InterruptedException {
		Thread.sleep(1000);
		Delete();
		Delete();
	}
	public void Delete() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) pg.delete_Document));
		driver.findElement((By)pg.delete_Document).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) pg.Confirm));
		driver.findElement((By)pg.Confirm).click();
	}
	@And ("^create the order$")
	public void create_order() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) pg.Continue));
		driver.findElement((By)pg.Continue).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) pg.accept_terms));
		driver.findElement((By)pg.accept_terms).click();
		driver.findElement((By)pg.Submit).click();
	}
	@Then ("^Read the order number and sent (.*) and logout$")
	public void Order_number_sentand_logout(String Msg) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement((By)pg.message).click();
		driver.findElement((By)pg.msg_area).sendKeys(Msg);
		driver.findElement((By)pg.msg_send).click();
		logout();
	}
	public void logout() {
		driver.findElement((By)pg.drop_down).click();
		driver.findElement((By)pg.logout).click();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
