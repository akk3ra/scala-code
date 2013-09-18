
object ColorFactory {
	
	val myColors = HashMap[Color]()	

	def getColorInstance(name:String) :Color {
		
		myColors
	}
}

abstract class Color(name:String) {
	def getName = name
}

class Green(name:String) extends Color(name)
class Yellow(name:String) extends Color(name)
class Black(name:String) extends Color(name)

object myFlyweight {
	
	Color color = ColorFactory getInstance("green")
	
	println(color getName)
}

myFlyweight


