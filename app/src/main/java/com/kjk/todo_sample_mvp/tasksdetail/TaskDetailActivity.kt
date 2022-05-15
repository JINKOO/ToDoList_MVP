package com.kjk.todo_sample_mvp.tasksdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kjk.todo_sample_mvp.R

class TaskDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)
    }

    companion object {
        const val EXTRA_TASK_ID = "TASK_ID"
    }
}