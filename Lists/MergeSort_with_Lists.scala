def msort[T](func:(T,T)=>Boolean)(xs:List[T]):List[T] = {
	def merge(x:List[T], y:List[T]):List[T] = (x,y) match {
		case (_, Nil) => x
		case (Nil, _) => y
		case (x1::xa1, y1::ya1) => if(x1<y1) x::merge(xa1, y) else y::merge(x, ya1) 	
	}
	val n = xs.length/2
	if(n==0) xs
	else{
	  val (x, y) = xs splitAt n
	  merge(msort(func)(x), msort(func)(y))
	}
}
msort((x:Int,y:Int)=> x < y)(List(2,3,6,9,1,4))
