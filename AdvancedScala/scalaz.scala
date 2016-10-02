trait Monoid[T] {
	def compose(a:T, b:T):T
	def zero:T
}

object DefaultImpls {
	implicit object ListMonoid extends Monoid[String] {
		override def compose(a:String, b:String):String = a+b
		override def zero:String = ""
	}
	implicit val intMonoid:Monoid[Int] = new Monoid[Int] {
		override def compose(a:Int, b:Int):Int = a+b
		override def zero:Int = 0
	}
}

trait Identity[A] {
	val value:A
	def plus(a:A)(implicit monoid:Monoid[A]):A = monoid.compose(value,a)
}

object MyClient {

	implicit def toIdent[A](a:A):Identity[A] = new Identity[A]{
		val value = a
	}

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

println(3.plus(4))

println(MyClient.joinStrings("1"::"2"::Nil))

println(("Sandeep"::" Kumar"::" Akkera"::Nil) myJoinString())