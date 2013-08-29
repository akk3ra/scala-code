def testCaseClass {
	sealed class Role
	case object Developer extends Role
	case object Manager extends Role
	case object Tester extends Role

	case class Dog(n:String, c:String, r:Role) 
	case class Cat(n:String, c:String, r:Role)

	val maps = Map(1-> new Dog("Lassy", "Domestic", Manager), 2-> new Cat("PussyCat","Wild", Developer), 3-> new Dog("Ceazer","Domestic", Tester))

	for(map<- maps){
		map match {
			case (id, p @ Dog(_,_, Manager)) => println("This is the manager with id-->>"+id +" and values -->>"+p)
			case (id, p @ Cat(_,_, Developer)) => println("This is the developer with id-->>"+id +" and value -->"+p)
			case _ => println("Does not match any pattern-->>")
		}	
	}
}
testCaseClass
