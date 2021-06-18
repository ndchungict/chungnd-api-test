package chungnd.auto.helper;

import com.github.javafaker.Faker;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    private Generator(){
        throw new IllegalStateException("Generate Dummy Data");
    }

    private static final Faker FAKER = new Faker();
    private static final Timestamp TIMESTAMP = new Timestamp(System.currentTimeMillis());

    public static Faker summonFaker(){
        return FAKER;
    }

    public static String getCurrentTime(){
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-Ms").format(TIMESTAMP);
    }
}
