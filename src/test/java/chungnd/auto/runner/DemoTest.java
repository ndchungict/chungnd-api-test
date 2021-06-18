package chungnd.auto.runner;

import lombok.extern.log4j.Log4j2;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import chungnd.auto.helper.Read;

@Log4j2
@RunWith(SerenityRunner.class)
public class DemoTest {
    @Test
    public void test(){
        log.info("login lan 1");
        Read read = new Read();
        read.gettingLog();
        log.info("login lan 2");
    }
}
