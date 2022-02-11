package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import models.CheckBooking;
import models.DetailBooking;
import net.serenitybdd.screenplay.Actor;
import tasks.booking.DoCreateBooking;

import java.util.List;
import java.util.Map;

public class CreateBookingDefs {
    Actor josimar;
    DetailBooking detail = new DetailBooking();
    

    @When("he sends the information required for create booking")
    public void requireInformationRequestCreateBooking(DataTable table){
        List<Map<String, String>> signForms = table.asMaps();
        for (Map<String, String> form : signForms) {
            detail.setFirstname(form.get("firstname"));
            detail.setLastname(form.get("lastname"));
            detail.setTotalprice(form.get("totalprice"));
            detail.setDepositpaid(form.get("depositpaid"));
            detail.setCheckBooking(new CheckBooking(form.get("checkin"),form.get("checkout")));
            detail.setAdditionalneeds(form.get("additionalneeds"));
        }

    }
    @When("create booking")
    public void createBookingRest(){
      josimar = josimar.named("Josimar the owner") ;
      josimar.attemptsTo(DoCreateBooking.createBooking(detail));

    }

}
