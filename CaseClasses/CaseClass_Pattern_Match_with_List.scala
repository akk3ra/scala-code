def testCaseClass {
	val list1 = List[String]("Sandeep","Deepika", "Sravani", "Sathish")
	val list2 = List[String]("Akkera","Sandanaboina", "Mekala", "Kumar")
	for(lis<-List(list1, list2)) {
		lis match {
			case List("Sandeep",_,_,_) => println("Got Sandeep-->"+p)
			case _ => println("Other value-->>")
		}
	}
}
testCaseClass
