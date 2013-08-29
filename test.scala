
class Upper {
	def upper(strings:String*):Seq[String]={
		
		strings.map((s:String)=>s.toUpperCase())
	}
}

val word = new Upper
Console.println(word.upper("A", "Program", "In", "Scala"))


