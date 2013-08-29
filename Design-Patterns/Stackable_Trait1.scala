abstract class Color {
	def getColor(): String
	def setColor(x:String):Unit
}
class Green extends Color {
	var color:String = "GREEN"
	override def getColor(): String = color
	override def setColor(x:String) = { color = x }
}
trait ColorDecor extends Color {
	abstract override def setColor(x:String): Unit = {super.setColor("Decorating "+x+" with PINK") }
}
class MyColor extends Green with ColorDecor

val x = new MyColor
println(x.getColor())

val y = new MyColor with ColorDecor
y.setColor("GREEN")
println(y.getColor())
