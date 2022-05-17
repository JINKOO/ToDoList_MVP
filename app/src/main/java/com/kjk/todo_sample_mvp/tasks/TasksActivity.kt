package com.kjk.todo_sample_mvp.tasks

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kjk.todo_sample_mvp.R
import com.kjk.todo_sample_mvp.databinding.ActivityMainBinding

class TasksActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var tasksPresenter: TasksPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // app bar init
        setSupportActionBar(binding.appBarMain.toolbar)
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        drawerLayout = binding.drawerLayout.apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }

        // TODO navController
        //val navView: NavigationView = binding.navView
        //val navController = findNavController(R.id.nav_host_fragment_content_main)

        // tasksFragment추가
        val tasksFragment = TasksFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, tasksFragment)
            .commit()

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

        // Presenter 생성
        tasksPresenter = TasksPresenter(tasksFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}