package scul.projectscul.domain.user.presentation.response

import scul.projectscul.domain.user.domain.Enum.Tier
import scul.projectscul.domain.user.domain.User
import java.util.UUID

data class MyPageResponse (
        val userId: UUID?,
        val score: Int,
        val name: String,
        val tier: Tier,
        val profileImage: String
) {
    companion object {
        fun of(currentUser: User) : MyPageResponse {
            return MyPageResponse(
                    userId = currentUser.id,
                    score = currentUser.score,
                    name = currentUser.name,
                    tier = currentUser.tier,
                    profileImage = currentUser.profileImage
            )
        }
    }
}
