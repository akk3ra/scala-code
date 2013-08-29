import MyImplicits._
object MyImplicits {
	class MyClass{
	def printMy{
			println("The name of which is -->>MyClass")
		}
	}
	implicit def convertTo:MyClass = new MyClass()
}
def myTest(x:String)(y:MyClass) {
	println("My name is ->>"+x+ " and the class name is-->>"+y.printMy)
}

myTest("Sandeep")(new MyClass)
myTest("Sandeep")
