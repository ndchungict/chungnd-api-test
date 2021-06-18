package chungnd.auto.helper;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class PropertiesManager {
    private PropertiesManager() {
        throw new IllegalStateException("Helper class");
    }

    public static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getEnvironmentVariable(String propertyName) {

        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(propertyName);
    }

    public static String getProperty(String key) {
        return environmentVariables.getProperty(key);
    }
}
