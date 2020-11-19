package com.testable.actors

import scala.xml.XML
import akka.actor.Actor
import com.lucidchart.open.xtract.XmlReader
import com.testable.model.{Content, Student}

class MainActor extends Actor {

  def receive: Receive = {
    case "trigger" => println("Main Actor.... triggered")

    case "readStudents" =>
      val xml = XML.load(getClass.getResourceAsStream("/sampleData.xml"))
      val students: Seq[Student] = XmlReader.of[Content].read(xml).toOption.fold(Seq.empty[Student])(content => content.students)
      students foreach println

    case _ => println("Good Bye")
  }
}
