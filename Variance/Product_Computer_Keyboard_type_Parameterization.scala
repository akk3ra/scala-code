class Product{ 
	def mProd = println("Product")
}
class Computer extends Product {
 	def mComp = println("Computer")
}
class KeyBoard extends Computer {
	def mKey = println("Keyboard")
}
def typeTest(f:Computer=>Computer) {
	val comp = new Computer
	val comp1 = f(comp)
	comp1.mProd
	comp1.mComp
}
typeTest((x:Product)=> new KeyBoard)
typeTest((x:Computer)=> new Computer)
//typeTest((x:KeyBoard)=> new Product)
