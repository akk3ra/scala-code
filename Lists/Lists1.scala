abstract class Test(name:String){
	def ret = name
}
case class Exam(name:String) extends Test(name)
case class Quarterly(name:String) extends Test(name)

def testList {
	val list = List[Test](Exam("English"), Quarterly("Mathematics"), Exam("Social Studies"))
	for(item<-List(list)) {
		item match {
			case x::y => println(x.ret+" next size-->>"+y.length)
			case _ => println("Nothing !!!!!")
		}
	}
}
testList
