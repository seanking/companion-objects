# Companion Object

As a developer with a Java background, the idea of companion objects could be a new concept. However, if you have
experience with other language this might not be anything new.

## Object

Before you can really understand companion objects, it is best to first understand the `object` declaration. The
object declaration is Kotlin is similar to Scala. The `object` declaration is used to declare a Singleton. In the 
following example a `KotlinOject` is declared, and an assert is used to verify that there is only one instance of the 
object.

```kotlin
object KotlinObject {
    fun hello() {
        print("hello!")
    } 
}

val firstObject = KotlinObject
val secondObject = KotlinObject

assert(firstObject === secondObject)
```

## Companion Object

A companion object is the declaration of an object inside a class. The companion object can be accessed similarly to 
the way static fields and methods are accessed in Java. The following is a declaration of a companion object in the 
Person class.

```kotlin
class Person(val firstName: String, val lastName: String) {
    companion object {
        fun defaultPerson() = Person("Jane", "Smith") 
    }
}

val person = Person.defaultPerson()
```

### Java

Since Kotlin is compiled into bytecode, companion objects can be accessed in Java. The following sample is how to access
the companion object in Java. Since there wasn't a name given to the companion object in the previous example, a default
name of Companion is provided.  Therefore, the companion object can be accessed by `Person.Companion`.

```java
final var person = Person.Companion.defaultPerson();
```

Companion objects are normal objects, so they can implement interfaces. The following example declares a `Factory` 
interface and the `Car`'s companion object implements the `Factory`. 

```kotlin
interface Factory<T> {
    fun create() : T
}

class Car(val make: String, val model: String) {
    companion object CarFactory: Factory<Car> {
        override fun create(): Car = Car("Honda", "Civic")
    }
}

val car = Car.create()
```

Since the companion object was named as `CarFactory` the companion object is accessed via `Car.CarFactory`. 

```java
final var car = Car.CarFactory.create();
```

Some JVM libraries like JUnit depend on static methods. To support these libraries Kotlin has an `@JvmStatic` 
annotation. The `@JvmStatic` annotation instructs the Kotlin compiler to generate a real static fields and method.

```kotlin
class Dog(val breed: String) {
    companion object{
        @JvmStatic
        fun defaultDog() = Dog("mutt")
    }
}
```

In the following Java example, the companion object method can be accessed like a traditional static method.

```java
final var dog = Dog.defaultDog();
```

I hope this blog post helped provide insight into the idea of objects and companion objects. If you want to experiment 
with any of the examples, they can be found [here](https://github.com/seanking/companion-objects) in GitHub.
