package Controllers

import play.api.mvc._

object Application extends Controller {
  case class Place(id: Int, name: String)

  val city = List(
    Place(1, "London"),
    Place(2, "New York"),
    Place(3, "Blumenau")
  )
  implicit val placesWrites = Json.writes[Place]

  def listPlaces = Action {
    val json = Json.toJson(places)
    Ok(json)

  }

  def index = Action {
    Ok(views.html.main())
  }

}