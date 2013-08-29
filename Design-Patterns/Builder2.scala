class Book() {
	var name:String = ""
	var price:Int = 0
	
	def getName(): String = name
	def getPrice(): Int  = price
}
abstract class BookBuilder {
	var book:Book = null
	def createBook() = book = new Book()
	def getBook(): Book = book
	def buildPages(): Unit
	def buildCover():Unit
	def bindBook():Unit
}
class NoteBookBuilder extends BookBuilder {
	def buildPages() = println("Building note book pages")
	def buildCover() = println("Building note book cover")
	def bindBook() = println("Binding note book")
}
class TextBookBuilder extends BookBuilder {
	def buildPages() = println("Building text book pages")
	def buildCover() = println("Building text book cover")
	def bindBook() = println("Binding text book")
}
class SlamBookBuilder extends BookBuilder {
	def buildPages() = println("Building slam book pages")
	def buildCover() = println("Building slam book cover")
	def bindBook() = println("Binding slam book")
}
class Binder {
	var bb:BookBuilder = null
	def setBookBuilder(bb:BookBuilder) = this.bb = bb
	def buildBook() {
		bb.createBook()
		bb.buildPages()
		bb.buildCover()
		bb.bindBook()
	}
	def getBook(): Book = bb.getBook()
}
object Builder2Test{
	def process() {
		val b = new Binder
		b.setBookBuilder(new TextBookBuilder)
		b.buildBook()
		b.setBookBuilder(new NoteBookBuilder)
		b.buildBook()
		b.setBookBuilder(new SlamBookBuilder)
		b.buildBook()
	}	
}
Builder2Test.process()
