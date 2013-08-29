val list = List[String]("Sandeep", "Akkera", "Sravani", "Mekala", "Deepika", "Sandanaboina")
def listMatch(matches:String=>Unit): Unit= {
	
	matches(list(0))
}

listMatch(x=>if(x.endsWith("eep")) println("yes"))
