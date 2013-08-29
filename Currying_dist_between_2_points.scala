def distance(x:Int,y:Int) = {
	(x2:Int,y2:Int) => {
		     val res = math.sqrt((x2-x)*(x2-x) + (y2-y)*(y2-y))
		     println(res)
		   } 
}
println(distance(-8,-10)(8,10))


