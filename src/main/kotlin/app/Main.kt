import app.Conf.view
import spark.Route
import spark.Spark.get

fun main(args: Array<String>){
  //Routes
  get("/",        index)
  get("/contact", contact)
  get("/about",   about)
}

//controllers
val index   = Route { req, res -> view("index")  }
val contact = Route { req, res -> view("contact")}
val about   = Route { req, res -> view("about")  }