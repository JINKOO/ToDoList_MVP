package com.kjk.todo_sample_mvp.addedittask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.kjk.todo_sample_mvp.R
import com.kjk.todo_sample_mvp.databinding.ActivityAddEditBinding

class AddEditTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditBinding
    private lateinit var addEditPresenter: AddEditTaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit)

        val taskId = intent.getStringExtra(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID)

        // tool bar setUp
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = if (taskId.isNullOrBlank()) getString(R.string.new_to_do_label) else getString(
                R.string.edit_to_do_label)
        }


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
        private const val TAG = "AddEditTaskActivity"
        const val REQUEST_ADD_TASK = 1
    }
}