package smallestpossiblesum

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SmallestPossibleSumKtTest {

    @Test
    fun `one number only`() {
        solution(longArrayOf(3)) shouldBe 3
    }

    @Test
    fun `two numbers not coprime`() {
        solution(longArrayOf(5, 17)) shouldBe 2
    }

    @Test
    fun `two numbers coprime`() {
        solution(longArrayOf(11, 22)) shouldBe 22
    }

    @Test
    fun `all numbers are equal`() {
        solution(longArrayOf(3, 3, 3)) shouldBe 9
    }

    @Test
    fun `five numbers not coprime`() {
        solution(longArrayOf(3,13,23,7,83)) shouldBe 5
    }
}
