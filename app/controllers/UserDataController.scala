package controllers

import models.UserDataCreateRequest
import play.api.libs.json.Json.JsValueWrapper
import play.api.libs.json.{JsError, JsObject, JsValue, Json}
import play.api.mvc.{Action, BodyParsers, Controller}

import scala.concurrent.Future

/**
  * Created by sander on 8-9-16.
  */
class UserDataController extends Controller {

  implicit val UserDataCreateRequestReads = Json.reads[UserDataCreateRequest]
  import scala.concurrent.ExecutionContext.Implicits.global

  def create: Action[JsValue] = Action.async(BodyParsers.parse.json) { implicit request =>

    val createRequestResult = request.body.validate[UserDataCreateRequest]
    createRequestResult.fold(
      errors => {
        Future.successful(
          BadRequest(contentForFailure(JsError.toJson(errors)))
        )
      },
      createRequest => {
        Future.successful(Ok(createRequest.lastname))
      })
  }

  private def content(status: String, message: JsValueWrapper): JsObject = {
    Json.obj("status" -> status, "message" -> message)
  }
  private def contentForFailure: (JsValueWrapper) => JsObject = content("Failed", _)
  }
