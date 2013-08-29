trait Queue[T] {
	def push(x:T) :Queue[T]
	def pop: Queue[T]
	def isEmpty:Boolean
}
object Queue {
	def apply[T](xs:T*):Queue[T] = new QueueImpl[T](xs.toList)
	class QueueImpl[T](xs:List[T]) extends Queue[T] {
		
		def push(x:T):Queue[T] = new QueueImpl[T](x::xs)
		def pop:Queue[T] = new QueueImpl[T](xs.tail)
		def isEmpty:Boolean = xs.length==0
		override def toString = xs.toString
	}
}
object MyTest {
	def myTest {
		val q1 = Queue[Int](2,3,4,5)	
		println(q1.toString)
		val q2 = q1.pop.pop
		println(q2)
		println(q2.push(20))
	}
}
MyTest.myTest
