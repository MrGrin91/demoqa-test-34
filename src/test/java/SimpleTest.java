import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleTest {
    @Test
    void successfulSearchTest() {
        Assertions.assertTrue(3 > 2);
    }
}
