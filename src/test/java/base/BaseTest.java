package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import utils.ConfigManager;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigManager.get("base.url");
    }
}