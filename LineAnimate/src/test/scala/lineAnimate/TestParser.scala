package lineAnimate
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatest.Matchers
import org.scalatest.FunSuite

class TestParser extends FunSuite with Matchers {  
  test ("Check start") {
    Parser("Start(200, 200)").get should be (List(Position(200, 200)))
  }
  
  test ("Check right") {
    Parser("Right(10)").get should be (List(Right(10)))
  }
  
  test ("Check left") {
    Parser("Left(100)").get should be (List(Left(100)))
  }
  
  test ("Check up") {
    Parser("Up(50)").get should be (List(Up(50)))
  }
  
  test ("Check down") {
    Parser("Down(500)").get should be (List(Down(500)))
  }
  
  test ("Check rule list") {
    Parser("{ Right(10) }").get should be (List(Right(10)))
  }
}