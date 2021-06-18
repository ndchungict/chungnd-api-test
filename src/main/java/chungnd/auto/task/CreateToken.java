package chungnd.auto.task;

import chungnd.auto.helper.PropertiesManager;
import chungnd.auto.model.Authenticate;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Log4j2
@AllArgsConstructor
public class CreateToken implements Task {
    private Authenticate authenticated;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();

        log.info(PropertiesManager.getEnvironmentVariable("api.baseUri"));
        log.info("/auth");
        log.info("Authenticate Request: " + gson.toJson(authenticated));

        actor.whoCan(CallAnApi.at(PropertiesManager.getEnvironmentVariable("api.baseUri"))).attemptsTo(
                Post.to("/auth")
                        .with(request ->
                                request.header("Content-Type", "application/json")
                                        .body(authenticated)
                        )
        );

        log.info("Authenticate Response: " + SerenityRest.lastResponse().getBody().asString());
        String token = SerenityRest.lastResponse().jsonPath().getString("token");
        log.info("Token: " + token);
        Serenity.setSessionVariable("token").to(token);
    }

    public static CreateToken with(String username, String password) {
        return instrumented(CreateToken.class, new Authenticate(username, password));
    }
}
