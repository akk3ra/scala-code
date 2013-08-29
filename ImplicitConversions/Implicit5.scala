class Publication(val name:String)
class Book(override val name:String) extends Publication(name)

object ProcessValues {
	val books:Set[Book] = Set(new Book("Programming Scala by Martin Odersky"), new Book("Scala for the impatient"))
	def processValues(f:(Book)=>AnyRef) {
		for(book<-books) {
			println(f(book))
		}
	}
}
ProcessValues.processValues(_.name)
