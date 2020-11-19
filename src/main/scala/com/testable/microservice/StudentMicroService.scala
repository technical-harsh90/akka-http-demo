package com.testable.microservice

import akka.actor.ActorSystem
import akka.event.LoggingAdapter
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.testable.helper.DBHelper
import com.testable.model.Student
import com.typesafe.config.Config
import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import scala.concurrent.ExecutionContextExecutor

trait StudentMicroService extends DefaultJsonProtocol {
  implicit val system: ActorSystem

  implicit def executor: ExecutionContextExecutor

  def config: Config

  val logger: LoggingAdapter

  implicit val studentFormat: RootJsonFormat[Student] = jsonFormat7(Student.apply)

  val routes: Route = {
    pathPrefix("student") {
      logRequestResult("student-micro-service") {
        (post & entity(as[Student])) { studentObject =>
          complete {
            if (DBHelper.insert(studentObject))
              Success(200)("Student Success", s"Following student has been saved : ${studentObject}")
            else
              InternalServerError
          }
        }
      }
    }
  }
}
