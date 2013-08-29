def calcPrice(item:String)={
	val stock = Map[String,Int]("abfitch"->75, "aero"->45, "tommyH"->55, "americanE"->60)
	    x:Int=>{
		var value = stock(item)
		value = value - ((value*x)/100)
		z:Int=> {
			 value = value+ (value*z)/100
			 value
			}  
		}
}
println(calcPrice("abfitch")(10)(2))
println(calcPrice("aero")(25)(12))
println(calcPrice("tommyH")(15)(10))
println(calcPrice("americanE")(5)(7))

