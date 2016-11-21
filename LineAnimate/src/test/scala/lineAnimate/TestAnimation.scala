package lineAnimate
import processing.core._

object TestAnimation extends RulesIR { 
  def main(args: Array[String]) {
    PApplet.main(Array[String]("lineAnimate.TestAnimation"))
  }  
}

class TestAnimation extends PApplet {
  var pos: Position = Position(200,200)
  val rules: List[RulesIR] = List(
        Right(100),
        Down(100),
        Left(100),
        Up(80),
        Right(80),
        Down(60),
        Left(60),
        Up(40),
        Right(40),
        Down(20),
        Left(20)
  )
  
  var posMoved = TestAnimation.posRules(rules)
  var startRule = TestAnimation.startRules(rules)
    
  override def settings () {
    size(500, 500)
  }

  override def setup() {
    stroke(255)
    background(0)
    frameRate(300)
  }
    
  override def draw { 
    point(pos.currX, pos.currY)
    TestAnimation.runAnimation(rules, posMoved, startRule, pos)
  }
}