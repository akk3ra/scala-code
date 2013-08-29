trait MyQueue[T]{
	def head: T
	def tail: List[T]
}
object MyQueue{
	def apply[T](x:T*):MyQueue[T] = new MyQueueImpl[T](x.toList)
	private class MyQueueImpl[T](private val x:List[T]) extends MyQueue[T]{		
		def head:T = x.head
		def tail:List[T] = x.tail
	}
}
def myTest {
	val list = MyQueue(1,2,3,4,5)
	println(list.head)
	println(list.tail)
}
myTest
