package dev.seanking.kotlinobject

import assertk.assertThat
import assertk.assertions.isSameAs
import org.junit.jupiter.api.Test

class KotlinObjectTest {
    
    @Test
    fun `should be a singleton`() {
        // Given
        val firstObject = KotlinObject
        
        // When 
        val secondObject = KotlinObject
        
        // Then
        assertThat(firstObject).isSameAs(secondObject)
    }
}

