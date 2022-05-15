package com.kjk.todo_sample_mvp.addedittask

interface AddEditTaskContract {

    interface View {
        fun showEmptyTaskMessage()

        fun showTasksList()

        fun setTitle(title: String)

        fun setDescription(title: String)
    }

    interface Presenter {
        // task 저장
        fun saveTask(title: String, description: String)
    }
}