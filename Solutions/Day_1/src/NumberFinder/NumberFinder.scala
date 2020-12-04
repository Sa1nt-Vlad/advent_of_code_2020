package NumberFinder

class NumberFinder {
	def get2NumberOf2020Sum(numbers: Seq[Int]): Option[(Int, Int)] = {
		numbers.foreach(num1 =>
			  numbers.foreach(num2 =>
			    if(num1 + num2 == 2020)
				    return Some(num1, num2)))
		None
	}
	
	def get3NumberOf2020Sum(numbers: Seq[Int]): Option[(Int, Int, Int)] = {
		numbers.foreach(num1 =>
			numbers.foreach(num2 =>
				numbers.foreach(num3 =>
					if (num1 + num2 + num3 == 2020)
						return Some(num1, num2, num3))))
		None
	}
}
