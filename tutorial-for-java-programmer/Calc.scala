import Tree._

object Calc {
  type Environment = String => Int
  // Change processing according to Tree case class
  def eval(t: Tree, ev: Environment): Int = t match {
// the addition of the evaluations of its two inner expressions
    case Sum(l, r) => eval(l, ev) + eval(r, ev)
    case Var(n)    => ev(n) // return values to variables
    case Const(v)  => v // return argument
  }
  // Change processing according to Tree case class
  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r)        => Sum(derive(l, v), derive(r, v))
    case Var(n) if v == n => Const(1) // pattern matching with "guard"
    case _                => Const(0) // "_" means wildcard
  }

  def main(args: Array[String]): Unit = {
    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    // return value according to case "x" or "y"
    val env: Environment = {
      case "x" => 5
      case "y" => 7
    }
    println("Expression: " + exp)
    println("Evaluation with x=5, y=7: " + eval(exp, env))
    println("Derivative relative to x:\n " + derive(exp, "x"))
    println("Derivative relative to y:\n " + derive(exp, "y"))
  }
}

// exp
//         .——— 7
//     .———
//    |    `——— 7
// ———
//    |    .——— 5
//     `———
//         `——— 5
