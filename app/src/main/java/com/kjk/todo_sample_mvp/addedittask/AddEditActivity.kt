package com.kjk.todo_sample_mvp.addedittask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kjk.todo_sample_mvp.R

class AddEditActivity : AppCompatActivity() {

    private lateinit var addEditPresenter: AddEditPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_edit)

        // AddEditFragmet를 추가한다.
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, AddEditFragment.newInstance())
            .commit()
    }

    companion object {
        const val REQUEST_ADD_TASK = 1
    }
}