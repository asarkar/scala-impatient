package name.abhijitsarkar.scala.scalaimpatient.traits

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    val now = ISO_LOCAL_DATE_TIME.format(LocalDateTime.now())
    
    /* super doesn't call the super trait Logged. It calls the trait to the left of it when mixed in. If log is abstract
     * in super trait, this doesn't compile unless declared abstract. At runtime, a concrete log methods needs 
     * to be mixed in.
     */
    super.log(f"${now} $msg")
  }
}