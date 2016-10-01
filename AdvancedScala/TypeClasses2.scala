trait DAO[T] {
	def insert(x:T):Unit
	def update(x:T):Unit
	def delete(x:T):Unit
}
object DefaultDAO {
	implicit val oracleDAO = new DAO[String] {
		def insert(x:String):Unit = println(x)
		def update(x:String):Unit = println(x)
		def delete(x:String):Unit = println(x)
	}
	implicit val DB2DAO = new DAO[Int] {
		def insert(x:Int):Unit = println(x)
		def update(x:Int):Unit = println(x)
		def delete(x:Int):Unit = println(x)
	}
}
object TestClient {
	implicit class TestDAO[T](y:T) {
		def processData()(implicit x:DAO[T]) = {
			x.insert(y)
		}
	}
}

import DefaultDAO._
import TestClient._

"Message" processData()
23 processData()



