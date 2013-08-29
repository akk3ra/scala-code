trait MyTrait {
	val x:Int
	val y:String
	def myMet:Tuple2[Int,String]
}
object myTest extends {
	
	val z = new MyTrait {
		val x = 1
		val y = "Sandeep"
		def myMet = (x,y)
	}.myMet
}

println (myTest.z)
