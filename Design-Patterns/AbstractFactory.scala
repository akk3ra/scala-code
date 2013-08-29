abstract class DAOFactory {
	def getAccountDAO() : GenericDAO
	def getOrderDAO() : GenericDAO 
}
class OracleDAOFactory extends DAOFactory {
	
	def getAccountDAO() : GenericDAO = {
		val dao:GenericDAO = new AccountDAO
		dao
	}
	def getOrderDAO() : GenericDAO = {
		val dao:GenericDAO = new OrderDAO
		dao
	}
}
class DB2DAOFactory extends DAOFactory {
	
	def getAccountDAO() : GenericDAO = {
		val dao:GenericDAO = new AccountDAO
		dao
	}
	def getOrderDAO() : GenericDAO = {
		val dao:GenericDAO = new OrderDAO
		dao
	}
}
abstract class GenericDAO {
//	val x:String
	def insert(): Unit
	def update(): Unit
	def delete(): Unit
}
class AccountDAO extends GenericDAO {
	def insert(): Unit = println("Calling Insert account")
	def update(): Unit = println("Calling Update account")
	def delete(): Unit = println("Calling Delete account")	
}
class OrderDAO extends GenericDAO {
	def insert(): Unit = println("Calling Insert order")
	def update(): Unit = println("Calling Update order")
	def delete(): Unit = println("Calling Delete order")	
}
object DAOFactory{
	def getInstance(x:Int) : DAOFactory = {
		var daoF:DAOFactory = null
		if(x==1) daoF = new OracleDAOFactory
		else if(x==2) daoF = new DB2DAOFactory
		daoF	
	}
}
object AbsFactTest {
	
	def testAbs(): Unit = {
		val fact:DAOFactory = DAOFactory.getInstance(1)
		val dao1:GenericDAO = fact.getAccountDAO()
		dao1.insert()
		dao1.update()
		dao1.delete()
		
		val fact2:DAOFactory = DAOFactory.getInstance(2)
		val dao2:GenericDAO = fact2.getAccountDAO()
		dao2.insert()
		dao2.update()
		dao2.delete()		
		
	}
}

AbsFactTest.testAbs()

