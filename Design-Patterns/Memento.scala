import scala.collection.mutable.HashMap
class Employee(x:String, y:Int){
	
	private val name = x
	private val age = y
	def getName(): String = name
	def getAge(): Int = age
	def saveState()={
		val empMem:EmployeeMemento = new EmployeeMemento(this)
		empMem
	}
	def restoreState(x:EmployeeMemento): Employee = {var emp:Employee = new Employee(x.getName(), x.getAge())
							emp
							}
}
class EmployeeMemento(x: Employee) {
	val emp = x
	val empName = emp.getName()
	val empAge = emp.getAge()
	
	def getName(): String = empName
	def getAge() : Int = empAge
}

object TestMemento {
	
	val states = HashMap[String, EmployeeMemento]()
	var emp1 = new Employee("Sandeep", 29)

	var empMem:EmployeeMemento = emp1.saveState()
	states+=("state1"->empMem)

	emp1 = new Employee("Deepika",22)
	
	empMem = emp1.saveState()
	states+=("state2"->empMem)

	emp1 = emp1.restoreState(states("state1"))	
	def display(): Unit = {		
		println(emp1.getName())
		println(emp1.getAge())
	
		emp1 = emp1.restoreState(states("state2"))
		println(emp1.getName())
		println(emp1.getAge())
	}	
}

TestMemento.display()
