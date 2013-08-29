import java.io.PrintWriter

abstract class Log {
	
	def writeLog(f:(String,String)=>Unit, x:String): Unit
}
class SystemLog extends Log {
	def writeLog(f:(String,String)=>Unit, x:String): Unit = {
		f(x, "SystemLog.txt")
	}
}
class ApplicationLog extends Log {
	def writeLog(f:(String,String)=>Unit, x:String): Unit = {
		f(x, "ApplicationLog.txt")
	}
}
class LogGenerator() {
	var logs = List[Log]()
	def +(x:Log):Unit = logs::=x
	def generateLog(str:String):Unit = {
		for(x <- logs) x.writeLog((y,logLocation)=>{
					val pw = new PrintWriter(logLocation, "UTF8")
					pw.print(y)
					pw.flush()}
					,str)
	}
}
object ObserverTest {
	
	def testObserver() {
		val logGen = new LogGenerator
		logGen+(new SystemLog)
		logGen+(new ApplicationLog)
		logGen.generateLog("This is awesome... wonderful...fabulous")
	}
}
ObserverTest.testObserver()
