package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.*;

public class PageObjectManager {

	private ConfirmPopup confirmPopup;
	private HomePage homePage;
	private InventoryPage inventoryPage;
	private LoginPage loginPage;
	private ManufacturingOrderPage manufacturingOrderPage;
	private ManufacturingOrdersListPage manufacturingOrdersListPage;
	private NewManufacturingOrderPage newManufacturingOrderPage;
	private NewProductPage newProductPage;
	private ProductPage productPage;
	private ProductsListPage productsListPage;
	private TopMenuBar topMenuBar;
	private UpdateQuantityPage updateQuantityPage;
	private WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public ConfirmPopup getConfirmPopup() {
		return (confirmPopup == null) ? confirmPopup = new ConfirmPopup(driver) : confirmPopup;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public InventoryPage getInventoryPage() {
		return (inventoryPage == null) ? inventoryPage = new InventoryPage(driver) : inventoryPage;
	}
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	public ManufacturingOrderPage getManufacturingOrderPage() {
		return (manufacturingOrderPage == null) ? manufacturingOrderPage = new ManufacturingOrderPage(driver) : manufacturingOrderPage;
	}
	
	public ManufacturingOrdersListPage getManufacturingOrdersListPage() {
		return (manufacturingOrdersListPage == null) ? manufacturingOrdersListPage = new ManufacturingOrdersListPage(driver) : manufacturingOrdersListPage;
	}
	
	public NewManufacturingOrderPage getNewManufacturingOrderPage() {
		return (newManufacturingOrderPage == null) ? newManufacturingOrderPage = new NewManufacturingOrderPage(driver) : newManufacturingOrderPage;
	}
	
	public NewProductPage getNewProductPage() {
		return (newProductPage == null) ? newProductPage = new NewProductPage(driver) : newProductPage;
	}
	
	public ProductPage getProductPage() {
		return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
	}
	
	public ProductsListPage getProductsListPage() {
		return (productsListPage == null) ? productsListPage = new ProductsListPage(driver) : productsListPage;
	}
	
	public TopMenuBar getTopMenuBar() {
		return (topMenuBar == null) ? topMenuBar = new TopMenuBar(driver) : topMenuBar;
	}

	public UpdateQuantityPage getUpdateQuantityPage() {
		return (updateQuantityPage == null) ? updateQuantityPage = new UpdateQuantityPage(driver) : updateQuantityPage;
	}
}
