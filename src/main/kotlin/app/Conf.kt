package app

import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.loader.ClasspathLoader
import java.io.StringWriter
import java.nio.charset.StandardCharsets
import java.util.*

/**
 * Created by Riz
 */
object Conf {
  //lazy init pebble template engine
  val pebbleEngine: PebbleEngine by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    val loader = ClasspathLoader()
    loader.prefix = "view"
    loader.suffix = ".peb"
    loader.charset = StandardCharsets.UTF_8.name();
    val engine = PebbleEngine(loader)
    engine.templateCache = null //disable cache for dev
    engine
  }

  /**
   * Function used to render a view with moddl
   * @param view name of view to use
   * @param model optional model to send to view
   */
  fun view(view: String, model: Map<String, Any> = HashMap<String, Any>()): String {
    val template = pebbleEngine.getTemplate(view)
    val writer = StringWriter()
    template.evaluate(writer, model)
    return writer.toString()
  }
}