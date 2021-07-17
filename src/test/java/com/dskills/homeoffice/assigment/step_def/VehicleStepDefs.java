package com.dskills.homeoffice.assigment.step_def;



import com.dskills.homeoffice.assigment.page_objects.HomePage;
import com.dskills.homeoffice.assigment.utils.FileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class VehicleStepDefs {
    private FileReader fileReader;
    private HomePage homePage;
    private List<String> expected;
    private List<String> actual;

    public VehicleStepDefs(FileReader fileReader, HomePage homePage) {
        this.fileReader = fileReader;
        this.homePage = homePage;
    }

    @Given("^I retrieve vehicle registration numbers from \"([^\"]*)\"$")
    public void retrieveInput(String inputFile) throws IOException, URISyntaxException {
        File filePath = fileReader.loadFileFromResources(inputFile);
        List<String> regNumbers = fileReader.findRegNumber(filePath);
        homePage.setInput(regNumbers);

    }

    @Given("^I retrieve vehicle identity from output file \"([^\"]*)\"$")
    public void retrieveOutput(String inputFile) throws IOException, URISyntaxException {
        File filePath = fileReader.loadFileFromResources(inputFile);
        expected = fileReader.readOutputData(filePath);
    }

    @When("^I search for vehicle registration number and extract \"([^\"]*)\" information$")
    public void searchReg(String vehicleInformation) {
        actual = homePage.vehicleSearch(homePage.getInput());
    }

    @Then("^I compare data with outputFile$")
    public void compareData() {

        List<String> tests = actual;
        tests.forEach(s -> {
            boolean match = expected.stream().anyMatch(b -> s.contains(b));
            assertThat("Tests",match);
        });

    }
}
