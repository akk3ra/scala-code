class Car {
	 
}
abstract class CarBuilder {
	var car:Car = null
	def createCar(){
		car = new Car
	}
	def buildTyres(): Unit
	def buildBody(): Unit	
	def buildSeats(): Unit
	def getCar(): Car = car
}
class MaruthiCarBuilder extends CarBuilder{
	def buildTyres():Unit = println("Adding Maruthi tyres--")
	def buildBody():Unit = println("Adding  Maruthi body--")
	def buildSeats():Unit = println("Adding Maruthi seats--")
}
class HondaCarBuilder extends CarBuilder{
	def buildTyres():Unit = println("Adding Honda tyres--")
	def buildBody():Unit = println("Adding  Honda body--")
	def buildSeats():Unit = println("Adding Honda seats--")
}
class MercedesCarBuilder extends CarBuilder{
	def buildTyres():Unit = println("Adding  Mercedes tyres--")
	def buildBody():Unit = println("Adding  Mercedes body--")
	def buildSeats():Unit = println("Adding Mercedes seats--")
}

class Mechanic {
	
	var carBuilder:CarBuilder = null
	def setCarBuilder(cb:CarBuilder) = carBuilder = cb
	
	def buildCar() = {
		carBuilder.createCar()
		carBuilder.buildTyres()
		carBuilder.buildBody()
		carBuilder.buildSeats()
	}
	
	def getCar(): Unit = carBuilder.getCar()
}

object Builder1Test {
	def process() {
		
		val mechanic = new Mechanic
		mechanic.setCarBuilder(new MercedesCarBuilder)
		mechanic.buildCar()
		mechanic.setCarBuilder(new HondaCarBuilder)
		mechanic.buildCar()
		mechanic.setCarBuilder(new MaruthiCarBuilder)
		mechanic.buildCar()
		val car = mechanic.getCar()
	}
}
Builder1Test.process()












