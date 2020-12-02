package PolicyChecker

import Policy.Policy

class PositionChecker extends PolicyChecker {
	def checkPolicy(policy: Policy, password: String): Boolean =
		password(policy.firstCheckParam - 1) == policy.requiredSign &&
	        password(policy.secondCheckParam - 1) != policy.requiredSign ||
	    password(policy.firstCheckParam - 1) != policy.requiredSign &&
	        password(policy.secondCheckParam - 1) == policy.requiredSign
}
