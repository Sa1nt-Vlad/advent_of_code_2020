import java.nio.file.Paths

import NumberFinder.NumberFinder
import TextReader.TextReader

object Program extends App {
	val textReader = new TextReader()
	val numbers = textReader
	  .readAllLines(Paths.get("src", "input.txt").toString)
	  .map(number => Integer.parseInt(number))
	
	val finder = new NumberFinder()
	val resultOf2 = finder.get2NumberOf2020Sum(numbers)
	val resultOf3 = finder.get3NumberOf2020Sum(numbers)
	
	println("2020 = sum of " + resultOf2.getOrElse("nothing found :("))
	println("2020 = sum of " + resultOf3.getOrElse("nothing found :("))
}
