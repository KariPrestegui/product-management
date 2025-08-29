package integration.com.test.handler;

import com.core.dev.testing.ApiGatewayProxyHandlerExecutor;
import com.core.dev.testing.WithFixtureResource;
import com.LambdaHandler;
import com.upax.core.api.http.StatusCodes;
import com.upax.core.utils.Env;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * PingHandlerTest
 * <p>
 * The "ping" resource in an API is a simple entry point to check the basic availability of the service.
 * <p>
 * Using it to wake up the container
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */

@WithFixtureResource(directory = "src/test/java/integration/com/test/handler/events/")
class PingHandlerTest {

    @BeforeAll()
    static void setup() {
        Env.load(".env");
    }

    @Test
    @DisplayName("Test ping endpoint of context")
    void testPingRoute() throws Exception {
        ApiGatewayProxyHandlerExecutor.from(this)
                .withEvent("ping_event.json")
                .run(LambdaHandler.class)
                .toOptionalProxyResponse()
                .ifPresent(response -> {
                    Assertions.assertEquals(
                            StatusCodes.SUCCESS.httpCode(),
                            response.getStatusCode(),
                            "Status code should be 200"
                    );
                });
    }
}


