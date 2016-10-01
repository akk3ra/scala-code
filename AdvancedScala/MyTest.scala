class Person(val name:String)
object Person {
	implicit val person:Person = new Person("Akkeera")
}

def sayHello(implicit person:Person):String = s"Hello jee ${person.name}"

sayHello