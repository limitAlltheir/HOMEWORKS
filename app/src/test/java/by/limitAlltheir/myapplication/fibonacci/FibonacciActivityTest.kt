package by.limitAlltheir.myapplication.fibonacci

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FibonacciActivityTest {

    @Test
    fun inputZero_returnZero() {

        val result = FibonacciActivity().fibonacci(
            0
        )

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun inputOne_returnOne() {

        val result = FibonacciActivity().fibonacci(
            1
        )

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun inputTen_returnFiftyFive() {

        val result = FibonacciActivity().fibonacci(
            10
        )

        assertThat(result).isEqualTo(55)
    }
}