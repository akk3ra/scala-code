class AnonyFuncTest {
	def testInfo(a:Int):Unit = {
		var func = (x:Int)=>println(x+10)
		if(a>0) processInfo(func, a)
		else processInfo(y=> println(y+20), a)
	}
	def processInfo(f:(Int)=>Unit, a:Int):Unit = f(a)
}
val cla = new AnonyFuncTest
println(cla.testInfo(2))
