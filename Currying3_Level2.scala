class User(n:String, s:Int, c:String) {
	val name = n
	var salary = s
	var city = c
	def getName(): String = name
	def getSalary(): Int = salary
	def getCity(): String = city
	def setSalary(s1:Int)  = salary = s1
	def setCity(c1:String) = city = c1
}
def transformObj(x: List[User])= {
		val userList = x
		val tranList1 = for (y<-userList) yield {
							  y.setSalary(30000)
							  y
						        }
		n1Tran:String => {
				val tranList2 = for(z<-tranList1) yield {
									 z.setCity(n1Tran)
									 z
									} 
				n2Tran:String => for(b<-tranList2)println("Name-->"+b.getName()+" salary->>"+b.getSalary()+" city-->>"+b.getCity()+ "----"+n2Tran )
			       }
}
object TestCurry3 {
	def process(){
			val user1 = new User("Sandeep", 60000, "Minneapolis")
			val user2 = new User("Deepika", 80000, "Minneapolis")
			val user3 = new User("Sravani", 75000, "Minneapolis")
			val user4 = new User("Sathish", 70000, "Minneapolis")
			val user5 = new User("Sadhana", 90000, "Hyderabad")
			
			val list = List[User](user1,user2,user3,user4,user5)
			var x = transformObj(list)
			var y = x("Secunderabad")
			var z = y("This is Dummy")
		}
}
TestCurry3.process()
