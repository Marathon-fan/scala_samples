import com.mchange.v2.c3p0.ComboPooledDataSource
import org.slf4j.LoggerFactory
import org.scalatra.slickexample._
import org.scalatra._
import javax.servlet.ServletContext

import slick.jdbc.MySQLProfile.api._

import org.scalatra.CorsSupport

/**
 * This is the ScalatraBootstrap bootstrap file. You can use it to mount servlets or
 * filters. It's also a good place to put initialization code which needs to
 * run at application start (e.g. database configurations), and init params.
 */
class ScalatraBootstrap extends LifeCycle {

  val logger = LoggerFactory.getLogger(getClass)

  val cpds = new ComboPooledDataSource
  logger.info("Created c3p0 connection pool")

  override def init(context: ServletContext) {

    //http
    context.mount(new HttpIndex, "/web/*")
    context.initParameters("org.scalatra.cors.allowedOrigins") = "*"
    context.setInitParameter(CorsSupport.AllowedMethodsKey, "GET,PUT")
    context.setInitParameter(CorsSupport.AllowedHeadersKey, "Content-Type")
    //db
    val db = Database.forDataSource(cpds, None)

    context.mount(new SlickApp(), "/db/*")
  // the following entry points for restful services
  // /managent/create-db
  // /managent/drop-db
  // /api/users
  // /api/users


  }

  private def closeDbConnection() {
    logger.info("Closing c3po connection pool")
    cpds.close
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
    closeDbConnection
  }
}
