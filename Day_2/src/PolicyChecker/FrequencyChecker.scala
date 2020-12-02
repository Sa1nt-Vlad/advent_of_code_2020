package PolicyChecker
import Policy.Policy

class FrequencyChecker extends PolicyChecker {
	def checkPolicy(policy: Policy, password: String): Boolean = {
		val signFrequency = scala.collection.mutable.Map[Char, Int]()
		for(sign <- password)
			if (signFrequency.contains(sign))
				signFrequency(sign) += 1
			else signFrequency.put(sign, 1)
		
		signFrequency.contains(policy.requiredSign) &&
		  signFrequency(policy.requiredSign) >= policy.firstCheckParam &&
			signFrequency(policy.requiredSign) <= policy.secondCheckParam
	}
}
