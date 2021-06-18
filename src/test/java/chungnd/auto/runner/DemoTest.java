package chungnd.auto.runner;

import chungnd.auto.task.CreateToken;
import lombok.extern.log4j.Log4j2;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Test;
import org.junit.runner.RunWith;

@Log4j2
@RunWith(SerenityRunner.class)
public class DemoTest {
    @Test
    public void test() {
        OnStage.setTheStage(new OnlineCast());

        Actor chung = new Actor("chung");
        chung.attemptsTo(
                CreateToken.with("chungnd", "ngocanh")
        );
    }
}
