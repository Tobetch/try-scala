// class with parameter, use like "new Complex(1.5, 2.3)"
// All classes has super class.
// When no super-class is specified, "scala.AnyRef" is implicitly used.
class Complex(real: Double, imaginary: Double) {
  // methods don't have return value, but compiler infers as "Double" type
  // def re() = real
  // def im() = imaginary
  // methods with no arguments
  def re = real
  def im = imaginary
  override def toString() =
    "" + re + (if (im >= 0) "+" else "") + im + "i"
}
