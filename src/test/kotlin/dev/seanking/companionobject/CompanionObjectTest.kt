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
        val car = Car.create()
        
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


