package com.example.application.routing

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.example.application.config.HelloServerConfig
import com.example.core.config.Environment

class HelloRoute(environment: Environment.Value = HelloServerConfig.environment) {
  val route: Route =
    path("") {
      get {
        complete(s"Hello $environment")
      }
    }
}
