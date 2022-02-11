package tasks.token;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoCreateToken implements Task {

    private final Object userInfo;


    public DoCreateToken(Object userInfo){

        this.userInfo = userInfo;
    }

    public static Performable createTkn(Object userInfo) {

        return instrumented(DoCreateToken.class, userInfo);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/auth")
                .with(requestSpecification
                        -> requestSpecification.contentType(ContentType.JSON)
                                .body(userInfo)
                        ));
    }
}
