
def scalaFiles = {
	val x = List[String]("Sandeep","Akkera", "Sadhana", "Ashok", "Sravani", "Sathish")
	 for{
	     file <- x
	   } yield file
   }
println(scalaFiles.length)
