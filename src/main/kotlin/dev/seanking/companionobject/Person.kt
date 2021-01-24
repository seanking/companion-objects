package dev.seanking.companionobject

class Person(val firstName: String, val lastName: String) {
    companion object {
        fun defaultPerson() = Person("Jane", "Smith") 
    }
}
