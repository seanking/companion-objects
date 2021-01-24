package dev.seanking.companionobject

class Dog(val breed: String) {
    companion object{
        @JvmStatic
        fun defaultDog() = Dog("mutt")
    }
}
