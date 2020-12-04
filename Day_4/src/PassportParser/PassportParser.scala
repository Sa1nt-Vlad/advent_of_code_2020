package PassportParser

import Passport.Passport
import TextReader.TextReader
import scala.collection.mutable.ArrayBuffer

class PassportParser {
	def parseFromFile(path: String): Seq[Passport] = {
		val textReader = new TextReader()
		val input = textReader.readAllLines(path)
		val result = ArrayBuffer.empty[Passport]
		var currentFields = ArrayBuffer.empty[(String, String)]
		
		for(line <- input){
			if (line.length == 0){
				result += Passport(currentFields.toSeq)
				currentFields = ArrayBuffer.empty[(String, String)]
			}
			else getFieldsFromLine(line).foreach(pair => {
				val res = (pair._1, pair._2)
				currentFields += res
			})
		}
		
		result.toSeq
	}
	
	private def getFieldsFromLine(line: String): Seq[(String, String)] = {
		val result = ArrayBuffer.empty[(String, String)]
		val values = line.split(' ')
		for(value <- values){
			val parts = value.split(':')
			val s = (parts(0), parts(1))
			result += s
		}
		
		result.toSeq
	}
}
