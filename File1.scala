import scala.io.Source
def File1(x:String): Unit = {
	val lines = Source.fromFile(x).getLines.toList
	def proc(f:List[String]=>Unit) = {
		f(lines)
	}
	proc(x => for(y <- x) println(y))
}
File1("test.txt")	
