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
```

You can see in the example code that `Base` (called
[`Curious`](./src/main/kotlin/hm/binkley/labs/curious/Main.kt))
depends on subtypes expressed at generic parameter `B`. This is how CRTP
works.

## Reading

* [_Curiously recurring template
  pattern_](https://en.wikipedia.org/wiki/Curiously_recurring_template_pattern) (
  Wikipedia)
