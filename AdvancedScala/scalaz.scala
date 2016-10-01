trait Monoid[T] {
	def compose(a:T, b:T):T
	def zero:T
}

trait FoldLeft[T {
	def foldLeft(initVal:T, f:(A,B) => B) = {
		
	}
}

object DefaultImpls {
	implicit object ListMonoid extends Monoid[String] {
		override def compose(a:String, b:String):String = a+b
		override def zero:String = ""
	}
}

object MyClient {
	implicit class ListImpl[T](xs:List[T]) {
		def myJoinString()(implicit monoid:Monoid[T]):T = {
			xs.foldLeft(monoid.zero)(monoid.compose)
		}
	}

	def joinStrings(xs:List[String])(implicit strMonoid:Monoid[String]):String = {
		xs.foldLeft(strMonoid.zero)(strMonoid.compose)
	}
}

import DefaultImpls._
import MyClient._

println(MyClient.joinStrings("1"::"2"::Nil))

println(("Sandeep"::" Kumar"::" Akkera"::Nil) myJoinString())