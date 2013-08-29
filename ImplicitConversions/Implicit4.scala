import MyImplicits._
class MyProcess[T,M](val x:T,val y:M) {
	val tup = Tuple2[T,M](x,y)
	def getVal:M = tup._2
}
object MyImplicits {	
	class MyConversionClass[T](x:T) {
		def %>[M](y:M): MyProcess[T,M] = new MyProcess[T,M](x,y)
	}
	implicit def myConversion[T](x:T) = new MyConversionClass(x)
}
def myTest {
	val x = 1%>2
	println(x.getVal)
}
myTest
