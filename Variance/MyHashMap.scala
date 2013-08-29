trait MyMap[K,V] {
	def get(x:K):V
	def +(x:K, y:V):Boolean
	def isEmpty:Boolean
	def keys:List[K]
	def values:List[V]
}
object MyMap{
	def apply[K,V](x:Tuple2[K,V]*):MyMap[K,V] = new MyMapImpl[K,V](x.toList)
	class MyMapImpl[T,M](var myMap:List[Tuple2[T,M]]) extends MyMap[T,M] {
		def get(x:T):M = {
			for((key,value)<-myMap) {
				if(key==x) 
				return value
			}
			throw new Exception("Value not found!!!")
		}
		def +(x:T,y:M):Boolean = {
			for((key,value)<-myMap){
				if(key==x)
				return false
			}
			myMap::=Tuple2(x,y)
			true
		}
		def isEmpty:Boolean = if (myMap.length==0) true else false
		def keys:List[T] = for((key,value)<-myMap) yield {key}
		def values:List[M] = for((key,value)<-myMap) yield {value}
	}
}
def myTest {
	val myMap1 = MyMap((1,"Sandeep"),(2,"Praveen"),(3,"Vikas"),(4,"Suresh"))
	println(myMap1.get(3))
	println(myMap1.keys)
	println(myMap1.values)
	println(myMap1+(5,"Pranay"))
	println(myMap1.keys)
	println(myMap1.values)
//	println(myMap1.toSeq)
}	
myTest
