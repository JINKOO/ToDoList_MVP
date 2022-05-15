package com.kjk.todo_sample_mvp.addedittask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kjk.todo_sample_mvp.R

class AddEditTaskActivity : AppCompatActivity() {

    private lateinit var addEditPresenter: AddEditTaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_edit)

        // AddEditTaskFragment 추가
        val fragmentManager = supportFragmentManager
        val addEditTaskFragment = AddEditTaskFragment.newInstance()
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, addEditTaskFragment)
            .commit()

        // AddEditTaskPresenter 생성
        addEditPresenter = AddEditTaskPresenter(addEditTaskFragment)
    }

    companion object {
        private const val TAG = "1111"
        const val REQUEST_ADD_TASK = 1
    }
}