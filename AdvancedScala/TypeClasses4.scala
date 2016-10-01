trait MyInfo[T] {
	def getInfo(x:T):T
}
class MyObject(val a:String)

object DefaultInfos {
	implicit object MyString extends MyInfo[String] {
		override def getInfo(x:String):String = s"This is $x here.."
	}
	implicit val someObj = new MyInfo[MyObject] {
		override def getInfo(x:MyObject):MyObject = new MyObject(a = "Sandeep")
	}
}
object MyMain{
	implicit class MyPlaceHolder[T] (x:T) {
		def getMyInfo()(implicit c:MyInfo[T]) = {
			x match {
				case l: String => println(c.getInfo(x))
				case m: MyObject => println(c.getInfo(x))
				case _ => println("Unknown value found..")				
			}
		}
	}
}
import DefaultInfos._
import MyMain._

"Sandeep" getMyInfo()
(new MyObject("Sandeep")) getMyInfo()