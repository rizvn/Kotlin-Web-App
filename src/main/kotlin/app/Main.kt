import app.Conf.view
import spark.Route
import spark.Spark.get
import java.util.*

fun main(args: Array<String>){
  //Routes
  get("/",        index)
  get("/about",   about)
  get("/contact", contact)
}

//controllers
val index   = Route { req, res -> view("index")  }

val about   = Route { req, res -> view("about") }

val contact = Route { req, res ->
  val map = HashMap<String, Any>()
  map["telNo"] = "0123456";
  view("contact", model = map)
}
