sealed class Employee(val name:String)
case class Developer(override val name:String) extends Employee(name)
case class Manager(override val name:String) extends Employee(name)
def myTest(f:(List[Employee])=>Unit) {	
	var list1:List[Developer] = List(Developer("Sandeep"), Developer("Vivek"), Developer("Mukesh"))
	var list2:List[Employee] = List(Manager("Sailesh"), Manager("Sudeep"), Manager("Sravan"))

	list2 = list1
	f(list2)
}
myTest((xs:List[Employee])=>{for(y<-xs) y match {
			case Developer(x) => println(x)
			case Manager(x) => println(x)
			case _ => println("Not a valid entry....!!!") 
		}
	})
