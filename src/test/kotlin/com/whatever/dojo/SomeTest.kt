package com.whatever.dojo

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertTrue

class SomeTest {

    lateinit var gr: Greeter

    @BeforeEach
    fun setup() {
        //do something
    }

    @Test
    fun greeting_should_match_expectation() {
        //GIVEN the greeter is initialized with a given name
        val name = "Jordan"
        gr = Greeter(name)

        //WHEN requesting a greeting
        val response = gr.greet()

        //THEN the returned value match expected
        assertTrue(response == "Hello, $name", "Greeting is not as expected")
    }


    @ParameterizedTest
    @ValueSource(strings = ["Georges", "Lucette","Even with special chars *%&","😧"])
    @Tag("fast")
    fun greeting_should_work_on_any_name(name: String) {
        //GIVEN the greeter is initialized with a given name
        gr = Greeter(name)

        //WHEN requesting a greeting
        val response = gr.greet()

        //THEN the returned value contains the given name
        assertTrue(response.contains(name), "Greeting is not as expected")
    }
}