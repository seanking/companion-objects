package dev.seanking.companionobject

class Car(val make: String, val model: String) {
    companion object CarFactory: Factory<Car> {
        override fun create(): Car = Car("Honda", "Civic")
    }
}

interface Factory<T> {
    fun create() : T
}
