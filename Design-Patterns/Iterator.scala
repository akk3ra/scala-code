class Employee(n:String, a:Int) {
	val name = n;
	val age = a;
	def getName(): String = name
	def getAge(): Int = age
}
class EmployeeList{
	var empList = List[Employee]()
	def +(x:Employee): Unit = empList::=x
	def empIterator(): EmployeeIterator = new EmployeeIterator(empList)
}
class EmployeeIterator(empList:List[Employee]) {
	var count = 0
	def hasNext(): Boolean = {
		if(count<empList.length) true else false
	}
	def next(): Employee = {
		val ind = count
		count+=1		
		empList(ind)
	}
}
object IteratorTest {
    def process(): Unit = {	
	val empList = new EmployeeList
	empList+(new Employee("Sandeep",29))
	empList+(new Employee("Deepika",22))
	empList+(new Employee("Sravani",28))
	empList+(new Employee("Sathish",32))
	
	var ite = empList.empIterator()	
	while(ite.hasNext()){
		val emp = ite.next()
		println("Name-->>"+emp.getName())
		println("Age-->>"+emp.getAge())
		println("-----------------------")
	}
    }
}
IteratorTest.process()
