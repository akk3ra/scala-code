import scala.util.Either

object TestEither {

	def testEither: Either[Exception, Long] = {
		val source = Math.round(Math.random * 100)
		if (source <= 60) Right(source)
		else Left(new Exception("The generated number is too big!"))
	}

	def testEither1(x: Int): Either[Exception, String] = {

		if(x > 4) Right("Sandeep")
		else Left(new Exception("Hey You got me !!!!"))
	}
}

println(TestEither.testEither)
println(TestEither.testEither1(3))

