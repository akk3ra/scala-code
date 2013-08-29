abstract class Persistence {
	def insert(): Unit
	def update(): Unit
	def delete(): Unit
}

class PersistenceImpl(x:PersistenceImplementer) extends Persistence{
	val pi = x
	def insert(): Unit = println(x.insert()+" -->>"+pi.getPerType())
	def update(): Unit = println(x.update()+" -->>"+pi.getPerType())
	def delete(): Unit = println(x.delete()+" -->>"+pi.getPerType())
} 

abstract class PersistenceImplementer {
	//Here this variable 'perType' has to be initialized otherwise the subclasses will not be able to access it
	var perType:String = ""
	def insert(): String
	def update(): String
	def delete(): String
	def getPerType(): String = perType
}

	
class OraclePersistenceImpl extends PersistenceImplementer{
	perType = "OraclePersistence"
	def insert(): String = "O: Inserted Using"
	def update(): String = "O: Updated Using"
	def delete(): String = "O: Deleted Using"
}
class SybasePersistenceImpl extends PersistenceImplementer{
	perType = "SybasePersistence"
	def insert(): String = "S: Inserted Using"
	def update(): String = "S: Updated Using"
	def delete(): String = "S: Deleted Using"
}

object BridgeTest {
	
	val p1:Persistence = new PersistenceImpl(new OraclePersistenceImpl)
	val p2:Persistence = new PersistenceImpl(new SybasePersistenceImpl)
		
	def display(): Unit = {
		p1.insert()
		p1.update()
		p1.delete()
		
		p2.insert()
		p2.update()
		p2.delete()
	}
	
}

BridgeTest.display()
