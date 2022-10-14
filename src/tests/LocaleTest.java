package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BasicTest{
	@Test(priority=10)
	public void setLocaleToES() {
		navPage.getChooseALanguageBtn().click();
		navPage.getEsLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Página de aterrizaje"),
				"ERROR: Heder should be - Página de aterrizaje");
	}
	
	@Test(priority=20)
	public void setLocaleToEN() {
		navPage.getChooseALanguageBtn().click();
		navPage.getEnLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Landing"),
				"ERROR: Heder should be - Landing");
	}
	
	@Test(priority=30)
	public void setLocaleToCN() {
		navPage.getChooseALanguageBtn().click();
		navPage.getCnLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("首页"),
				"ERROR: Heder should be - 首页");
	}
	
	@Test(priority=40)
	public void setLocaleToFR() {
		navPage.getChooseALanguageBtn().click();
		navPage.getFrLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Page d'atterrissage"),
				"ERROR: Heder should be - Page d'atterrissage");
	}
	
	

}
