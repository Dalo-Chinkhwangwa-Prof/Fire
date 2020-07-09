package com.bigbang.myapplication

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class StudentItemTest {


    val testString = "My name is Dalo and I am a 100 year old student."

    @Mock
    lateinit var student: Student


    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(student.toString()).thenReturn(testString.toUpperCase())
        Mockito.`when`(student.getCourses()).thenReturn(mutableListOf("A", "B","2"))
    }


    @Test
    fun test_toString() {

        assertEquals(3, student.getCourses().size)

    }

}