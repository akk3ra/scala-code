import scala.collection.immutable.HashMap
abstract class FlyWeight {
	def getVal()
}
class LetterA(x:String) extends FlyWeight {
	val id = "A"
	def getVal() = println("This is the flyweight -->>"+id)
}
class LetterB(x:String) extends FlyWeight {
	val id = "B"
	def getVal() = println("This is the flyweight -->>"+id)
}
class FlyWeightFactory {
	var map = FlyWeightFactory.fwMap
	def getFlyWeight(x:String): FlyWeight = {
		if(map.contains(x)) map(x) else {	
						var newFW:FlyWeight = null
						if(x=="A") newFW = new LetterA(x)
						else if(x=="B") newFW = new LetterB(x)						
						map+=(x->newFW)
						newFW
						}
	}	
}
object FlyWeightFactory{
	private var fwMap = HashMap[String, FlyWeight]()
	var x:FlyWeightFactory = null
	def getFlyWeightFactoryInstance(): FlyWeightFactory = {
		if(x==null) {x = new FlyWeightFactory; x} else x
	}
}

val fwFact = FlyWeightFactory.getFlyWeightFactoryInstance()
val a:FlyWeight = fwFact.getFlyWeight("A")
println(a.getVal())

val b:FlyWeight = fwFact.getFlyWeight("B")
println(b.getVal())
