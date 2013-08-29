def calVal(f:(Int)=>Int, g:(Int)=>Int) = {
	z:Int=>f(z)+g(z)+z*z*z
}

println(calVal(x=>x,y=>y*y)(3))
