object MyTest {
	def cluster[T](xs:List[T]):List[List[T]] = xs match {
		case Nil => Nil
		case y::ys => 
			val(first, rest) = xs span (_==y)
			first::cluster(rest)
	}
	def encode[T](xs:List[T]):List[(T,Int)] = {
		cluster(xs) map (x=>(x.head,x.length))
	}
}
println(MyTest.encode("aaaabbbbgggggttttfffkkkkkk".toList))
