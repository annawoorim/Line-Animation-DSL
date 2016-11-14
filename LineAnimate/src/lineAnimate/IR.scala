package lineAnimate
import processing.core._

class IR extends PApplet {
  var currX, currY: Float = 0
  
  def Draw (rules: List[IR]) {    
    var x, y: Float = 50
    
    point(x, y)

  }
}

case class Start (startX: Int, startY: Int) extends IR {
  currX = startX
  currY = startY
}

case class Right (moveRight: Float, rule: Int = 0, startRule: Boolean = false) extends IR {
  val bound = currX + moveRight
  if (currX < bound && currY == currY) { currX+=1 }   
}

case class Left (moveLeft: Float) extends IR {
  val bound = currX - moveLeft
  if (currX > bound && currY == currY) { currX-=1 }
}

case class Up (moveUp: Float) extends IR {
  val bound = currY - moveUp
  if (currY > bound && currX == currX) { currY-=1 }
}
  
case class Down (moveDown: Float) extends IR {
  val bound = currY + moveDown
  if (currY < bound && currX == currX) { currY+=1 }
}