import java.io.PrintWriter

trait LogGenerator {
	var loggers = List[Log]()
	def addLogger(o:Log) = loggers::=o
	def generateLog(f:(String,String)=>Unit, mess:String):Unit = 	for(log<-loggers){
									     println("Writing to the logger-->>"+log.getLoggerName)
									     f(mess,log.getLogLocation)
									}
}
abstract class Log(n:String) {
	val name = n
	def getLoggerName() = name
	def getLogLocation(): String
}
class SystemLog(n:String) extends Log(n) {
	override def getLogLocation(): String = "SystemLog.txt"
}
class ApplicationLog(n:String) extends Log(n) {
	override def getLogLocation(): String = "ApplicationLog.txt"
}
class ObserverTest extends LogGenerator {
def process(){
		println("Adding loggers---")
		addLogger(new SystemLog("SystemLog"))
		addLogger(new ApplicationLog("ApplicationLog"))
		generateLog((x, y)=> { 
			    val pw = new PrintWriter(y,"UTF-8")
			    pw.write(x)
			    pw.flush()
			  }
				,"Hi this is Sandeep.. Scala Programmer....")
	}
}

val test = new ObserverTest
test.process
