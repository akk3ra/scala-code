class Product(val name:String)
class Computer(override val name:String) extends Product(name)
class Television(override val name:String) extends Product(name)

class Order[+T](val id:Int) {
	var prodList = List[T]()
	def +[A>:T](prod:A) = prodList::=prod
	def getProdList=prodList
}
def myTest {
	val prod1 = new Product("Macintosh")
	val prod2 = new Product("Sony")

	var order1 = new Order[Product](001)
	order1+prod1
	order1+prod2
	
	val prods = order1.getProdList

	for(prod<-prods) println(prod.name)
	
	val comp1 = new Computer("Comp1")
	val comp2 = new Computer("Comp2")

	var order2 = new Order[Computer](002)
	order2+comp1
	order2+comp2

	order1 = order2
}
myTest 
