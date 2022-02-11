package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.CheckBooking;
import models.DetailBooking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import tasks.booking.DoCreateBooking;

import java.util.List;
import java.util.Map;

public class CreateBookingDefs {

    private static String baseUrl = "https://restful-booker.herokuapp.com";

    Actor josimar;
    DetailBooking detail = new DetailBooking();

    @Before
    public void setup() {
        josimar = josimar.named("Josimar the owner");
        josimar.whoCan(CallAnApi.at(baseUrl));
    }


    @When("he sends the information required for create booking")
    public void requireInformationRequestCreateBooking(DataTable table) {
        List<Map<String, String>> signForms = table.asMaps();
        for (Map<String, String> form : signForms) {
            detail.setFirstname(form.get("firstname"));
            detail.setLastname(form.get("lastname"));
            detail.setTotalprice(Integer.valueOf(form.get("totalprice")));
            detail.setDepositpaid(Boolean.valueOf(form.get("depositpaid")));
            detail.setBookingdates(new CheckBooking(form.get("checkin"), form.get("checkout")));
            detail.setAdditionalneeds(form.get("additionalneeds"));
        }

    }

    @When("create booking")
    public void createBookingRest() {
        josimar.attemptsTo(DoCreateBooking.createBooking(detail));
    }

}
