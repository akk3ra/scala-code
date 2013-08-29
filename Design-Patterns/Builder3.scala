class Room(var bed:String, var paint:String, var wardrobe:String)

trait RoomBuilder {
	var room:Room = new Room("","","")
	def buildRoom:Room 
}

class LuxuryRoomBuilder extends RoomBuilder{
	
	private def createBed:Unit = room.bed = "Luxury Bed"
	private def paintWall:Unit = room.paint = "Luxury Paint"
	private def makeWardrobe:Unit = room.wardrobe = "Luxury Wardrobe"

	def buildRoom:Room = {
		createBed
		paintWall
		makeWardrobe
		room
	}
}
class DeluxeRoomBuilder extends RoomBuilder{
	
	private def createBed:Unit = room.bed = "Deluxe Bed"
	private def paintWall:Unit = room.paint = "Deluxe Paint"
	private def makeWardrobe:Unit = room.wardrobe = "Deluxe Wardrobe"

	def buildRoom:Room = {
		createBed
		paintWall
		makeWardrobe
		room
	}
}

object myTest {

	var rb:RoomBuilder = new LuxuryRoomBuilder
	val lr = rb.buildRoom
	
	println("BED-->"+lr.bed)
	println("PAINT-->"+lr.paint)
	println("WARDROBE-->"+lr.wardrobe)
	rb = new DeluxeRoomBuilder
	val dr = rb.buildRoom

	println("BED-->"+dr.bed)
	println("PAINT-->"+dr.paint)
	println("WARDROBE-->"+dr.wardrobe)

}
myTest

