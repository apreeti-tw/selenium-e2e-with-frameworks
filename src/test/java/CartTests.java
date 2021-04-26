import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.Navbar;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListingPage;
import resources.Base;

import java.io.FileInputStream;
import java.io.IOException;

public class CartTests extends Base {
    public WebDriver driver;
    private Navbar navbar;
    private ProductListingPage productListingPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private DataFormatter formatter = new DataFormatter();

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
        this.driver.get(properties.getProperty("base_url"));
        navbar = new Navbar(driver);
        productListingPage = new ProductListingPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(dataProvider = "productList")
    public void addToCartTest(String productName, String productPrice, String productSize) {
        navbar.getSearchIcon().click();
        navbar.getKeywords().sendKeys(productName);
        navbar.getKeywords().sendKeys(Keys.ENTER);

        productListingPage.getProductNames().get(0).click();
        productDetailsPage.getSizeOptions(productSize).click();
        productDetailsPage.getAddToCartButton().click();

        cartPage.getViewCart().click();

        Assert.assertTrue(cartPage.listProductByName(productName));
    }

    @DataProvider(name = "productList")
    public Object[][] getProductList() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Product Details.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++){
            row=sheet.getRow(i+1);
            System.out.println(row.getRowNum());
            for(int j=0;j<colCount;j++) {
                XSSFCell cell=row.getCell(j);
                data[i][j]=formatter.formatCellValue(cell);
            }
        }
        return data;
    }

    @AfterTest
    public void teardown(){
        this.driver.close();
    }
}
