package com.testable.model

import com.lucidchart.open.xtract.{XmlReader, __}
import com.lucidchart.open.xtract.XmlReader._
import cats.syntax.all._

/*<student>
    <id>1</id>
    <class>10</class>
    <gender>M</gender>
    <name>John</name>
    <school>xyz school</school>
    <score>450</score>
    <total>500</total>
  </student>*/

case class Student(id: Int,
                   `class`: Int,
                   gender: String,
                   name: String,
                   school: String,
                   score: Int,
                   total: Int)

object Student {

  implicit val reader: XmlReader[Student] = (
    (__ \ "id").read[Int],
    (__ \ "class").read[Int],
    (__ \ "gender").read[String],
    (__ \ "name").read[String],
    (__ \ "school").read[String],
    (__ \ "score").read[Int],
    (__ \ "total").read[Int]
    ).mapN(apply _)
}

case class Content(students: Seq[Student])

object Content {
  implicit val reader: XmlReader[Content] = (__ \ "student").read(seq[Student]).map(apply _)
}
