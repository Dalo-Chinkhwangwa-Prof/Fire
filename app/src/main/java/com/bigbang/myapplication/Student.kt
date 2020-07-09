package com.bigbang.myapplication

open class Student(var name: String = "", var age: Int = 0) {

    private var courseList = mutableListOf<String>("ACS111", "ACS222", "ACS333")

    override fun toString(): String {
        return "My name is $name and I am a $age year old student.".toUpperCase()
    }

    open fun getCourses(): List<String> = courseList
}