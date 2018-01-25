package com.example.application.config

import com.example.core.config.Environment
import com.typesafe.config.{ Config, ConfigFactory }
import com.typesafe.scalalogging.LazyLogging
import net.ceedubs.ficus.Ficus._

object HelloServerConfig extends LazyLogging {
  logger.info("HelloServerConfig init")
  private val config: Config = ConfigFactory.load()

  val environment: Environment.Value = Environment.withName(config.as[String]("environment"))
  logger.info(s"HelloServerConfig.environment = $environment")

  object Server {
    lazy val host: String = config.as[String]("server.host")
    lazy val port: Int = config.as[Int]("server.port")
  }
  logger.info(s"HelloServerConfig.server.host = ${Server.host}")
  logger.info(s"HelloServerConfig.server.port = ${Server.port}")

  logger.info("HelloServerConfig done")
}
