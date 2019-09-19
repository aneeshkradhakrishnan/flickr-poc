package com.poc.flickrdisplay.viewmodels

import io.mockk.MockKAnnotations
import org.junit.Before

abstract class BaseKTest {

    @Before
    fun setUp() = MockKAnnotations.init(this)
}