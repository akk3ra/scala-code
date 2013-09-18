class Computer(val name:String, price:Int, cpu:String, year:Int)
abstract class Builder(name:String) {
	var comp = new Computer(name, 1000, "intel", 2010)
	def retComp = comp
}
class MacBuilder(name:String) extends Builder(name)
class TPBuilder(name:String) extends Builder(name)
class Assembler {
	def build(x:Builder):Computer = x.retComp
}
object TestBuilder {
	def testBuilder {
		val ass = new Assembler
		var comp = ass build(new MacBuilder("MACCOMP"))
		println(comp.name)
		comp = ass build(new TPBuilder("THINKPAD"))
		println(comp.name)
	}
}
TestBuilder.testBuilder
