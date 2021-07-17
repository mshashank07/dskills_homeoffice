package com.dskills.homeoffice.assigment.page_objects;

import com.dskills.homeoffice.assigment.base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseTest {

    @FindBy(css = "input[placeholder='Enter Registration']")
    private WebElement registration_text;

    @FindBy(css = ".jsx-4211136584")
    private WebElement car_check_button;

    @FindBy(css = "img[aria-label='Car Tax Check']")
    private WebElement home_button;

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    private List<String> input;

    public List<String> vehicleSearch(List<String> numbers) {
        List<String> output = new ArrayList<>();
        for (String number : numbers) {
            home_button.click();
            waitUntilElementClickable(registration_text).clear();
            registration_text.sendKeys(number);
            registration_text.sendKeys(Keys.ENTER);
            sleep(10000);
            output.add(new ResultsPage().retrieveVehicleTypeData("Vehicle Identity"));
        }
        return output;
    }
}
