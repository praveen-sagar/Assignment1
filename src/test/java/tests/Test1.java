package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.*;

import constants.HomeMenu;
import constants.NavMenu;
import constants.NavSubMenu;
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
	InventoryPage inventoryPage;
	ProductsListPage productsListPage;
	NewProductPage newProductPage;
	ProductPage productPage;
	UpdateQuantityPage updateQuantityPage;
	ManufacturingOrdersListPage manufacturingOrdersListPage;
	NewManufacturingOrderPage newManufacturingOrderPage;
	ManufacturingOrderPage manufacturingOrderPage;
	ConfirmPopup confirmPopup;
	PageObjectManager pageObjectManager;

	@Test(priority = 0)
	public void loginApp() {
		pageObjectManager = new PageObjectManager(driver);
		loginPage = pageObjectManager.getLoginPage();
		loginPage.do_Login(USERNAME, PASSWORD);
	}

	@Test(priority = 1)
	public void navigateToInventory() {
		homePage = pageObjectManager.getHomePage();
		homePage.clickOn_Menu(HomeMenu.INVENTORY);
	}

	@Test(priority = 2)
	public void createProduct() throws InterruptedException {
		inventoryPage = pageObjectManager.getInventoryPage();
		productsListPage = pageObjectManager.getProductsListPage();
		newProductPage = pageObjectManager.getNewProductPage();
		productPage = pageObjectManager.getProductPage();
		inventoryPage.clickOn_Menu(NavMenu.Products);
		inventoryPage.clickOn_SubMenu(NavSubMenu.Products);
		productsListPage.clickOn_Create();
		Thread.sleep(1000);
		newProductPage.enterProductName(PRODUCT_NAME);
		newProductPage.save();
		Thread.sleep(1000);
		Assert.assertEquals(productPage.getTitle(), HomeMenu.PREFIX_TITLE + PRODUCT_NAME);
	}

	@Test(priority = 3)
	public void updateProductQuantity() throws InterruptedException {
		productPage.clickUpdateQuantity();
		updateQuantityPage = pageObjectManager.getUpdateQuantityPage();
		Thread.sleep(2000);
		updateQuantityPage.clickOn_Create();
		updateQuantityPage.enter_Quantity(PRODUCT_QTY);
		updateQuantityPage.clickOn_Save();
	}

	@Test(priority = 4)
	public void navigateHomePage() {
		updateQuantityPage.clickOn_Home();
	}

	@Test(priority = 5)
	public void navigateToManufacturing() {
		homePage.clickOn_Menu(HomeMenu.MANUFACTURING);
	}

	@Test(priority = 6)
	public void createManufacturingOrder() throws InterruptedException {
		manufacturingOrdersListPage = pageObjectManager.getManufacturingOrdersListPage();
		manufacturingOrdersListPage.clickOn_Create();
		Thread.sleep(1000);
		newManufacturingOrderPage = pageObjectManager.getNewManufacturingOrderPage();
		newManufacturingOrderPage.select_Product(PRODUCT_NAME);
		newManufacturingOrderPage.clickOn_Confirm();
		Thread.sleep(2000);

	}

	@Test(priority = 7)
	public void markManufacturingOrderDone() throws InterruptedException {
		manufacturingOrderPage = pageObjectManager.getManufacturingOrderPage();
		confirmPopup = pageObjectManager.getConfirmPopup();
		manufacturingOrderPage.clickOn_MarkAsDone();
		Thread.sleep(1000);
		confirmPopup.clickOn_OK();
		Thread.sleep(1000);
		confirmPopup.clickOn_OK();
		Thread.sleep(1000);
		manufacturingOrderPage.clickOn_Save();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void validateOrder() throws InterruptedException {
		Assert.assertTrue(manufacturingOrderPage.get_ProductName().contains(PRODUCT_NAME));
		Thread.sleep(5000);
	}

}