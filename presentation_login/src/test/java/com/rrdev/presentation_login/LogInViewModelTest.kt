package com.rrdev.presentation_login

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rrdev.base_presentation.isError
import com.rrdev.base_presentation.isSuccess
import com.rrdev.domain.model.Investor
import com.rrdev.domain.usecase.LogIn
import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import kotlin.test.assertTrue

class LogInViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val app: Application = mockk()
    private val logIn: LogIn = mockk()
    private val investorDumbTest: Investor = mockk()
    private lateinit var viewModel: LogInViewModel

    private val testModule = module {
        single { logIn }
    }

    @Before
    fun setup(){
        startKoin { modules(testModule) }
        viewModel = LogInViewModel(app)
    }

    @After
    fun reset(){
        stopKoin()
    }

    @Test
    fun `use case LogIn WHERE has a success call MUST post success`(){
        every {
            logIn.invoke(params = any(), onError = any(), onSuccess = captureLambda())
        } answers {
            lambda<(Investor) -> Unit>().invoke(investorDumbTest)
        }
        viewModel.authUser("","")
        assertTrue(viewModel.logInViewState.isSuccess())
    }

    @Test
    fun `use case LogIn WHERE a error on call MUST post error`(){
        every {
            logIn.invoke(params = any(), onError = captureLambda(), onSuccess = any())
        } answers {
            lambda<(Throwable) -> Unit>().invoke(Throwable())
        }
        viewModel.authUser(email = "", password = "")
        assertTrue(viewModel.logInViewState.isError())
    }
}
