trait MyStack[T] {
	def push(x:T):MyStack[T]
	def pop:MyStack[T]
	def isEmpty:Boolean
	def toList:List[T]
//	def top:T
}
object MyStack {
	def apply[T](x:T*) = new MyStackImpl[T](x.toList)
	class MyStackImpl[M](xs:List[M]) extends MyStack[M] {
		def push(x:M):MyStack[M] = new MyStackImpl[M](x::xs)
		def pop:MyStack[M] = new MyStackImpl[M](xs.tail)
		def isEmpty:Boolean = xs.length==0
		def toList:List[M] = xs
	}
}
def myTest{
	val myStack1 = MyStack[Int](1,2,3,4,5)
	println(myStack1.toList)
	println(myStack1.push(10).toList)
	println(myStack1.pop.toList)	
	println(myStack1.push(10).push(56).push(46).toList)
}
myTest
