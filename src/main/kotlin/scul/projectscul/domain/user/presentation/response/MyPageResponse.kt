package scul.projectscul.domain.user.presentation.response

import scul.projectscul.domain.user.domain.Enum.Tier
import scul.projectscul.domain.user.domain.User

data class MyPageResponse (
        val score: Int,
        val name: String,
        val tier: Tier
) {
    companion object {
        fun of(currentUser: User) : MyPageResponse {
            return MyPageResponse(
                    score = currentUser.score,
                    name = currentUser.name,
                    tier = currentUser.tier
            )
        }
    }
}
