abstract class Prod(n:String) {
	def getName = n
}
class Part(n:String) extends Prod(n)
def testPatMat(prods:List[Prod]) {
	for(prod<-prods){
		prod.getName match{
			case "My Part1" => println("This is the correct part")
			case "My Part2" => println("Even this is the correct part")
			case _ => println("This is an error !!!!!!") 
		}
	}
}
object TestPatMat {
	val list = List[Prod](new Part("My Part1"), new Part("My Part2"))
	def test = testPatMat(list)
}

TestPatMat.test
