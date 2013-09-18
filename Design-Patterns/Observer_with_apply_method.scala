import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.BufferedWriter
import java.io.FileWriter

trait Log {
	def write(str:String)
}
case class SystemLog(f:String=>Unit) extends Log {	
	def write(str:String):Unit = {
		f(str)
	}
}
case class ApplicationLog(f:String=>Unit) extends Log{
	def write(str:String):Unit = {
		f(str)
	}
}
def writeLog(str:String):Unit = {
	val fos = new FileOutputStream("Observer123.txt", true)
	val br = new BufferedWriter(new OutputStreamWriter(fos))
	br.write(str)
	br.flush()
}
object Log {
	def apply(name:String) = if(name eq "SystemLog") SystemLog(writeLog) else ApplicationLog(writeLog)
}
object LogGenerator {
	var logs = List[Log]()
	def +(x:Log) = logs::=x
	def length = logs.length
	def generateLogs(str:String) {
		for(log<-logs) log.write(str)
	}
}
object MyTest{
	def myTest {
		val appLog = Log("ApplicationLog")
		val sysLog = Log("SystemLog")
		LogGenerator + appLog
		LogGenerator + sysLog
		println("Number of logs-->"+LogGenerator.length)
		LogGenerator.generateLogs("This is Sandeep Kumar Akkera.. Scala Programmer")
	}
}
MyTest.myTest

<<<<<<< HEAD
=======

>>>>>>> 1a5b8124a87253d93bb43520e8e797525930a2db
