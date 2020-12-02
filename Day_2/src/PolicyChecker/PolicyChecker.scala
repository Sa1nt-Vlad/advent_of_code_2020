package PolicyChecker

import Policy.Policy

trait PolicyChecker {
	def checkPolicy(policy: Policy, password: String): Boolean
}
