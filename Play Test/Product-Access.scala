
case class Product extends Table[Long, String, String]("products") {


	def ean = column[Long]("ean")
	def name = column[String]("name")
	def description = column[String]("description")

	def * = ean ~ name ~ description
}

query:String = "select * from Products group by name, ean"

val products:List[Product] = query.execute


for(product <- products.sortBy(_.ean)) {
	}yield(product.ean, product.name, product.description)