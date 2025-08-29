package com;


import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.upax.core.api.cloud.aws.APIGatewayProxyHandler;
import com.upax.core.api.cloud.aws.lambda.EventPipe;
import com.upax.core.application.Ctx;

/**
 * LambdaHandler
 * <p>
 * LambdaHandler
 *
 * @author Kari Cordero Prestegui | karina.cordero@elektra.com.mx
 * @version 0.1.0
 * @since 2025-08-29
 */

public class LambdaHandler extends APIGatewayProxyHandler {
    public LambdaHandler() throws Throwable {
        Ctx.load(Initializer.class);
    }

    @Override
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent event) throws Throwable {
        return Ctx.resolveDependency(EventPipe.class)
                .orElseThrow()
                .execute(event);
    }


}





