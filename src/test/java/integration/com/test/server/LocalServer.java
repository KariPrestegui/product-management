package integration.com.test.server;

import com.upax.core.utils.Env;
import com.LambdaHandler;

import static com.core.dev.testing.server.v2.ZkServerV2.startServer;
import static com.api.Routes.router;

/**
 * LocalServer
 * <p>
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */
public class LocalServer {

    /**
     * Main method to start the local server.
     *
     * @throws Exception if any error occurs while starting the server.
     */
    public static void main(String[] args) throws Exception {
        Env.load(".env");
        startServer(LambdaHandler.class, router).watch();
    }
}


