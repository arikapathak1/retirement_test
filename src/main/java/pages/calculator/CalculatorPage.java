package pages.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CalculatorPage{
    private static WebDriver driver = null;

    public CalculatorPage(WebDriver driver) {
        if (CalculatorPage.driver == null){
            CalculatorPage.driver = driver;
        }
    }

    public  void clickFormButton(){
        driver.findElement(CalculatorPageObjects.calculate).click();
    }
    public  void fillForm(String[] data){
        if(data.length != 10){
            throw new IllegalArgumentException(
                    "The data is incomplete"
            );
        }
        WebElement currentAge = driver.findElement(CalculatorPageObjects.currentAge);
        currentAge.clear();
        currentAge.sendKeys(data[0]);

        WebElement retirementAge = driver.findElement(CalculatorPageObjects.retirementAge);
        retirementAge.clear();
        retirementAge.sendKeys(data[1]);

        WebElement currentIncome = driver.findElement(CalculatorPageObjects.currentIncome);
        currentIncome.clear();
        currentIncome.sendKeys(data[2]);

        WebElement spouseIncome = driver.findElement(CalculatorPageObjects.spouseIncome);
        spouseIncome.clear();
        spouseIncome.sendKeys(data[3]);

        WebElement currentTotalSavings = driver.findElement(CalculatorPageObjects.currentTotalSavings);
        currentTotalSavings.clear();
        currentTotalSavings.sendKeys(data[4]);

        WebElement currentAnnualSavings = driver.findElement(CalculatorPageObjects.currentAnnualSavings);
        currentAnnualSavings.clear();
        currentAnnualSavings.sendKeys(data[5]);

        WebElement savingsIncreaseRate = driver.findElement(CalculatorPageObjects.savingsIncreaseRate);
        savingsIncreaseRate.clear();
        savingsIncreaseRate.sendKeys(data[6]);

        if (data[7].equalsIgnoreCase("yes")){
            driver.findElement(CalculatorPageObjects.yesSocialSecurityBenefits).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            if (data[8].equalsIgnoreCase("single"))
                driver.findElement(CalculatorPageObjects.maritalStatusSingle).click();
            else
                driver.findElement(CalculatorPageObjects.maritalStatusMarried).click();
            WebElement socialSecurityOverride = driver.findElement(CalculatorPageObjects.socialSecurityOverride);
            socialSecurityOverride.clear();
            socialSecurityOverride.sendKeys(data[9]);
        }else {
            driver.findElement(CalculatorPageObjects.noSocialSecurityBenefits).click();
        }
    }
    public  void clickEditInfoButton(){
        driver.findElement(CalculatorPageObjects.editInfo).click();
    }
}
