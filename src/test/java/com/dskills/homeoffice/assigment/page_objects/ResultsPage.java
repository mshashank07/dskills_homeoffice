package com.dskills.homeoffice.assigment.page_objects;

import com.dskills.homeoffice.assigment.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BaseTest {

    @FindBy(css = ".jsx-2556725779    .jsx-3807182525 ")
    private List<WebElement> vehicleTypes;

    public String retrieveVehicleTypeData(String type) {
        StringBuilder str = new StringBuilder();
        vehicleTypes.forEach(vehicleType -> {
            boolean vehicle_type = vehicleType.getText().contains(type);
            if (vehicle_type) {
                List<WebElement> elements = vehicleType.findElements(By.cssSelector(".jsx-3496807389"));
                for (WebElement s : elements) {
                    str.append(s.getText() + ",");
                }
            }
        });
        return str.toString();
    }
}
