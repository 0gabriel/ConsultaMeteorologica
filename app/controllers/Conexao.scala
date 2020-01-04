package controllers

import play.api.libs.json.{JsValue, Json}

object Conexao extends App {
  def key = "8b5a004556603b16260559b8b78120aa"
  def urlOpening = "http://api.openweathermap.org/data/2.5/"

  def weatherCity(cityName: String) =  {
    var url = urlOpening + "weather?q="
    url = url + cityName
    url = url + "&appid=" + key
    val result = scala.io.Source.fromURL(url).mkString
    result
  }

  def uvCity(cityName: String) = {
    val json: JsValue = Json.parse(weatherCity(cityName))
    val longitude = (json \ "coord" \ "lon").asOpt[Double]
    val latitude = (json \ "coord" \ "lat").asOpt[Double]
    var url = urlOpening + "uvi?lat=" + latitude.get
    url = url + "&lon=" + longitude.get
    url = url + "&appid=" + key
    val result = scala.io.Source.fromURL(url).mkString
    result
  }

  def forecastCity(cityName: String): String = {
    var url = urlOpening + "forecast?q="
    url = url + cityName
    url = url + "&appid=" + key
    val result = scala.io.Source.fromURL(url).mkString
    result
  }

}
