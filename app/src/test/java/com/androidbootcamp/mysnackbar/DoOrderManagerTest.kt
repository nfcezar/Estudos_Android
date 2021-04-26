package com.androidbootcamp.mysnackbar

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DoOrderManagerTest {

    private lateinit var doOrderManager: DoOrderManager

    @MockK
    private lateinit var shPref: SharedPreferencesManager

    @Before
    fun before() {
        MockKAnnotations.init(this)
        doOrderManager = DoOrderManager(shPref)
    }

    @Test
    fun `should be able to return success when given a valid order`() {

        //Arrange
        every { shPref.saveIntOnPreferences(KEY_CODIGO, validCode) } just runs
        every { shPref.saveIntOnPreferences(KEY_QUANTIDADE, validAmount) } just runs
        every { shPref.saveFloatOnPreferences(KEY_PRECO, any()) } just runs

        //Act
        val response = doOrderManager.doOrder(validAmount, validCode)

        //Assert
        assertEquals(OrderResult.SUCCESS, response)
        verify(exactly = 1) {
            shPref.saveIntOnPreferences(KEY_CODIGO, validCode)
            shPref.saveIntOnPreferences(KEY_QUANTIDADE, validAmount)
            shPref.saveFloatOnPreferences(KEY_PRECO, any())
        }
    }

    @Test
    fun `should be able to return failure when given a invalid order`() {
        val response = doOrderManager.doOrder(validAmount, invalidCode)
        assertEquals(OrderResult.FAILURE, response)
    }

    @Test
    fun `should calculate correct order result when given CACHORRO_QUENTE`() {
        val response = order(Meal.CACHORRO_QUENTE, validAmount)

        assertEquals(Meal.CACHORRO_QUENTE, response.meal)
        assertEquals(validAmount,response.qtd)
        assertEquals(validAmount*Price.PRICE1.price,response.price)
    }

    companion object {
        private const val validCode = 101
        private const val validAmount = 5
        private const val invalidCode = 1010

        private const val KEY_CODIGO = "key_codigo"
        private const val KEY_QUANTIDADE = "key_quantidade"
        private const val KEY_PRECO = "key_preco"
    }

}