// Problem 1
println("--Problem 1--")
println(List(1,8,3,9,5,34,27,80,345).reverse.head)
println(List(1,8,3,9,5,34,27,80,345).last)
println("--Problem 2--(Penultimate value)")

val penul = List(89,45, 23,3, 129, 983)
println(penul.init.last)

println("--Problem 3--(Kth element)")
val kaeth = List(89,45, 23,3, 129, 983)
println(kaeth.toString)
println("4th-->"+kaeth(3))
println("2nd-->"+kaeth(1))

println("--Problem 4--(Length)")
println(kaeth.toString)
println("Length is -->"+kaeth.length)

println("--Problem 5--<Find out if it is a Palindrome>")
def palindrome(x:List[Int]):Boolean = {
val l1 = x
val l2 = x.reverse
	for(i <- 0 to l1.length-1) 
	if(l1(i)!=l2(i)) return false
	true
}
println("Palindrome??==List(1,3,5,7,5,3,1)")
println(palindrome(List(1,3,5,7,5,3,1)))
println("Palindrome??==List(1,3,5,7,55,3,1)")
println(palindrome(List(1,3,5,7,55,3,1)))
println("--Problem 6--(Flatten nested List)")

println(List.flatten(List(List(1,2,3,4),List(7,8,9,10))))

//println("--Problem 7--")
//println("--Problem 8--")
//println("--Problem 9--")
//println("--Problem 10--")
//println("--Problem 11--")
//println("--Problem 12--")
//println("--Problem 13--")
//println("--Problem 14--")
//println("--Problem 15--")
