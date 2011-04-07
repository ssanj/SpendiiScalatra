/*
 * Copyright 2009 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import akuru._
import akuru.dsl.AkuruDSL

trait AkuruSupport extends AkuruDSL {

  def onDb: FutureConnection = onDatabase("spendiiscalatra")

  case class User(username:User.usernameField.Value, password:User.passwordField.Value,
                  id:User.idField.Value = User.defaultId) extends DomainObject

  object User extends DomainTemplate[User] {
    val usernameField = field[String]("username")
    val passwordField = field[String]("password")

    override def mongoToDomain(mo: akuru.MongoObject) : scala.Option[User] = {
      for {
        username <- mo.getPrimitiveObject(usernameField)
        password <- mo.getPrimitiveObject(passwordField)
        id <- mo.getIdObject
      } yield User(usernameField === username, passwordField === password, idField === id)
    }
  }
}