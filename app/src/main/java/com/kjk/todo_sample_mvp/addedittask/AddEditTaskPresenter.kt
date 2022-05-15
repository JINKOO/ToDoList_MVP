package com.kjk.todo_sample_mvp.addedittask

import com.kjk.todo_sample_mvp.data.Task
import org.jetbrains.annotations.Contract

class AddEditTaskPresenter(
    private val addTaskView: AddEditTaskContract.View
) : AddEditTaskContract.Presenter {

    override fun saveTask(title: String, description: String) {
        createTask(title, description)
    }

    /** create new Task */
    private fun createTask(title: String, description: String) {
        val newTask = Task(title, description)
        if (newTask.isEmpty) {
            // title항목과, description항목 중 하나가 비어 있다는 알림
            addTaskView.showEmptyTaskMessage()
        } else {

        }
    }
}