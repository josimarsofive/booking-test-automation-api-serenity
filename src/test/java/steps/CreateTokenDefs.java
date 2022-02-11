package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.GeToken;
import questions.ResponseCode;
import tasks.token.DoCreateToken;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;

public class CreateTokenDefs {

    private static String baseUrl = "https://restful-booker.herokuapp.com";

    Actor josimar;
    User userData = new User();

    @Before
    public void setup() {
        josimar = josimar.named("Josimar the owner");
    }

    @Given("Josimar to use restful booker contains end-points")
    public void callRestfulBooker() {
        //josimar = josimar.named("Josimar the owner").whoCan(CallAnApi.at(baseUrl));
        josimar.whoCan(CallAnApi.at(baseUrl));
    }

    @When("he sends the information required for registration")
    public void requireInformationRequest(DataTable table) {
        List<Map<String, String>> signForms = table.asMaps();
        for (Map<String, String> form : signForms) {
            userData.setUsername(form.get("username"));
            userData.setPassword(form.get("password"));
        }

    }

    @Then("create token booking")
    public void createBooking() {

        josimar.attemptsTo(DoCreateToken.createTkn(userData));
    }

    @Then("response del service to the status code {string}")
    public void response_del_service_to_the_status_code(String code) {
        josimar.should(seeThat("The response code", ResponseCode.was().asString(), equalTo(code)));
    }

    @Then("he must obtain a token in order to authorize the services")
    public void he_must_obtain_a_token_in_order_to_authorize_the_services() {
        User user = new GeToken().answeredBy(josimar);
        josimar.should(seeThat("The Token: ", act -> user.getToken(), notNullValue()));
    }

}
