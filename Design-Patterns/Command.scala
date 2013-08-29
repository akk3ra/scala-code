class Name(n:String) {
	def getName(): String = n
}
trait Command {
	def execute()
}
class ProcessNameCommand(n:Name) extends Command {

	def execute() {
		println("The name after processing is -->>"+n.getName+ "Akkera")
	}
}
class FilterNameCommand(n:Name) extends Command {		
	def execute(){
		println ("The name after filtering the name is -->>"+n.getName + "Kumar Akkera")
	}	
}
class Processor {
	var comm:Command = null
	def setCommand(c:Command) = comm = c
	def processCommand = comm.execute
}
object CommandTest {	
	def process() {
		var proc = new Processor
		val name = new Name("Sandeep")
		val processNameCom = new ProcessNameCommand(name)

		proc.setCommand(processNameCom)
		proc.processCommand

		val filterNameCom = new FilterNameCommand(new Name("Sandeep"))
		proc.setCommand(filterNameCom)
		proc.processCommand
	}
}

CommandTest.process
