trait ProductVisitor {
	def visit
}
abstract class Product(n:String) {
	def getName = n
	def accept(pv:ProductVisitor)
}
class Part(n:String) extends Product(n) {
	def accept(pv:ProductVisitor) {
		pv.visit
	}
}
class AddDiscountVisitor extends ProductVisitor {
	def visit = println("This is the product visitor--")
}
class AddTaxVisitor extends ProductVisitor {
	def visit = println("This is the Tax visitor--")
}
class Computer(n:String) extends Product(n) {
	val parts = List[Product](new Part("Mother Board"), new Part("KeyBoard"), new Part("Monitor"), new Part("CPU"), new Part("MemoryRAM"))
	def accept(pv:ProductVisitor){
		for(part<-parts){
			part.accept(pv)
		 }
	}
}
object VisitorTest1 {
	def process {
		val comp = new Computer("Macintosh")
		comp.accept(new AddTaxVisitor)
		comp.accept(new AddDiscountVisitor)
	}
}
VisitorTest1.process
