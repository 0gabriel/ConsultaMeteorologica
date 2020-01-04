package controllers

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def consultaClimaCidade(id: String): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
    Ok(Conexao.weatherCity(id))
  }

  def uv(id: String): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      Ok(Conexao.uvCity(id))
  }

  def forecast(id: String): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      Ok(Conexao.forecastCity(id))
  }
}
