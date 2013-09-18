
class Product(n:String, a:Int) {
	private val name = n
	private val age = a

	def getName = name
	def getAge = age

	def saveState:ProductMemento = new ProductMemento(this)
	def restoreState(prodMem:ProductMemento):Product = new Product(prodMem.getName, prodMem.getAge)
}
class ProductMemento(prod:Product) {
	private val product = prod
	def getName = product.getName
	def getAge = product.getAge
}
object TestMemento {
	def testMemento {

		import scala.collection.mutable.Map
		val mems = Map[String, ProductMemento]()
		var prod = new Product("Sandeep",30)
		mems += ("Sandeep" -> prod.saveState)
		prod = new Product("Deepika", 23)
		mems += ("Deepika" -> prod.saveState)
		prod = new Product("Sravvanii", 29)
		mems += ("Sravvanii" -> prod.saveState)
	
		var prod1 = prod.restoreState(mems("Sandeep"))
		println(prod1.getAge)	
		prod1 = prod.restoreState(mems("Sravvanii"))
		println(prod1.getAge)	
		
				

	}	

}
TestMemento.testMemento
