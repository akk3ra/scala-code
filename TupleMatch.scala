def tupleMatch = {
	val tup1 = ("Sandeep", 29, "is a good boy")
	val tup2 = ("Sravani", 28, "is a good girl")
	for(tup<- List(tup1, tup2)) {
		tup match {
			case (firstThing, _,_) => println("The first thing inside the tuple is -->>"+firstThing)
			case (_, secondThing, _) => println("The second thing on the tuple is-->>"+secondThing)
		}
	}
}
tupleMatch
