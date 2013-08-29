abstract class Shape {
	def draw(): Unit
}

class Point(x:Int, y:Int) {
	
	override def toString() = "Point("+x+ ","+y+")"
}

class Circle(val p:Point, val r:Int) extends Shape {
	def draw(): Unit = println("Point is -->>"+p+" & radius is-->>"+r)	
}

class Rectangle(val p:Point, val h:Int, val w:Int) extends Shape {
	def draw(): Unit = println("Point is -->>"+p+" & height is-->>"+h+" & width is-->>"+w)	
}


