package integration.com.test.handler;

import com.LambdaHandler;
import com.core.dev.testing.ApiGatewayProxyHandlerExecutor;
import com.core.dev.testing.WithFixtureResource;
import com.upax.core.api.http.StatusCodes;
import com.upax.core.utils.Env;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * GetSortedProductHandlerTest
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */

@WithFixtureResource(directory = "src/test/java/integration/com/test/handler/events/")
public class GetSortedProductHandlerTest {

    @BeforeAll()
    static void setup() {
        Env.load(".env");
    }

    @Test
    @DisplayName("Test health endpoint of context")
    void testHealthRoute() throws Exception {
        ApiGatewayProxyHandlerExecutor.from(this)
                .withEvent("get_sorted_product_event.json")
                .run(LambdaHandler.class)
                .toOptionalProxyResponse()
                .ifPresent(response -> {
                    Assertions.assertEquals(
                            StatusCodes.SUCCESS.httpCode(),
                            response.getStatusCode(),
                            "The status code should be 200"
                    );
                });
    }
}
