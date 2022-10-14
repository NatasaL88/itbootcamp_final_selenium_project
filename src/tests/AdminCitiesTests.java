package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
	
	@Test(priority=10)
	public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginBtn().click();
		
		navPage.getAdminBtn().click();
		navPage.getAdminCitiesLink().click();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/admin/cities"),
				"ERROR: Url should ends with /admin/cities");
	}
	
	@Test(priority=20)
	public void checksInputTypesForCreateEditNewCity() {
		navPage.getAdminBtn().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		
		citiesPage.waitForNewEditDialog();
		
		Assert.assertTrue(
				citiesPage.getInputFromNewItemDialog().getAttribute("type").equals("text"),
				"ERROR: Input type should be text");
	}
	
	@Test(priority=30)
	public void createNewCity() {
		
		navPage.getAdminBtn().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		
		citiesPage.waitForNewEditDialog();
		
		citiesPage.getInputFromNewItemDialog().sendKeys("Natasa City");
		citiesPage.getSaveNewDialogBtn().click();
		
		messagePopUpPage.waitForSavedSuccessfulyMsg();;
		
		Assert.assertTrue(
				messagePopUpPage.getSavedSuccessfulMsg().getText().contains("Saved successfully"),
				"ERROR: Wrong message.");
	}
	

	@Test(priority=40)
	public void editCity() throws InterruptedException {
		navPage.getAdminBtn().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Natasa City");
		
		citiesPage.waitForNumbersOfCitiesToBe(1);
		citiesPage.getEditBtnFromRow(1).click();
		citiesPage.getInputFromNewItemDialog().sendKeys(" Edited");
		citiesPage.getSaveNewDialogBtn().click();
		messagePopUpPage.waitForSuccessfullSavedMsg();
		
		Assert.assertTrue(
				messagePopUpPage.getSavedSuccessfulMsg().getText().contains("Saved successfully"),
				"ERROR: Wrong message.");
		
	}
	
	@Test(priority=50)
	public void searchCity() {
		navPage.getAdminBtn().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Natasa City");
		
		citiesPage.waitForNumbersOfCitiesToBe(1);
		Assert.assertTrue(
				 citiesPage.getCellFromRow(1, 2).getText().contains("Natasa City"),
				 "ERROR: City name should contains - Natasa City");
	}
	
	@Test(priority=60)
	public void deleteCity() {
		navPage.getAdminBtn().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Natasa City");
		
		citiesPage.waitForNumbersOfCitiesToBe(1);
		
		Assert.assertTrue(
				 citiesPage.getCellFromRow(1, 2).getText().contains("Natasa City"),
				 "ERROR: City name should contains - Natasa City");
		
		citiesPage.getDeleteBtnFromRow(1).click();
		citiesPage.waitForDeleteDialog();
		citiesPage.getDeleteDeleteDialogBtn().click();
		
		messagePopUpPage.waitForSuccessfullSavedMsg();
		
		Assert.assertTrue(
				messagePopUpPage.getSavedSuccessfulMsg().getText().contains("Deleted successfully"),
				"ERROR: Wrong message.");
	}
}