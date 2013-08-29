class MyClass {
def myMeth(x: Int, y: Int): String = {
	if(x==y) "Same"
	else
		"Not Same"
	}
}
val myClass = new MyClass
println(myClass.myMeth(3,4))
