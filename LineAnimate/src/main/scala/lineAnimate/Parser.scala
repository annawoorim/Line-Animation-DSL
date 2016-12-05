package lineAnimate
import scala.util.parsing.combinator._

/*
 * Parser used to parse Line Animate DSL for creating 2D line animations.
 */
object Parser extends RegexParsers {
  
  // Parse a list of rules
  def apply(s: String): ParseResult[List[RulesIR]] = parseAll(program, s)  
  def program: Parser[List[RulesIR]] = rule*
  
  /*
  def ruleList : Parser[Any] = (
      "{" ~> repsep(rule, ",") <~ "}" ^^ { (ruleList: List[RulesIR]) => ruleList }
  )
  */
  
  // Rules either define start position of line animation or the units 
  // for a line to move
  def rule : Parser[RulesIR] = (
      "Start" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ 
        { case "Start" ~ "(" ~ x ~ "," ~ y ~ ")" => Position(x, y)}
      | "Right" ~ "(" ~ num ~ ")" ^^ { case "Right" ~ "(" ~ num ~ ")" => Right(num) }
      | "Left" ~ "(" ~ num ~ ")" ^^ { case "Left" ~ "(" ~ num ~ ")" => Left(num) }
      | "Up" ~ "(" ~ num ~ ")" ^^ { case "Up" ~ "(" ~ num ~ ")" => Up(num) }
      | "Down" ~ "(" ~ num ~ ")" ^^ { case "Down" ~ "(" ~ num ~ ")" => Down(num) }
      | "UpRight" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "UpRight" ~ "(" ~ y ~ "," ~ x ~ ")"  => UpRight(y, x) }
      | "RightUp" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "RightUp" ~ "(" ~ x ~ "," ~ y ~ ")"  => UpRight(y, x) }
      | "UpLeft" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "UpLeft" ~ "(" ~ y ~ "," ~ x ~ ")"  => UpLeft(y, x) }
      | "LeftUp" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "LeftUp" ~ "(" ~ x ~ "," ~ y ~ ")"  => UpLeft(y, x) }
      | "DownRight" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "DownRight" ~ "(" ~ y ~ "," ~ x ~ ")"  => DownRight(y, x) }
      | "RightDown" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "RightDown" ~ "(" ~ x ~ "," ~ y ~ ")"  => DownRight(y, x) }
      | "DownLeft" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "DownLeft" ~ "(" ~ y ~ "," ~ x ~ ")"  => DownLeft(y, x) }
      | "LeftDown" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ { case "LeftDown" ~ "(" ~ x ~ "," ~ y ~ ")"  => DownLeft(y, x) }
  )
  
  def name : Parser[String] = (""".*""".r ^^ { s => (s.toString)})
  
  // Coordinate position or number of units for position to change
  def num : Parser[Float] = ("""^\d*""".r ^^ { s => (s.toFloat)})
  
  // For parsing comments
  override protected val whiteSpace = """(\s|//.*)+""".r
}