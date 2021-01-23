import assertk.all
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.prop
import org.junit.jupiter.api.Test

class CompanionObjectTest {
    @Test
    fun `should provide singleton for class `() {
        // When
        val person = Person.defaultPerson()
        
        // Then 
        assertThat(person).all { 
            prop(Person::firstName).isEqualTo("Jane")
            prop(Person::lastName).isEqualTo("Smith")
        }
    }
    
    @Test
    fun `should implement an interface`() {
        // When 
        val car = Car.create();
        
        // Then
        assertThat(car).all { 
            prop(Car::make).isEqualTo("Honda")
            prop(Car::model).isEqualTo("Civic")
        }
    }     
    
    @Test
    fun `should generate real static methods`() {
        // When
        val dog = Dog.defaultDog()
        
        // Then
        assertThat(dog).prop(Dog::breed).isEqualTo("mutt")
    }
}

class Person(val firstName: String, val lastName: String) {
    companion object {
        fun defaultPerson() = Person("Jane", "Smith") 
    }
}

interface Factory<T> {
    fun create() : T 
}

class Car(val make: String, val model: String) {
    companion object : Factory<Car> {
        override fun create(): Car = Car("Honda", "Civic")
    }
}

class Dog(val breed: String) {
    companion object{
        @JvmStatic
        fun defaultDog() = Dog("mutt")
    }
}


