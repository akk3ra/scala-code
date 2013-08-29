import java.io.PrintWriter
abstract class Address {
	def sendMess(f:(String)=>Unit, str:String)
}

class Towers extends Address {
	def sendMess(f:(String)=>Unit, str:String) = {
		println("Sending message to Towers..")
		f(str)
	}
}
class Churchill extends Address {
	def sendMess(f:(String)=>Unit, str:String) = {
		println("Sending message to Churchill..")
		f(str)
	}
}
class MessageSender {
	var dests:List[Address] = List()
	def +(x:Address) = dests::=x
	def sendGroupMessage(str:String) {
		for(dest<-dests) dest.sendMess(x=>{
			val os = new PrintWriter("testMess.txt", "UTF-8")
			os.write(x)
			os.flush
			},str)
	}
}
def myTest {
	
	val tow = new Towers
	val chu = new Churchill

	val messen = new MessageSender
	messen+tow
	messen+chu
	messen+(new Address{ // This is similar to anonymous classes in Java
		def sendMess(f:(String)=>Unit, str:String) = {
			println("Sending to anonymous Destination--")
			f(str)
		}
		})
	messen.sendGroupMessage("Hi all.. I am Sandeep !!!") 
}
myTest
