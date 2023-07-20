// Traits are like an interface which can have method.
// Class can also import code from one or several traits

trait Ord {
  def <(that: Any): Boolean // no implements
  def <=(that: Any): Boolean = (this < that) || (this == that)
  def >(that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}
// The type Any which is used above is the type which is a super-type of all other types in Scala.

class Date(y: Int, m: Int, d: Int) extends Ord {
  def year = y
  def month = m
  def day = d
  override def toString(): String = s"$year-$month-$day"

  // Redefines the equals method inherited from Object.
  // The default implementation of Java compares objects physically,
  // so the default implementation of equals cannot be used.
  override def equals(that: Any): Boolean =
    that.isInstanceOf[Date] && {
      val o = that.asInstanceOf[Date]
      o.day == day && o.month == month && o.year == year
    }

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[Date])
      sys.error("cannot compare " + that + " and a Date")

    val o = that.asInstanceOf[Date]
    (year < o.year) ||
    (year == o.year && (month < o.month ||
      (month == o.month && day < o.day)))
  }
}
