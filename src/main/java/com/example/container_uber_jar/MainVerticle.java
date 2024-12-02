package com.example.container_uber_jar;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;

public class MainVerticle extends VerticleBase {

  @Override
  public Future<?> start() {
    return vertx.createHttpServer().requestHandler(req -> {
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!");
      })
      .listen(8888)
      .onSuccess(v -> System.out.println("HTTP server started on port 8888"));
  }
}
