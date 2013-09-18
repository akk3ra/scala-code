trait Phone {
	def hasAttributes
}
class SimplePhone extends Phone {
	def hasAttributes = {
		println("I am a Simple Phone")
	}
}
class NokiaDecorator(phone:Phone) extends Phone {
	def hasAttributes = {
		phone.hasAttributes
		println("This is the Nokia Cell Phone")
		println("This is a non-smart phone")
	}
}
class AndroidDecorator(phone:Phone) extends Phone {
	def hasAttributes = {
		phone.hasAttributes
		println("This is the Android Phone")
		println("This is a smart phone")
		println("This is a constly phone")
	}
}
object Decorator2Test {
	def testDecorator = {
		val simplePhone = new SimplePhone
		simplePhone.hasAttributes
		println("-----------------------------------------")
		var decorator:Phone = new NokiaDecorator(simplePhone)
		decorator.hasAttributes
		println("-----------------------------------------")
		decorator = new AndroidDecorator(simplePhone)
		decorator.hasAttributes
	}	
}
Decorator2Test.testDecorator
