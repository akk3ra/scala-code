object TestPatMat2 {	
	val prods = List("Sandeep", 23, 44.6)
	def process {
		for(prod<-prods){
			
			prod match {
				case s:String => println("Found a string named-->>"+s)
				case i:Int => println("Found an integer-->>"+i)
				case f:Float => println("Found a float-->>"+f)
				case _ => println("This type is not found--  !! :( :( ")
			}
		}
		
	}
}
TestPatMat2.process
