import processing.core._; 

object cityscape { 
  def main(args: Array[String]) {
    PApplet.main(Array[String]("cityscape"))
  }
}

class cityscape extends PApplet {

  var x : Float = 0;
  var y : Float = 300;

  override def settings () {
    size(500, 500)
  }
 
  override def setup() {
    stroke(255)
    background(0)
  }
  
  override def draw {
    // First building
    if(x<50 && y==300) { x+=1; point(x,y); }
    else if(x==50 && y>150) { y-=1; point(x,y); }
    else if (x<100 && y==150) { x+=1; point(x,y); }
    else if (x==100 && y<300) { y+=1; point(x,y); }
  
  
    // Second building
    else if (x<120 && y==300) { x+=1; point(x,y); }
    else if (x==120 && y>100) { y-=1; point(x,y); }
    else if (x<140 && y>60) { x+=0.5f; y-=1; point(x, y); }
    else if (x<160 && y<100) { x+=0.5f; y+=1; point(x, y); }
    else if (x==160 && y<300) { y+=1; point(x,y); }
   
  // Third building - experimenting with line() vs. point()
  else if (x<180 && y==300) { x+=1; line(160, 300, x, 300); }
  else if (x==180 && y>120) { y-=1; line(180, 300, 180, y); }
  else if (x<190 && y==120) { x+=1; line(180, 120, x, 120); }
  else if (x==190 && y>110) { y-=1; line(190, 120, 190, y); }
  else if (x<250 && y==110) { x+=1; line(190, 110, x, 110); }
  else if (x==250 && y<120) { y+=1; line(250, 110, 250, y); }
  else if (x<260 && y==120) { x+=1; line(250, 120, x, 120); }
  else if (x==260 && y<300) { y+=1; line(260, 120, 260, y); }
  
  // Fourth building
  else if (x<280 && y==300) { x+=1; point(x, y); }
  else if (x==280 && y>180) { y-=1; point(x, y); }
  else if (x<290 && y==180) { x+=1; point(x, y); }
  else if (x==290 && y>110) { y-=1; point(x, y); }
  else if (x<295 && y==110) { x+=1; point(x, y); }
  else if (x<300 && y>30) { x+=1; y-=16; point(x, y); }
  else if (x<305 && y<110) { x+=0.0625f; y+=1; point(x, y); }
  else if (x<310 && y==110) { x+=1; point(x, y); }
  else if (x==310 && y<180) { y+=1; point(x, y); }
  else if (x<320 && y==180) { x+=1; point(x, y); }
  else if (x==320 && y<300) { y+=1; point(x, y); }
  
  // Fifth building
  else if (x<340 && y==300) { x+=1; point(x, y); }
  else if (x==340 && y>100) { y-=1; point(x, y); }
  else if (x<450 && y==100) { x+=1; point(x, y); }
  else if (x==450 && y<300) { y+=1; point(x, y); }
  else { x+=1; point(x,y); } 
  }
}