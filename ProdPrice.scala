
abstract class Prod {
	
	def getPrice(): Int
}

class Part1(n:String, p:Int) extends Prod {
	
	val name = n
	val price:Int = p
	def getName(): String = name
	def getPrice(): Int = price
}

class Computer(n:String) extends Prod {
	val name = n
	def getName():String = name
	var prodList = List[Prod]()	
	def +(x:Prod): Unit = prodList::=x
		
	def getPrice(): Int = calcPrice(x=> {
					var pri = 0
					for(lst<-x) pri+=lst.getPrice()
					pri
					},
					y=>{
					var cou = 0
					for(lst<-y) cou+=1
					cou*10
					}
					)

	private def calcPrice(f:(List[Prod])=>Int, d:(List[Prod])=> Int) = {
			
		f(prodList)+d(prodList)
	}
} 

object CompTest {

def process(){	
	val kb = new Part1("KeyBoard", 10)
	val mou = new Part1("Mouse", 5)
	val cpu = new Part1("Processor", 100)
	val mb = new Part1("MotherBoard", 100)

	println(kb.getName+"-->>"+kb.getPrice())
	println(mou.getName+"-->>"+mou.getPrice())
	println(cpu.getName+"-->>"+cpu.getPrice())
	println(mb.getName+"-->>"+mb.getPrice())
	
	val comp = new Computer("Lenovo")
	comp+kb
	comp+mou
	comp+cpu
	comp+mb
	
	println("---Price of computer including taxes---")
	println(comp.getName()+"-->>"+comp.getPrice())
   }
}

CompTest.process()




