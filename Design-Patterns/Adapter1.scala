class SonyCable {
	def getInfo() = println("This is the cable for Sony TV")
}
class SamsungCable {
	def getInfo() = println("This is the cable for Samsumg TV")
}
class SamsungCableAdapter(x:SamsungCable) extends SonyCable{
	val cable:SamsungCable = x
	override def getInfo() = x.getInfo()
}
object Adapter1Test {
	def process() {		
		// The following will not compile
		//val sony:SonyCable = new SamsungCable

		//Use an Adapter to make this possible
		val sony:SonyCable = new SamsungCableAdapter(new SamsungCable)
		sony.getInfo()
	}
}
Adapter1Test.process()
