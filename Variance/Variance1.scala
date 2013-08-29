abstract class Employee(val name:String) {
	def getName:String = name
}
class Manager(override val name:String, val dep:String) extends Employee(name) {
	def getDep:String = dep
}
class Developer(override val name:String, val dep:String) extends Employee(name){
	def getDep:String = dep
}
class Award[+T](x:T) {
	def getEmp:T = x
}
class Bonus[+T](x:T){
	def getEmp[B>:T](y:B):B = y
}
def myTest {	
	val emps = List[Award[Developer]](new Award(new Developer("Sandeep","Technology")))
	val emps1:List[Award[Employee]] = emps
	for(emp<- emps) {
		println(emp.getEmp.getName)	
	}

	val bons = List[Bonus[Developer]](new Bonus(new Developer("Sandeep","Technology")))
	val bons1:List[Bonus[Manager]] = bons
	for(bon<-bons){
		println(bon.getEmp.getName)
	}
}
myTest
