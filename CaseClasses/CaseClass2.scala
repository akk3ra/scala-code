def myMap = Map[String, Int]("Sandeep"->29, "Deepika"-> 23, "Sravani"-> 28)
def testCase(x:Any):Int = x match {
	case a:String => a.length
	case a:Map[Int,_] => a.size
	case _ => -1
}
println(testCase(myMap))
