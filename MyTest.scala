trait Friend {
	val name:String
	def listen = println("I am "+name+" listening")
}
class Animal(val name:String)
class Dog(override val name:String) extends Animal(name)

val dog = new Dog("Lassy") with Friend
dog.listen
