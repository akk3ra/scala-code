object MyLookup {
	import collection.mutable.HashMap
	val myLukup = HashMap("Sandeep" -> 1, "Akkera" -> 2, 3 -> "Ashok")
	def getInfo(x: Any) = myLukup.get(x)
}
object MyImplicit {
	implicit class Details(x: Any) {
		def myDet(f:Any => Unit) = f(MyLookup.getInfo(x).getOrElse("VALUE NOT FOUND.."))
	}
}

import MyImplicit._

"Sandeep" myDet println
3 myDet println
"Random" myDet println