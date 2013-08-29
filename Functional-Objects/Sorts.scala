def mergeSort[T](xs:List[T], less:(T,T)=>Boolean):List[T] = {
	def merge(left:List[T], right:List[T]):List[T] = {
		(left, right) match {
			case (Nil, _) => right
			case (_, Nil) => left
			case (l::l1, r::r1) => if(less(l,r)) l::merge(l1, right) else r:: merge(left, r1)
		}		
	}
	val n = xs.length/2
	if(n==0) xs
	else{
		val (left, right) = xs splitAt n
		merge(mergeSort[T](left,less), mergeSort[T](right,less))
	}
}
println(mergeSort[String](List("D1", "C1", "B1", "A1"), (x,y)=> if(x.charAt(1)>y.charAt(1)) true else false).toString)
println(mergeSort[Int](List(6,2,9,4,5,7,1), (x,y)=>if(x>y)true else false).toString)
