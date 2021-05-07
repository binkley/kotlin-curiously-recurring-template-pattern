package hm.binkley.labs.curious

fun main() {
    println("== FIRST, BOB'S TURN")
    Bob().someFluentMethodInBase()
        .bobDoesSomethingParticular()
        .someFluentMethodInBase()
    println("== NOW, NANCY'S TURN")
    Nancy().someFluentMethodInBase()
        .nancyDoesSomethingParticular()
        .someFluentMethodInBase()
}

abstract class Curious<B : Curious<B>>(
    private val hookValue: Int,
) {
    @Suppress("UNCHECKED_CAST")
    protected val self: B
        get() = this as B

    fun someFluentMethodInBase(): B {
        println("HOOK VALUE -> $hookValue")
        return self
    }
}

class Bob : Curious<Bob>(hookValue = 1) {
    fun bobDoesSomethingParticular(): Bob {
        println("I AM A BOB!")
        return this
    }
}

class Nancy : Curious<Nancy>(hookValue = 2) {
    fun nancyDoesSomethingParticular(): Nancy {
        println("NANCY IS FANCY!")
        return this
    }
}
