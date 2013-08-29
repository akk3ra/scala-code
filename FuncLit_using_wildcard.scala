val list = List[String]("Sandeep", "Pradeep", "Deepika", "Avantika", "Sravani", "Pavani")

def filesMatching(query:String, matches:(String, String)=>Boolean): List[String] = {
		
		for(name<-list if(matches(name, query))) yield name
}

var list1 = filesMatching("van", _.contains(_))

println(list1(0)+" & "+ list1(1))


