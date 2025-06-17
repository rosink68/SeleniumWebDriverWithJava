package msg.group.pageobjects;

import msg.group.abstractcomponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends AbstractComponent {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        // WebDriver zur Parentklasse senden
        super(driver);

        // Initialisierung des WebDrivers
        this.driver = driver;

        // Triggern des Initialisieren aller Elemente mit Hilfe der PageFactory
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userMobile")
    private WebElement userMobile;

    @FindBy(css = "select[formcontrolname='occupation']")
    private WebElement occupationDropdown;

    @FindBy(css = "input[type='radio'][value='Male']")
    private WebElement genderMale;

    @FindBy(css = "input[type='radio'][value='Female']")
    private WebElement genderFemale;

    @FindBy(id = "userPassword")
    private WebElement userPassword;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(css = "input[type='checkbox'][formcontrolname='required']")
    private WebElement ageCheckbox;

    @FindBy(id = "login")
    private WebElement registerButton;

    public void completeRegistration(String fName, String lName, String email, String phoneNumber,
                                     String occupation, String gender, String password, String confirmPW) {
        // Eingabefelder ausfüllen
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userEmail.sendKeys(email);
        userMobile.sendKeys(phoneNumber);

        // Dropdown für Occupation auswählen
        selectOccupation(occupation);

        // Geschlecht auswählen
        selectGender(gender);

        // Passwortfelder ausfüllen
        userPassword.sendKeys(password);
        confirmPassword.sendKeys(confirmPW);

        // Checkbox aktivieren
        ageCheckbox.click();

        // Registrierungsbutton klicken
        registerButton.click();
    }

    public void enterFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void enterLastName(String name) {
        lastName.sendKeys(name);
    }

    public void enterUserEmail(String emailAddress) {
        userEmail.sendKeys(emailAddress);
    }

    public void enterUserMobile(String number) {
        userMobile.sendKeys(number);
    }

    public void selectOccupation(String occupation) {
        Select select = new Select(occupationDropdown);
        select.selectByVisibleText(occupation);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            genderMale.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            genderFemale.click();
        }
    }

    public void enterUserPassword(String pwd) {
        userPassword.sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        confirmPassword.sendKeys(pwd);
    }

    public void checkAgeCheckbox() {
        if (!ageCheckbox.isSelected()) {
            ageCheckbox.click();
        }
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}