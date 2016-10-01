trait MonoidList[String] {
	def compose(x: List[String], y:List[String]):List[String]
	def empty:List[String]
}

object DefaultLists {

	implicit val stringListMonoid = new MonoidList[String] {
		def compose(x: List[String], y:List[String]):List[String] = {
			for {
				a <- x;
				b <- y;
				
				
			}
		}
		def empty:List[String] = Nil
	}
}