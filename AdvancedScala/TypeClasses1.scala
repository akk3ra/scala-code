trait Person[T] {
	def getInfo(x:T):String
}
object DefaultPeople {
	implicit val employee = new Person[String] {
		override def getInfo(x: String) = s"I am a person.. $x"
	}
	implicit val machine = new Person[Int] {
		override def getInfo(x: Int) = s"I am a machine .. $x"
	}
}

object TypeClassClient {
	implicit class Resource[T](y: T) {
		def processInfo()(implicit x: Person[T]) {
			println(x.getInfo(y))
		}
	}
}

import DefaultPeople._
import TypeClassClient._

"Sandeep" processInfo()
23 processInfo()