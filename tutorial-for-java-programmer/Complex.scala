// classw with parameter, use like "new Complex(1.5, 2.3)"
class Complex(real: Double, imaginary: Double) {
  // methods don't have return value, but compiler infers as "Double" type
  // def re() = real
  // def im() = imaginary
  // methods with no arguments
  def re = real
  def im = imaginary
}
