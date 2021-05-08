<a href="LICENSE.md">
<img src="https://unlicense.org/pd-icon.png" alt="Public Domain" align="right"/>
</a>

# An example of curiously recurring template pattern in Kotlin

[![build](https://github.com/binkley/kotlin-curiously-recurring-template-pattern/workflows/build/badge.svg)](https://github.com/binkley/kotlin-curiously-recurring-template-pattern/actions)
[![issues](https://img.shields.io/github/issues/binkley/kotlin-curiously-recurring-template-pattern.svg)](https://github.com/binkley/kotlin-curiously-recurring-template-pattern/issues/)
[![vulnerabilities](https://snyk.io/test/github/binkley/kotlin-curiously-recurring-template-pattern/badge.svg)](https://snyk.io/test/github/binkley/kotlin-curiously-recurring-template-pattern)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

## Build

```shell
$ ./mvnw -C clean verify
$ ./run.sh  # Try it out
```

## Discussion

The "curious recurring template pattern" (CRTP) is a phrase from C++ which
applies to Kotlin and Java as well. Wikipedia describes this as:

> The curiously recurring template pattern (CRTP) is an idiom in C++ in
> which a class X derives from a class template instantiation using X itself
> as a template argument. More generally it is known as F-bound
> polymorphism, and it is a form of F-bounded quantification.

What this means for Kotlin is a pattern like:

```kotlin
abstract class Base<B : Base<B>> { /* ... */ }
class Derived : Base<Derived>() { /* ... */ }
```

or in a more complex type hierarchy:

```kotlin
abstract class Base<B : Base<B>> { /* ... */ }
open class Middle<M : Middle<M>> : Base<M> { /* ... */ }
class Derived : Middle<Derived>() { /* ... */ }
```

You can see in the example code that `Base` (called
[`Curious`](./src/main/kotlin/hm/binkley/labs/curious/Main.kt))
depends on subtypes expressed at generic parameter `B`. This is how CRTP
works.

### When to use

Use this pattern when you have a base class needing to return a subtype, and
you have refactored the common code from the subtypes into the base type. This
is common in fluent APIs, and turns up elsewhere as well.

### Notes

Note this property in the base:

```kotlin
@Suppress("UNCHECKED_CAST")
protected val self: B
    get() = this as B
```

This approach is helpful to avoid `this as X` casts sprinkled through the base
class and any needed uses in derived classes. Simply returning
`this` refers to the base type rather than the needed derived type.

## Reading

* [_Curiously recurring template
  pattern_](https://en.wikipedia.org/wiki/Curiously_recurring_template_pattern) (
  Wikipedia)
