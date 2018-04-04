package com.whatever.dojo

class Greeter(private val name : String) {
    fun greet(): String {
        return("Hello, $name")
    }
}


fun main(args : Array<String>) {
    System.out.println(Greeter(args[0]).greet())
}