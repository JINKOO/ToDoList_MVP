package com.kjk.todo_sample_mvp.addedittask

import com.kjk.todo_sample_mvp.BasePresenter
import com.kjk.todo_sample_mvp.BaseView

interface AddEditTaskContract {

    interface View : BaseView<Presenter> {
        fun showEmptyTaskMessage()

        fun showTasksList()

        fun setTitle(title: String)

        fun setDescription(title: String)
    }

    interface Presenter : BasePresenter {
        // task 저장
        fun saveTask(title: String, description: String)
    }
}