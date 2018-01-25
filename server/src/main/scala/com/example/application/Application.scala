package com.example.application

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.example.application.routing.HelloRoute
import com.example.application.config.HelloServerConfig
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext

object Application
  extends App
  with LazyLogging {
  implicit val system: ActorSystem = ActorSystem("application")
  implicit val ec: ExecutionContext = system.dispatchers.lookup("dispatchers.default-worker")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  logger.info("Application trying to start...")
  Http()
    .bindAndHandle(
      new HelloRoute().route,
      HelloServerConfig.Server.host,
      HelloServerConfig.Server.port
    )
    .map { binding => logger.info(s"Application started at ${binding.localAddress}") }
    .recover {
      case throwable: Throwable =>
        logger.error("Application failed to start", throwable)
        System.exit(1)
    }
}
