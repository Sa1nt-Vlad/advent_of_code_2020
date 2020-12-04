package TextReader

import scala.io.Source

class TextReader {
	def readAllLines(path: String) : Seq[String] = {
		var result = Seq.empty[String]
		val source = Source.fromFile(path)
		source.getLines.foreach(line => result :+= line)
		source.close()
		
		result
	}
}