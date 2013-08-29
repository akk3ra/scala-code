class Publication(val title:String)
class Book(override val title:String) extends Publication(title)
object ProcessBooks {
	val books:Set[Book] = Set(new Book("Programming Scala by Martin Odersky"), new Book("Scala for the impatient"))
	def processBooks(f:(Book)=>AnyRef){	
		for(book<-books){
			println(f(book))
		}
	}
	def display(x:Publication):String = x.title
}
def display(x:Publication):String = x.title
ProcessBooks.processBooks(display)

ProcessBooks.processBooks(_.title)
