
abstract class Product {
	def getName:String
}
class Monitor extends Product {	
	def getName = "I am Monitor"
}
class Keyboard extends Product {
	def getName = "I am Keyboard"
}

trait AddComponent extends Product {	
	abstract override def getName:String = super.getName
}
