import java.io.OutputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter

abstract class Log(f:String=>Unit) {
	def writeLog(mess:String) = f(mess)
}
case class SystemLog(f:String=>Unit) extends Log(f)
case class ApplicationLog(f:String=>Unit) extends Log(f)
object LogGenerator {
	var list = List[Log]()
	def +(log:Log) = list::=log
	def genLog(mess:String) = list foreach(_.writeLog(mess))
}
object TestObserver {
	def testObs {
		LogGenerator + SystemLog(writeFunc)
		LogGenerator + ApplicationLog(writeFunc)
		LogGenerator + new Log(writeFunc) {
			override def writeLog(mess:String) = writeFunc(mess)
		}
		LogGenerator genLog "This is Sandeep... Scala Programmer.." 
	}
}
def writeFunc(mess:String):Unit = {
	val os = new FileOutputStream("log.txt", true)
	val osw = new OutputStreamWriter(os)
	osw write(mess)
	osw flush
}
TestObserver.testObs

