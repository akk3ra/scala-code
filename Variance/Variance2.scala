trait Similar {
	def isSimilar(x:Any):Boolean
}
case class MyInt(x:Int) extends Similar {
	def isSimilar(m:Any):Boolean = 
		m.isInstanceOf[MyInt] &&
		m.asInstanceOf[MyInt].x ==x
}
object UpperBoundTest extends Application {
	def findSimilar[T<:Similar](e:T, xs:List[T]):Boolean = 
		if(xs.isEmpty) false
		else if(e.isSimilar(xs.head)) true
		else findSimilar(e,xs.tail)
	     val list:List[MyInt] = List(MyInt(1),MyInt(2),MyInt(3))
	     println(findSimilar[MyInt](MyInt(4),list))
	     println(findSimilar[MyInt](MyInt(2),list))
}

UpperBoundTest.findSimilar[MyInt](MyInt(4), List(MyInt(4),MyInt(3),MyInt(2)))
