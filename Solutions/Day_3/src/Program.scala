import java.nio.file.Paths
import java.math.BigInteger
import TextReader.TextReader

object Program extends App{
	val textReader = new TextReader()
	val map = textReader.readAllLines(Paths.get("src", "input.txt").toString)
	
	var result: BigInt = calculateTreesCount(map, 3, 1) * calculateTreesCount(map, 1, 1)
	result *= calculateTreesCount(map, 5, 1) * calculateTreesCount(map, 7, 1)
	result *= calculateTreesCount(map, 1, 2)
	
	println(result)
	
	def calculateTreesCount(map: Seq[String], stepX: Int, stepY: Int): Int = {
		val width = map.head.length
		var x = 0
		var y = 0
		var treesCount = 0
		
		while(y < map.length){
			if (map(y)(x) == '#')
				treesCount += 1
			x = (x + stepX) % width
			y += stepY
		}

		treesCount
	}
}
