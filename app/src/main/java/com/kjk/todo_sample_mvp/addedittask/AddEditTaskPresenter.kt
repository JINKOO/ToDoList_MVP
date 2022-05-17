package com.kjk.todo_sample_mvp.addedittask

import android.util.Log
import com.kjk.todo_sample_mvp.data.Task
import org.jetbrains.annotations.Contract

class AddEditTaskPresenter(
    private val addTaskView: AddEditTaskContract.View
) : AddEditTaskContract.Presenter {

    init {
        addTaskView.presenter = this
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    // TODO updateTask() 추가해야
    override fun saveTask(title: String, description: String) {
        Log.d(TAG, "saveTask: ${title}, ${description}")
        createTask(title, description)
    }

    /** create new Task */
    private fun createTask(title: String, description: String) {
        val newTask = Task(title, description)
        if (newTask.isEmpty) {
            // title항목과, description항목 중 하나가 비어 있다는 알림
            addTaskView.showEmptyTaskMessage()
        } else {
            //TODO
            //repo.saveTask(title, description)
        }
    }

    /** 기존 Task를 Update */
    private fun updateTask(title: String, description: String) {

    }

    companion object {
        private const val TAG = "AddEditTaskPresenter"
    }
}