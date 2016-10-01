trait Behavior[A] {
	def tellMe(x:A):A
}

object Behavior {
	implicit val xBehavior = new Behavior[String] {
		override def tellMe(x:String):String = s"Hey there $x"
	}
	implicit val yBehavior = new Behavior[Int] {
		override def tellMe(x:Int):Int = {print("I am an Int..");1}
	}
}

object BehaviorLib {

	implicit class BehaviorImplClass[A](x:A) {

		def processInfo()(implicit someBehavior:Behavior[A]) {
			println(someBehavior tellMe(x))
		}
	}
}

import Behavior._
import BehaviorLib._

"Sandeep" processInfo()
1 processInfo()