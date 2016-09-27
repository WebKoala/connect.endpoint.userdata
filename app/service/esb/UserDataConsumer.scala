package service.esb

import models.UserData

/**
  * Created by sander on 8-9-16.
  */
trait UserDataConsumer {

  def GetAll(): Seq[UserData]
  def Get(id:Integer): UserData  // When we have a system for generating unique numbers, we should get implement this using a guid..
  def Create(userData: UserData)
  def Update(userData: UserData)

}


object UserDataConsumerFactory {

  def Create(ws: WSClient): UserDataConsumer ={

  }
}

class ESBUserDataConsumer(ws: WSClient) extends UserDataConsumer{

  override def GetAll(): Seq[UserData] = ???

  override def Get(id: Integer): UserData = ???

  override def Create(userData: UserData): Unit = ???

  override def Update(userData: UserData): Unit = ???

}
