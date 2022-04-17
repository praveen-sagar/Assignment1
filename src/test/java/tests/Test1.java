package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.*;

import constants.HomeFeature;
import constants.TopMenu;
import constants.TopSubMenu;
import managers.PageObjectManager;
import pageObjects.*;

public class Test1 extends TestBase {

	static final int rnd = new Random().nextInt(50000);
	static final String USERNAME = "user@aspireapp.com";
	static final String PASSWORD = "@sp1r3app";
	static final String PRODUCT_NAME = "Test Product " + rnd;
	static final String PRODUCT_QTY = "12";

	LoginPage loginPage;
	HomePage homePage;
	ProductsListPage productsListPage;
	NewProductPage newProductPage;
	ProductPage productPage;
	UpdateQuantityPage updateQuantityPage;
	ManufacturingOrdersListPage manufacturingOrdersListPage;
	NewManufacturingOrderPage newManufacturingOrderPage;
	ManufacturingOrderPage manufacturingOrderPage;
	ConfirmPopup confirmPopup;
	PageObjectManager pageObjectManager;
	TopMenuBar topMenuBar;

	
	@Test(priority = 0)
	public void login_To_Web_Application() {
		pageObjectManager = new PageObjectManager(driver);
		loginPage = pageObjectManager.getLoginPage();
		homePage = pageObjectManager.getHomePage();
		loginPage.do_Login(USERNAME, PASSWORD);
		Assert.assertTrue(homePage.Check_Username_exists(), "Wrong Email/Password");
	}

	@Test(dependsOnMethods = { "login_To_Web_Application" })
	public void navigate_To_Inventory_Feature() {
		homePage.clickOn_Feature(HomeFeature.INVENTORY);
	}

	@Test(dependsOnMethods = { "navigate_To_Inventory_Feature" })
	public void create_New_Product() throws InterruptedException {
		productsListPage = pageObjectManager.getProductsListPage();
		newProductPage = pageObjectManager.getNewProductPage();
		productPage = pageObjectManager.getProductPage();
		topMenuBar = pageObjectManager.getTopMenuBar();
		topMenuBar.clickOn_Menu(TopMenu.Products);
		topMenuBar.clickOn_SubMenu(TopSubMenu.Products);
		productsListPage.clickOn_Create();
		newProductPage.enter_ProductName(PRODUCT_NAME);
		newProductPage.clickOn_save();
		Thread.sleep(2000);
		Assert.assertEquals(productPage.get_Title(), HomeFeature.PREFIX_TITLE + PRODUCT_NAME);
	}

	@Test(dependsOnMethods = { "create_New_Product" })
	public void update_Product_Quantity() throws InterruptedException {
		productPage.clickOn_UpdateQuantity();
		updateQuantityPage = pageObjectManager.getUpdateQuantityPage();
		updateQuantityPage.clickOn_Create();
		updateQuantityPage.enter_Quantity(PRODUCT_QTY);
		updateQuantityPage.clickOn_Save();
	}

	@Test(dependsOnMethods = { "update_Product_Quantity" })
	public void navigate_To_HomePage() {
		updateQuantityPage.clickOn_Home();
	}

	@Test(dependsOnMethods = { "navigate_To_HomePage" })
	public void navigate_To_Manufacturing_Feature() {
		homePage.clickOn_Feature(HomeFeature.MANUFACTURING);
	}

	@Test(dependsOnMethods = { "navigate_To_Manufacturing_Feature" })
	public void create_Manufacturing_Order() throws InterruptedException {
		manufacturingOrdersListPage = pageObjectManager.getManufacturingOrdersListPage();
		manufacturingOrdersListPage.clickOn_Create();
		Thread.sleep(1000);
		newManufacturingOrderPage = pageObjectManager.getNewManufacturingOrderPage();
		newManufacturingOrderPage.select_Product(PRODUCT_NAME);
		newManufacturingOrderPage.clickOn_Confirm();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = { "create_Manufacturing_Order" })
	public void mark_Manufacturing_Order_Done() throws InterruptedException {
		manufacturingOrderPage = pageObjectManager.getManufacturingOrderPage();
		confirmPopup = pageObjectManager.getConfirmPopup();
		manufacturingOrderPage.clickOn_MarkAsDone();
		confirmPopup.clickOn_OK();
		Thread.sleep(1000);
		confirmPopup.clickOn_OK();
		manufacturingOrderPage.clickOn_Save();
	}

	@Test(dependsOnMethods = { "mark_Manufacturing_Order_Done" })
	public void validate_Order() {
		Assert.assertTrue(manufacturingOrderPage.get_ProductName().contains(PRODUCT_NAME));
	}
}
