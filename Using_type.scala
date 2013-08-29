import java.io._
abstract class BulkReader {
	type t
	val source:t
	def read
}
class StringBulkReader(val source: String) extends BulkReader {
	type t = String
	def read = println(source)
}
class FileBulkReader(val source:File) extends BulkReader {
	type t = File
	def read = {
		val in = new BufferedReader(new InputStreamReader(new FileInputStream(source)))
		var line = ""
		while((line=in.readLine)!=Null){
			println(line)
		}
	}
}
object TestType {
	def process{
	 val x = new StringBulkReader("Sandeep")
	 x.read
	
	 val y = new FileBulkReader(new File("Using_type.scala"))
	 y.read
	}
}

TestType.process
