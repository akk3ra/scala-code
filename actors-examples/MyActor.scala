import scala.actors._
import scala.actors.Actor._

object MyActor extends Actor {
	
	def act(){
	
		loop{
			receive{
				
				case x:Shape => x.draw()
				
			}
		}
	}
}


