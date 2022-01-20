package com.olamachia.simpleblogapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.olamachia.simpleblogapp.R
import com.olamachia.simpleblogapp.ViewModel.SplashViewModel

class IntroActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()
    private lateinit var btn_launchMainActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * This sets the entire page to full screen
         * */
        window.setFlags(

            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        /**
         * An instance of the splashscreen dependency is created here
         * */
        installSplashScreen().apply {
            setKeepVisibleCondition {
                viewModel.isLoading.value
            }
        }

        setContentView(R.layout.activity_intro)
        btn_launchMainActivity = findViewById(R.id.btn_view_posts_intro)

        btn_launchMainActivity.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}