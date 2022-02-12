package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
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

    private Actor josimar;
    private DetailBooking detail;

    @Before
    public void setup() {
        josimar = josimar.named("Josimar the owner");
        josimar.whoCan(CallAnApi.at(baseUrl));
    }


    @When("he sends the information required for create booking")
    public void requireInformationRequestCreateBooking(DataTable table) {
        List<Map<String, String>> forms = table.asMaps();
        Map<String, String> form = forms.get(0);
        detail = form(form);
    }

    private DetailBooking form(Map<String, String> form) {
        DetailBooking detail = new DetailBooking();
        detail.firstname = form.get("firstname");
        detail.lastname = form.get("lastname");
        detail.totalprice = Integer.valueOf(form.get("totalprice"));
        detail.depositpaid = Boolean.valueOf(form.get("depositpaid"));
        detail.bookingdates = new CheckBooking(
                form.get("checkin"),
                form.get("checkout")
        );
        detail.additionalneeds = form.get("additionalneeds");
        return detail;
    }

    @When("create booking")
    public void createBookingRest() {
        josimar.attemptsTo(DoCreateBooking.createBooking(detail));
    }

}
