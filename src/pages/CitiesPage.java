package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getNewItemBtn () {
		return driver.findElement(By.className("btnNewItem"));
	}
	
	public WebElement getSearchInput () {
		return driver.findElement(By.id("search"));
	}
	
	public void waitForNewEditDialog () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
	}
	
	public void waitForDeleteDialog () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Do you really want to delete this item?']/../..")));
	}
	
	public WebElement getSaveNewDialogBtn () {
		return driver.findElement(By.className("btnSave"));
	}
	
	public WebElement getDeleteDeleteDialogBtn () {
		return driver.findElement(By.xpath("//*[text()=' Delete ']/.."));
	}
	
	public void waitForNumbersOfCitiesToBe ( int rows) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[contains(@class, 'v-data-table__wrapper')]//tbody/tr"), rows));
	}
	
	public WebElement getCellFromRow(int row, int col) {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-data-table__wrapper')]//tbody/tr["+row+"]/td["+col+"]"));
	}
	
	public WebElement getEditBtnFromRow(int row) {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-data-table__wrapper')]//tbody/tr["+row+"]//*[@id='edit']"));
	}
	
	public WebElement getDeleteBtnFromRow(int row) {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-data-table__wrapper')]//tbody/tr["+row+"]//*[@id='delete']"));
	}
	
	public WebElement getInputFromNewItemDialog() {
		return driver.findElement(By.name("name"));
	}
	
	

}
