package com.example.core.config

object Environment extends Enumeration {
  val Test: Value = Value("test")
  val Development: Value = Value("development")
  val Staging: Value = Value("staging")
  val Production: Value = Value("production")
}
