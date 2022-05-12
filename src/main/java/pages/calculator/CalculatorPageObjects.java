package pages.calculator;

import org.openqa.selenium.By;

public class CalculatorPageObjects {
    public static final By currentAge = By.xpath("//input[@id='current-age']");
    public static final By retirementAge = By.xpath("//input[@id='retirement-age']");
    public static final By currentIncome = By.xpath("//input[@id='current-income']");
    public static final By spouseIncome = By.xpath("//input[@id='spouse-income']");
    public static final By currentTotalSavings = By.xpath("//input[@id='current-total-savings']");
    public static final By currentAnnualSavings = By.xpath("//input[@id='current-annual-savings']");
    public static final By savingsIncreaseRate = By.xpath("//input[@id='savings-increase-rate']");
    public static final By yesSocialSecurityBenefits = By.xpath("//*[@id='include-social-container']/ul/li[1]/label");
    public static final By noSocialSecurityBenefits = By.xpath("//*[@id='include-social-container']/ul/li[2]/label");
    public static final By maritalStatusSingle = By.xpath("//*[@id='marital-status-ul']/li[1]/label");
    public static final By maritalStatusMarried = By.xpath("//*[@id='marital-status-ul']/li[2]/label");
    public static final By socialSecurityOverride = By.xpath("//input[@id='social-security-override']");
    public static final By calculate = By.xpath("//button[@onclick='calculateResults();']");
    public static final By editInfo = By.xpath("//button[@onclick='navigateToRetirementForm();']");
    public static final By successMessage = By.xpath("//button[contains(text(),'Email')]");
}
