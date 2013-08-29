//import scala.io.Resource
import java.io.PrintWriter

abstract class Log {
	
	def writeLog(x:String): Unit
}

class SystemLog extends Log {
	
	def writeLog(x:String): Unit = {
		val pw = new PrintWriter("SystemLog.txt", "UTF8")
		pw.print(x)
		pw.flush()
		//Resource.fromFile("SystemLog.txt").write(x)(Codec.UTF8)
	}
}

class ApplicationLog extends Log {
	
	def writeLog(x:String): Unit = {
		val pw = new PrintWriter("ApplicationLog.txt", "UTF8")
		pw.print(x)
		pw.flush()
		//Resource.fromFile("ApplicationLog.txt").write(x)(Codec.UTF8)
	}
}

class LogGenerator() {
	
	var logs = List[Log]()
	def +(x:Log):Unit = logs::=x
	def generateLog(str:String):Unit = {
		for(x <- logs) x.writeLog(str)
	}
}

object ObserverTest {
	
	def testObserver() {
		val logGen = new LogGenerator
		logGen+(new SystemLog)
		logGen+(new ApplicationLog)
		logGen.generateLog("Hi This is the observer design Pattern !!!")
	}
}

ObserverTest.testObserver()
