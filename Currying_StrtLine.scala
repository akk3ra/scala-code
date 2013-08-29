def strLine(x:Int, y:Int) = {
	m:Int=> {
		val c = y-m*x
		()=> {
				var k = if(c>0) "+" else ""
				println("The straight line is -->>"+" y="+m.toString+"x"+k+c.toString)
			}
		}
}
strLine(4,6)(7/3)()
