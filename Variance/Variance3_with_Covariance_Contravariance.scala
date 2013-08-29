sealed class Employee(val name:String)
case class Developer(override val name:String) extends Employee(name)
case class Manager(override val name:String) extends Employee(name)
trait ListMod[+T] {
	def head:T
	def tail:List[T]
	def isEmpty:Boolean
	def getList:List[T]
}
object ListMod {
	def apply[T](x:T*):ListMod[T] = new ListModImpl[T](x.toList)
	class ListModImpl[T](val xs:List[T]) extends ListMod[T] {
		def head:T = xs.head
		def tail:List[T] = xs.tail
		def isEmpty:Boolean = if(xs.length==0) true else false
		def getList:List[T] = xs
	}
}
def myTest(f:(ListMod[Employee])=>Unit) {
	
	var list1:ListMod[Developer] = ListMod(Developer("Sandeep"),Developer("Sravani"),Developer("Deepika"))
	var list2:ListMod[Employee] = ListMod(Developer("Sailesh"),Manager("Sudeep"),Manager("Ajay"))
	
	list2 = list1
		f(list2)
		
	var list3:ListMod[Manager] = ListMod(Manager("Vivek"), Manager("Akkera"), Manager("Chary"))
	list1 = list3
		f(list1)
}
myTest((list:ListMod[Employee])=> { for(lis<-list.getList) lis match {
			case Developer(x) => println(x)
			case Manager(x) => println(x)
			case _ => println("OOOpsssssss!!!!!")
		    }
		})
