package net.vinid.vertx.swagger;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.OpenAPI;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import net.vinid.vertx.swagger.generator.OpenApiRoutePublisher;

public class SwaggerUIHandler {
    public static void publishApiDoc(Router router, String uri, String title, String version, String serverUrl) {
        String swaggerUriPath = uri + "/swagger";
        OpenAPI openAPIDoc = OpenApiRoutePublisher.publishOpenApiSpec(
                router,
                swaggerUriPath,
                title,
                version,
                serverUrl
        );
        router.route(uri + "/*").handler(StaticHandler.create("webroot/swagger").setCachingEnabled(false));
        router.get(swaggerUriPath).handler(res -> {
            res.response()
                    .setStatusCode(200)
                    .end(Json.pretty(openAPIDoc));
        });
    }
}
