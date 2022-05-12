import data_reader.CsvFileManager;
import io.netty.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.calculator.CalculatorPage;
import pages.calculator.CalculatorPageObjects;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestRetirementSavings {
    private WebDriver driver;
    private CalculatorPage calculatorPage;
    WebDriverWait wait;

    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching Firefox browser");
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        calculatorPage = new CalculatorPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.securian.com/insights-tools/retirement-calculator.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider(name = "data-provider")
    public Object[][] getData() throws FileNotFoundException {
        List<List<String>> testData = CsvFileManager.getData();
        assert testData != null;
        Object[][] data = new Object[testData.size()][testData.get(0).size()];

        for( int i = 0; i<testData.size(); i++){
            for(int j = 0; j<testData.get(i).size(); j++){
                data[i][j] = testData.get(i).get(j);
            }
        }
        return data;
    }

    @Test (dataProvider = "data-provider")
    public  void testSubmit(String[] val) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.fillForm(val);
        calculatorPage.clickFormButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorPageObjects.successMessage));
        WebElement element = driver.findElement(CalculatorPageObjects.successMessage);
        Assert.assertTrue(element.isDisplayed());

        driver.navigate().to("https://www.securian.com/insights-tools/retirement-calculator.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test (dataProvider = "data-provider")
    public void testEdit(String[] val){
        calculatorPage.fillForm(val);
        calculatorPage.clickFormButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorPageObjects.editInfo));
        calculatorPage.clickEditInfoButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorPageObjects.calculate));
        WebElement element = driver.findElement(CalculatorPageObjects.calculate);
        Assert.assertTrue(element.isDisplayed());
    }

    @AfterTest
    public void terminateBrowser()  {
        driver.quit();
    }
}
