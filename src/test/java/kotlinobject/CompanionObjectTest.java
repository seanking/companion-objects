package dev.seanking.kotlinobject;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import dev.seanking.companionobject.Car;
import dev.seanking.companionobject.Dog;
import dev.seanking.companionobject.Person;

public class CompanionObjectTest {
    @Test
    public void shouldProvideSingletonClass() {
        // Given
        final var object1 = Person.Companion;
        
        // When
        final var object2 = Person.Companion;
        
        // Then
        assertThat(object1).isSameAs(object2);
    }
    
    @Test
    public void shouldAccessDefaultCompanionObject() {
        // When
        final var person = Person.Companion.defaultPerson();
        
        // Then
        assertThat(person).isInstanceOf(Person.class);
    }

    @Test
    public void shouldAccessNamedCompanionObject() {
        // When
        final var car = Car.CarFactory.create();

        // Then
        assertThat(car).isInstanceOf(Person.class);
    }

    @Test
    public void shouldAccessCompanionObjectMethodAsStaticMethod() {
        // When
        final var dog = Dog.defaultDog();

        // Then
        assertThat(dog).isInstanceOf(Dog.class);
    }
}
