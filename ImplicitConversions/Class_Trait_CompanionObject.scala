trait Product{
	def name:String
	def type1:String
}
object Product{
	def apply(n:String,t:String):Product = t match {
		case "Monitor" => new Monitor("Samsung", "Monitor")
		case "Keyboard" => new Keyboard("Sony", "Keyboard")
	//	case _ => Any		
	} 
	private	class Monitor(private val n:String,private val t:String) extends Product{
		def name = n
		def type1 = t
	}
	private class Keyboard(private val n:String,private val t:String) extends Product{
		def name = n
		def type1 = t
	}
}
def myTest {
	val prod1 = Product("Samsung","Monitor")
	println("The product1 price is -->>"+prod1.name)

	val prod2 = Product("Sony","Keyboard")
	println("The product2 price is -->>"+prod2.type1)
}
myTest
