trait CarElement {
	def accept(visit:Visitor)
}
trait Visitor {
	def visit
}
class CarVisitor extends Visitor {
	def visit = {
		println("I am the CAR VISITOR")
	}
}
class Tyre(name:String) extends CarElement {
	def getName = name
	def accept(visit:Visitor) = {
		println("This is a Tyre..")
		visit.visit	
	}
}
class Steering extends CarElement {
	def accept(visit:Visitor) = {
		println("This is a Steering..")
		visit.visit
	}
}
class Body extends CarElement { 
	def accept(visit:Visitor) = {
		println("This is the Car body..")
		visit.visit
	}
}
class Car(parts:List[CarElement]) extends CarElement {
	def accept(visit:Visitor) = {
		parts.foreach(_.accept(visit))
	}
}
object CarVisitorTest {
	def carVisit = {
		val parts = List[CarElement](new Tyre("LEFT"), new Tyre("RIGHT"), new Tyre("REAR1"), new Tyre("REAR2"), new Steering,
						new Body)
		val car:CarElement = new Car(parts)
		car.accept(new CarVisitor)
	}
}
CarVisitorTest.carVisit

