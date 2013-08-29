def msort[T](func:(T,T)=>Boolean)(sl:List[T]):List[T] = {
	def merge(x:List[T], y:List[T]):List[T] = (x,y) match {
		case (_,Nil) => x
		case (Nil,_) => y
		case (x1::xs1, y1::ys1) => if(func(x1,y1)) x1::merge(xs1,y) else y1::merge(x, ys1)  
		case _ => Nil
	}
	val n = sl.length/2
	val (l,r) = sl splitAt n
	merge(msort(func)(l), msort(func)(r))
}
println(msort[Int](_>_)(List(2,7,3,6,4,9)))
