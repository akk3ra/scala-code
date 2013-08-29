trait MyMap[K,V]{
	def +(k:K,v:V):MyMap[K,V]
	def get(x:K):V
	def keys:List[K]
	def values:List[V]
	def length:Int
}
object MyMap {
	def apply[K,V](x:Tuple2[K,V]*): MyMap[K,V] = new MyMapImpl[K,V](x.toList);
	class MyMapImpl[K,V](xs:List[Tuple2[K,V]]) extends MyMap[K,V] {
			def +(k:K,v:V):MyMap[K,V] = new MyMapImpl[K,V](Tuple2(k,v)::xs)
			def get(k:K):V = (xs find (m=>m._1==k)) match {
									case Some(x) => x._2
								}
			def keys:List[K] = xs map (m=>m._1)
			def values:List[V] = xs map (m=>m._2)
			def length = xs length
	}
}
def myTest {
	var x = MyMap((1,2),(3,4),(33,56))
	println(x  get 33)

	x += (33,44)
	println(x get 33)
	
	println("Keys-->>"+x.keys.toString)
	println("Values-->>"+x.values.toString)
	println("Length-->>"+x.length)
	
	var y = MyMap(("Sandeep","Deepika"),("Sathish","Sravani"),("Kamaraj","Harika"),("Harsha","Shravanthi"))

	println(y length)
	println(y keys)
	println(y values)
	println(y get ("Kamaraj"))

}
myTest




