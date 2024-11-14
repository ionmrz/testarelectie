package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormaPage {

    @FindBy(id = "firstName")
    private WebElement firstNameEl;

    @FindBy(id = "lastName")
    private WebElement lastNameEl;

    @FindBy(id = "userEmail")
    private WebElement emailEl;

    @FindBy(xpath = "//label[text()='Male']")
    private WebElement genderMaleEl;

    @FindBy(id = "userNumber")
    private WebElement mobileEl;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthEl;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsEl;

    @FindBy(xpath = "//label[text()='Sports']")
    private WebElement hobbiesSportsEl;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPictureEl;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressEl;

    @FindBy(id = "react-select-3-input")
    private WebElement stateEl;

    @FindBy(id = "react-select-4-input")
    private WebElement cityEl;

    public static WebDriver driver;
    private WebDriverWait wait;

    public FormaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameEl(String firstName) {
        firstNameEl.sendKeys(firstName);
    }

    public void setLastNameEl(String lastName) {
        lastNameEl.sendKeys(lastName);
    }

    public void setEmailEl(String email) {
        emailEl.sendKeys(email);
    }

    public void setGenderEl(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            genderMaleEl.click();
        }
        // You can add additional conditions for "Female" and "Other" as needed.
    }

    public void setMobileEl(String mobile) {
        mobileEl.sendKeys(mobile);
    }

    public void setDateOfBirthEl(String dateOfBirth) {
        dateOfBirthEl.click();
        dateOfBirthEl.sendKeys(Keys.CONTROL + "a"); // Selectează tot textul

        // Setează data în formatul necesar, de exemplu: "2005-06-15"
        dateOfBirthEl.sendKeys(dateOfBirth);
    }



    public void selectSubjects() {
        // Lista de subiecte pe care dorim să le selectăm
        String[] subjects = {"Computer Science", "English"};

        for (String subject : subjects) {
            // Găsește câmpul de input și introduce subiectul
            subjectsEl.sendKeys(subject);

            // Așteaptă până când sugestiile apar și selectează prima sugestie
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("subjects-auto-complete__option")));
            subjectsEl.sendKeys(Keys.ENTER); // Selectează primul subiect din lista de sugestii
        }}
    public void setHobbiesEl(String hobbyId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the label associated with the checkbox by matching the `for` attribute
            WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='" + hobbyId + "']")));

            // Scroll into view to ensure the element is visible
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);

            // Use JavaScript to click the label
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", field);
        } catch (Exception e) {
            System.out.println("Could not click on hobby: " + hobbyId + " - " + e.getMessage());
        }
    }


    public void setUploadPictureEl(String filePath) {
        uploadPictureEl.sendKeys(filePath);
    }

    public void setCurrentAddressEl(String address) {
        currentAddressEl.sendKeys(address);
    }

    public void setStateEl(String state) {
        stateEl.sendKeys(state);
        stateEl.sendKeys("\n"); // Presses Enter to select the state
    }

    public void setCityEl(String city) {
        cityEl.sendKeys(city);
        cityEl.sendKeys("\n"); // Presses Enter to select the city
    }
}
