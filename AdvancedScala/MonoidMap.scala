trait MapMonoid[A,B] {
	def compose(x: Map[A,B], y:Map[A,B]): Map[A,B]
	def empty: Map[A,B]
}

object DefaultMapMonoid {

	implicit val mapMonoid = new MapMonoid[String, Int] {

		override def compose(x: Map[String, Int], y: Map[String, Int]): Map[String, Int] = {
			(for {
				(a1, b1) <- x
				(a2, b2) <- y
				myKey = a1
				myVal = b1+b2
				if(a1.equalsIgnoreCase(a2))
			}yield (myKey -> myVal)) toMap
		} 

		override def empty: Map[String, Int] = Map("" -> 0)
	}
}
object MapLibrary {

	def combineAllMaps(listOfMaps: List[Map[String, Int]])(implicit mapMonoid:MapMonoid[String, Int]): Map[String, Int] = {
		listOfMaps.foldLeft(mapMonoid.empty)((mapA, mapB) => {
				println("------")
				mapMonoid.compose(mapA,mapB)
			})
	}
}
object MapClient {
	def testMapClient {
		import DefaultMapMonoid._
		import MapLibrary._
		val mapList:List[Map[String, Int]] = List(Map("Sandeep"->1), Map("Sandeep"->2), Map("Akkera"->3))
		val finalList = MapLibrary.combineAllMaps(mapList)
		println("Printing items..."+finalList.size)
		for((key, value) <- finalList) {
			println (key+" -> "+value+"\n")
		}
	}
}
MapClient.testMapClient