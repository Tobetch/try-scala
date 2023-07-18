import java.util.{Date, Locale} // multiple import
import java.text.DateFormat._ // import entire package. instead of using asterisk(*), can use "getDateInstance" and "LONG"

object FrenchDate {
  def main(args: Array[String]): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now) // "df format now" equals "df.format(now)"
  }
}
