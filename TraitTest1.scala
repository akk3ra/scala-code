trait T1 {
	def myTest() = println("This is the trait T1")
}
class C1 extends T1 {
	override def myTest() = println("This is the Class C1")

}
class C2 extends T1 {
	override def myTest() = println("This is the Class C2")
}
class C3 extends C2 with T1 {

}
object TraitTest {
	def process() {
		val x = new C3
		x.myTest()
	}
}
TraitTest.process()
