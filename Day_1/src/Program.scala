import NumberFinder.NumberFinder
import TextReader.TextReader;

object Program extends App {
	val textReader = new TextReader()
	val numbers = textReader
	  .readAllLines("D:\\Projects Scala\\advent_of_code_2020\\Day_1\\src\\Input.txt")
	  .map(number => Integer.parseInt(number))
	
	val finder = new NumberFinder()
	val resultOf2 = finder.get2NumberOf2020Sum(numbers)
	val resultOf3 = finder.get3NumberOf2020Sum(numbers)
	println("2020 = sum of" + resultOf2)
	println("2020 = sum of" + resultOf3)
}
