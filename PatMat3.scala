abstract class Prod(n:String){
	def getName = n
}
case class Part(n:String) extends Prod(n)
object TestPatMat3 {
	val tup1 = List("Sandeep", 29, new Part("KeyBoard"), new Part("MotherBoard"))
	val tup2 = List("Sravani", 28, new Part("Monitor"), new Part("Processor"))
	val list = List(tup1, tup2)
	def process(tup:List[Any]):Unit = {		
		for(tupVal<-tup){
			tupVal match {
				case s:String => println("This is a String -->>"+ s)
				case i:Int => println("This is an Integer-->"+i)
				case Part(name) => println("This is an objec with the name -->>"+name)
				case _ => println("An Unauthorized object !!!")
			}
		}
	}
	def callTo(){
		for(lis<-list){
			process(lis)	
		}
	}	
}
TestPatMat3.callTo


