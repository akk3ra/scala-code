def processVal(f:(String)=>String, n:String)={
		x:String=> {
			var nam = f(n)+" "+x
				z:String=> {
						println(nam+" "+z)
					   }	
			}
}
processVal(_.toUpperCase(), "sandeep")("kumar")("akkera")
val b = processVal _
val c = b(x=>x.toUpperCase(), "sandeep")("kumar")(_)
c("akkera")

