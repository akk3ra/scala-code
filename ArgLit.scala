def calc(f:(Int,Int)=>Int, a:Int, b:Int) = {
	
	f(a,b)
}
println("Highest is--->"+calc((x:Int, y:Int)=>if(x>y)x else y, 3,4))
