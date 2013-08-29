abstract class Letter{
	def name
}
class LetterA extends Letter{
	def name = println("I am letter A")
}
class LetterB extends Letter {
	def name = println("I am letter B")
}
trait Letters {
	val letterA:String = "LetterA"
	val letterB:String = "LetterB"
}
object LetterFactory {
	var letters:Map[String, Letter] = Map()
	def apply(f:(String)=>Letter,x:String):Letter = { 
		if(letters.contains(x)){} 
		else letters+= (x->f(x))
		letters(x)
	}
}
def myFlyWeight{
	var let1 = LetterFactory(calcLet,"LetterA")
	let1.name
	let1 = LetterFactory(calcLet,"LetterB")
	let1.name
}
def calcLet(x:String):Letter = {
	if(x eq "LetterA") return new LetterA
	else new LetterB
}
myFlyWeight
