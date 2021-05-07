package hm.binkley.labs.curious

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MainTest {
    @Test
    fun `should output correctly`() {
        val out = tapSystemOutNormalized {
            main()
        }

        assertEquals(
            """
== FIRST, BOB'S TURN
HOOK VALUE -> 1
I AM A BOB!
HOOK VALUE -> 1
== NOW, NANCY'S TURN
HOOK VALUE -> 2
NANCY IS FANCY!
HOOK VALUE -> 2
""".trimStart(),
            out
        )
    }
}
