package questions;

import models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GeToken implements Question {
    @Override
    public User answeredBy(Actor actor) {
        return  SerenityRest.lastResponse().as(User.class);
    }
}
