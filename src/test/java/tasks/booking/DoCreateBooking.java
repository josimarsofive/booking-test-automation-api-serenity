package tasks.booking;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoCreateBooking implements Task {

    private final Object chkBooking;


    public DoCreateBooking(Object chkBooking){
        this.chkBooking = chkBooking;

    }

    public static Performable createBooking(Object chkBooking){
       return instrumented (DoCreateBooking.class,chkBooking);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
         actor.attemptsTo(Post.to("/booking")
                 .with(requestSpecification ->
                         requestSpecification.contentType(ContentType.JSON)
                         .body(chkBooking)
                 ));

    }
}
