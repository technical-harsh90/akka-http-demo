import akka.actor.{ActorSystem, Props}
import akka.event.Logging
import akka.http.scaladsl.Http
import com.testable.actors.MainActor
import com.testable.microservice.StudentMicroService
import com.typesafe.config.ConfigFactory
object Demo extends App with StudentMicroService {

  override implicit val system = ActorSystem()
  override implicit val executor = system.dispatcher

  override val config = ConfigFactory.load()
  override val logger = Logging(system, getClass)

  val mainActor = system.actorOf(Props[MainActor], "mainActor")
  mainActor ! "trigger"
  mainActor ! "readStudents"

  Http().newServerAt(config.getString("http.interface"), config.getInt("http.port")).bindFlow(routes)
}
