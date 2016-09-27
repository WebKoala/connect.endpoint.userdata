package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by sander on 8-9-16.
  */
class HealthController extends Controller{
  def index = Action {
    Ok("I'm alive")
  }
}
