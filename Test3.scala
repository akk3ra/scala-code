def comVal(f:String=>MyClass, a:String):String = {
	
	val fullName = f("Kumar").getValue()+a
	fullName
}
def myFunc(x:String): MyClass = {
	val midName:String = x
	val obj = new MyClass(midName)
	obj
}

class MyClass(midName:String) {
	val x:String = "Sandeep"+midName
	def getValue(): String = x
}
println(comVal(myFunc, "Akkera"))

