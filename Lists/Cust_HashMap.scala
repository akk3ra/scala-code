trait MyHashMap[K,V] {
	def get(key:K):V
	def put(key:K,value:V):MyHashMap[K,V]
	def size:Int
	def keyList:List[K]
	def valueList:List[V]
}
object MyHashMap {
	def apply[K,V](tup:Tuple2[K,V]*):MyHashMap[K,V] = new MyHashMapImpl[K,V](tup.toList)

	class MyHashMapImpl[K,V](var list:List[Tuple2[K,V]]) extends MyHashMap[K,V] {
		def get(k:K):V = (list find(x=>x._1==k)) match {
			case Some(x)=>x._2
		}
		def put(key:K,value:V):MyHashMap[K,V] = {
				list::=Tuple2[K,V](key,value)
				new MyHashMapImpl[K,V](list)
			}
		def size = list.length
		def keyList:List[K] = list map(x=>x._1)
		def valueList:List[V] = list map(x=>x._2)
	}
}

object TestMap {

	def testMap {

		val myMap = MyHashMap[Int,String]((1,"Sandeep"), (2, "Deepika"), (3, "Ashhok"), (4, "Sadhanna"))
		println(myMap.size)
		println(myMap.get(3))
		println(myMap.keyList)
		println(myMap.valueList)
		println(myMap.put(5,"Iisha").size)
	}
}
TestMap.testMap
