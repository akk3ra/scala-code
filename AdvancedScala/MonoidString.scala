trait Monoid[A] {
	def compose(x:A, y:A):A
	def empty:A
}

object DefaultMonoids {
	implicit val stringMonoid = new Monoid[String] {
		override def compose(x:String, y:String) = s"$x$y"
		override def empty = ""
	}
}

object StringLibrary {

	def combileAll(list: List[String])(implicit stringMonoid:Monoid[String]):String = {
		list.foldLeft(stringMonoid.empty)((a,b) => stringMonoid.compose(a,b))
	}

}

object TestClient {

	def testClient {

		import DefaultMonoids._
		import StringLibrary._

		println(StringLibrary.combileAll("Sandeep"::"Kumar"::"Akkera"::Nil))
	}
}
TestClient.testClient