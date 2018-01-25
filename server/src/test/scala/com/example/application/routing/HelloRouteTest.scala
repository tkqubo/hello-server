package com.example.application.routing

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.example.core.config.Environment
import org.scalatest.WordSpec

class HelloRouteTest extends WordSpec
  with ScalatestRouteTest {
  "route" should {
    "respond with greeting" in {
      val environment = Environment.Staging
      val route = new HelloRoute(environment)
      Get("/") ~> Route.seal(route.route) ~> check {
        assert(responseAs[String] === s"Hello $environment")
      }
    }
  }
}
