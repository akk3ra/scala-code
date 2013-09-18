class Product(val name:String, val price:Int)
class ProdList {
	var prodList = List[Product]()
	def +(x:Product) = prodList::=x
	def getIterator:ProdIterator = new ProdIterator(prodList)
}
class ProdIterator(val prodList:List[Product]) {
	val size = prodList.length
	var pos = -1
	def next:Product = {
	   pos+=1
	   if(pos<size)
		  prodList(pos)
	   else null
	}
	def hasNext:Boolean = pos<size
}

object IteratorTest{

	def testIte = {
		val prodList = new ProdList
		prodList + new Product("Kindle",100)
		prodList + new Product("Mobile",200)
	
		val ite = prodList.getIterator

		while(ite.hasNext)
		println(ite.next.name)
	}
}
IteratorTest.testIte
