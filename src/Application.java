import processing.core.PApplet;
import processing.core.PGraphics;

public class Application extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Application");
	}
	
	


	public float m1=800;
	public float m2=800;
	
	public float mx= mouseX;
	public float my = mouseY;

	public float r1=200;
	public float r2=200;

	public float a1=PI/2;
	public float a2=PI/2;

	public float g=1;

	public float a1_v=0;
	public float a2_v=0;

	public float a1_a=0;
	public float a2_a=0;


	public float px2=-1;
	public float py2=-1;

	public PGraphics canvas;
	


	public void settings() {
		size(1200, 600);
	}

	
	
	public void setup() {
	  canvas = createGraphics(width, height);
	  canvas.beginDraw();
	  canvas.background(255);
	  canvas.endDraw();
	}

	public void draw() {
	  //background(255);
	  image(canvas, 0, 0);
	  stroke(0);
	  strokeWeight(2);

	  
	  
	  translate(width/2, 200);

	  float x1 = r1*sin(a1);
	  float y1 = r1*cos(a1);

	  float x2 = x1+ r2*sin(a2);
	  float y2 = y1+ r2*cos(a2);

	  line(0, 0, x1, y1);
	  ellipse(x1, y1, 40, 40);

	  line(x1, y1, x2, y2);
	  ellipse(x2, y2, 40, 40);

	  a1_v+=a1_a;
	  a2_v+=a2_a;
	  a1+=a1_v;
	  a2+=a2_v;

	  // if(

	  float num1 = -g *(2*m1+m2)*sin(a1);
	  float num2 = -m2*g*sin(a1-2*a2);
	  float num3 = -2*sin(a1-a2)*m2;
	  float num4 = a2_v*a2_v*r2+a1_v*a1_v*r1*cos(a1-a2);
	  float den1 = r1*(2*m1+m2-m2*cos(2*a1-2*a2));
	  float calc1 = (num1+num2 +num3*num4)/den1;
	  a1_a=calc1;
	  num1=2*sin(a1-a2);
	  num2 = (a1_v*a1_v*r1*(m1+m2));
	  num3 = g*(m1+m2)*cos(a1);
	  num4= a2_v*a2_v*r2*m2*cos(a1-a2);
	  float den2 = r2*(2*m1+m2-m2*cos(2*a1-2*a2));
	  float calc2=num1*(num2+num3+num4)/den2;
	  a2_a=calc2;


	  canvas.beginDraw();
	  canvas.translate(width/2, 200);

	  
	  
	  
	  canvas.strokeWeight(4);
	  canvas.stroke(x2, y2/2, x2);

	  if (px2!=-1) {
	    canvas.line(px2, py2, x2, y2);
	  }
	  
	  
	  canvas.endDraw();
	  

	  System.out.print(a1_v);
	  System.out.print("_");
	  System.out.print(a2_v);
	  System.out.println("");
	  
	  a1_v *= 0.999;
	  a2_v *= 0.999;
	  
	  
	  px2 = x2;
	  py2 = y2;
	}
	
}
