def myMap = Map[String, String]("Sandeep"->"Kumar", "Deepika"-> "Sandanaboina", "Sravani"-> "Akkera")
def testCaseClass(x:Map[String, String]): Boolean = x match {
	case a:Map[_,_] => a get "Sandeep" match {
					case x:Option[String] => true
					case _ => false
				}
	
}
println(testCaseClass(myMap))
