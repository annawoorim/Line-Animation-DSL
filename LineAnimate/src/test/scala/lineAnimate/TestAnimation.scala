package lineAnimate
import processing.core._

object TestAnimation extends RulesIR { 
  def main(args: Array[String]) {
    PApplet.main(Array[String]("lineAnimate.TestAnimation"))
  }  
}

class TestAnimation extends PApplet {
  //var pos: Position = Position(200,200)
  var pos: Position = Position(0,300)
  val rules: List[RulesIR] = List(
      // cityscape
      Right(50),
      Up(150),
      Right(50),
      Down(150),
      
      Right(20),
      Up(200),
      UpRight(40,20),
      DownRight(40,20),
      Down(200),
      
      Right(20),
      Up(180),
      Right(10),
      Up(10),
      Right(60),
      Down(10),
      Right(10),
      Down(180),
      
      Right(20),
      Up(120),
      Right(10),
      Up(70),
      Right(5),
      UpRight(80,5),
      DownRight(80,5),
      Right(5),
      Down(70),
      Right(10),
      Down(120),
      
      Right(20),
      Up(200),
      Right(110),
      Down(200),
      Right(50)
      
      /* 
       // spiral
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
      */
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