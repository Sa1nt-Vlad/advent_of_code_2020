package PolicyParser

import Policy.Policy

class PolicyParser {
	def getPolicy(string: String): Policy = {
		val policyParts = string
		  .split(Array(' ', ':'))
		  .filter(part => part.length > 0)
		val borders = getBorders(policyParts(0))
		val requiredLetter = policyParts(1)(0)
		Policy(requiredLetter, borders._1, borders._2)
	}
	
	private def getBorders(string: String): (Int, Int) = {
		val parts = string.split('-').map(num => Integer.parseInt(num))
		(parts(0), parts(1))
	}
}
