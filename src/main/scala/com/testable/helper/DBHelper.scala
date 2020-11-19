package com.testable.helper

import java.sql.{Connection, DriverManager}

import com.testable.model.Student

object DBHelper {

  val url = "jdbc:mysql://localhost:3306/demo?characterEncoding=latin1"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "pass123"

  def insert(student: Student): Boolean = {
    try {
      Class.forName(driver)
      println(">>>>>>> 1")
      val connection = DriverManager.getConnection(url, username, password)
      println(">>>>>>> 2")
      val insertSql =
        """
          |insert into student (id, class, gender, name, school, score, total)
          |values (?,?,?,?,?,?,?)
        """.stripMargin

      val prepareStatement = connection.prepareStatement(insertSql)

      prepareStatement.setInt(1, student.id)
      prepareStatement.setInt(2, student.`class`)
      prepareStatement.setString(3, student.gender)
      prepareStatement.setString(4, student.name)
      prepareStatement.setString(5, student.school)
      prepareStatement.setInt(6, student.score)
      prepareStatement.setInt(7, student.total)

      prepareStatement.execute()
      connection.close()
      true
    } catch {
      case e: Exception => e.printStackTrace()
        false
    }
  }
}
