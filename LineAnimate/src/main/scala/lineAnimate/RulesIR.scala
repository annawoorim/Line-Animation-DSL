package lineAnimate
import processing.core._

class RulesIR extends PApplet {
  
  /*
   * Create set of rules defining line animations
   */
  def runAnimation (rules: List[RulesIR], posMoved: Array[Moved], startRule: Array[Start], pos: Position) {         
    var i = 0
    for (i <- 0 to (rules.size - 2)) {
      createRule(rules(i), posMoved(i), startRule(i), startRule(i+1), pos)
    }
    if(posMoved(rules.size - 1).num < rules(rules.size - 1).positionToMove && startRule(rules.size - 1).rule) {
      rules(rules.size - 1).modifyPosition(pos)
      posMoved(rules.size - 1).inc
    }
  }
  
  /*
   * Create array of Moved variables
   */
  def posRules(rules: List[RulesIR]): Array[Moved] = {
    var posMoved = new Array[Moved](rules.size)
    var i = 0
    for (i <- 0 to (rules.size - 1)) {
      posMoved.update(i, Moved())
    }    
    posMoved
  }
  
  /*
   * Create array of Start variables
   */
  def startRules(rules: List[RulesIR]): Array[Start] = {
    var startRule = new Array[Start](rules.size)
    var i = 0
    for (i <- 0 to (rules.size - 1)) {
      startRule.update(i, Start())
    }    
    startRule(0).setTrue
    
    startRule
  }
  
  /*
   * Create conditional statements for each animation rule
   */
  def createRule (rule: RulesIR, posMoved: Moved, startCurr: Start, startNext: Start, pos: Position) {   
    if(posMoved.num < rule.positionToMove && startCurr.rule) {
      rule.modifyPosition(pos)
      posMoved.inc
    }
    if(posMoved.num == rule.positionToMove) 
       startNext.setTrue
  }
  
  def convertToPosition: Position = {
    this match {
      case Position(x,y) => Position(x,y)
    }
  }
  
  /*
   * Shift x or y position of end point of the line
   */
  def modifyPosition(pos: Position) {
    this match {
      case Right(x) => pos.incX
      case Left(x) => pos.decX
      case Up(x) => pos.decY
      case Down(x) => pos.incY
    }
  }
  
  /*
   * Number of pixels for line to move 
   */
  def positionToMove : Float = {
    this match {
      case Right(x) => x
      case Left(x) => x
      case Up(x) => x
      case Down(x) => x
    }
  }
}

/*
 * Current position of the line
 */
case class Position (x: Float, y: Float) extends RulesIR {
  var currX : Float = x
  var currY : Float = y
  
  def incX {  currX+=1  }
  def incY {  currY+=1  }
  def decX {  currX-=1  }
  def decY {  currY-=1  }
}

/*
 * Number of units the line has moved based on a rule
 */
case class Moved() extends RulesIR {
  var num : Int = 0
  
  def inc {  num+=1  }
}

/*
 * Determines whether rule should be executed
 */
case class Start() extends RulesIR {
  var rule : Boolean = false
  
  def setTrue {  rule = true  } 
}

/*
 * Valid rules - line can move right, left, up, or down
 */
case class Right (moveRight: Float) extends RulesIR 
case class Left (moveLeft: Float) extends RulesIR
case class Up (moveUp: Float) extends RulesIR 
case class Down (moveDown: Float) extends RulesIR 