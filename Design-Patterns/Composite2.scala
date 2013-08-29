abstract class Funds{
	var price:Int = 0	
	def getPrice:Int
}
class FundGroup extends Funds {
	
	var fundList:List[Funds] = List()
	def +(x:Funds) = fundList::=x
	override def getPrice:Int = {
		fundList foreach (price+=_.getPrice)
		price
	}
} 
class Fund(price:Int) extends Funds {
	override def getPrice:Int = price	
}
object myTest {
	
	var funds = new FundGroup
	funds + new Fund(1)
	funds + new Fund(2)
	funds + new Fund(3)
	funds + new Fund(100)
	println (funds.getPrice)
}
myTest
