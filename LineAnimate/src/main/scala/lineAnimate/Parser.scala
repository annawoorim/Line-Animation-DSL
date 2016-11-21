package lineAnimate
import scala.util.parsing.combinator._

/*
 * Parser used to parse Line Animate DSL for creating 2D line animations.
 */
object Parser extends RegexParsers {
  
  // Parse a list of rules
  def apply(s: String): ParseResult[List[RulesIR]] = parseAll(program, s)  
  def program: Parser[List[RulesIR]] = rule*
  
  // Rules either define start position of line animation or the units 
  // for a line to move
  def rule : Parser[RulesIR] = (
      "Start" ~ "(" ~ num ~ "," ~ num ~ ")" ^^ 
        { case "Start" ~ "(" ~ x ~ "," ~ y ~ ")" => Position(x, y)}
      | "Right" ~ "(" ~ num ~ ")" ^^ { case "Right" ~ "(" ~ num ~ ")" => Right(num) }
      | "Left" ~ "(" ~ num ~ ")" ^^ { case "Left" ~ "(" ~ num ~ ")" => Left(num) }
      | "Up" ~ "(" ~ num ~ ")" ^^ { case "Up" ~ "(" ~ num ~ ")" => Up(num) }
      | "Down" ~ "(" ~ num ~ ")" ^^ { case "Down" ~ "(" ~ num ~ ")" => Down(num) }
  )
  
  // Coordinate position or number of units for position to change
  def num : Parser[Float] = ("""^\d*""".r ^^ { s => (s.toFloat)})
  
  // For parsing comments
  override protected val whiteSpace = """(\s|//.*)+""".r
}