trait Functor[F[_]] {
	def map[A,B](fa: F[A])(f: A => B): F[B]
}

object OptionFunctor extends Functor[Option] {
	override def map[String, Int](fa: Option[String])(f:String => Int): Option[Int] = {
		Some(f(fa get))
	}
}

println(OptionFunctor.map(Some("Sandeep"))(_.length))