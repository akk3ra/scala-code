class MyClass[T](private val x:List[T]) {
	def head:T = x.head
	def tail:List[T] = x.tail
}
object MyClass{
	def apply[T](x:T*):MyClass[T] = new MyClassImpl[T](x.toList)
	class MyClassImpl[T](private val x:List[T]) extends MyClass[T](x) {
	   //def head:T = x.head
	   //def tail:List[T] = x.tail 
	}
}
class MyClassImpl2[T](private val x:List[T]) extends MyClass[T](x)
object MyClassImpl2 {
	def apply[T](x:T*) = new MyClassImpl2[T](x.toList)
}
def main(val args:Array[T]) {
	//val x = MyClass(2,3,4,5)
	val x = args(1)
	println(x.head)
	println(x.tail)

	//val y = MyClassImpl2(4,5,6,7)
	val y = args(2)
	println(y.head)
	println(y.tail)
}
