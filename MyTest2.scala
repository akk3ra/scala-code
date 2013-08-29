class MyTest2 {
	def myTest2(x : Array[String]): Unit = {
	x.foreach(x=>println(x.toUpperCase()))
	}
}
val test1 = new MyTest2
test1.myTest2(Array("Sandeep", "Kumar", "Akkera"))
