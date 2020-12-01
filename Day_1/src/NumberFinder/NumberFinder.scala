package NumberFinder

class NumberFinder {
	def get2NumberOf2020Sum(numbers: Seq[Int]): (Int, Int) = {
		var factor1 = 0
		var factor2 = 0
		
		for (num <- numbers)
			for (num2 <- numbers)
				if (num + num2 == 2020){
					factor1 = num
					factor2 = num2
				}
		
		(factor1, factor2)
	}
	
	def get3NumberOf2020Sum(numbers: Seq[Int]): (Int, Int, Int) = {
		var factor1 = 0
		var factor2 = 0
		var factor3 = 0
		
		for (num <- numbers)
			for (num2 <- numbers)
				for (num3 <- numbers)
					if (num + num2 + num3 == 2020){
						factor1 = num
						factor2 = num2
						factor3 = num3
					}
		
		(factor1, factor2, factor3)
	}
}
