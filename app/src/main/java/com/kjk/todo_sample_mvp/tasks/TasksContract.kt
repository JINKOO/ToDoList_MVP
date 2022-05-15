package com.kjk.todo_sample_mvp.tasks

import com.kjk.todo_sample_mvp.BasePresenter
import com.kjk.todo_sample_mvp.BaseView

/**
 * view 와 presenter사이의 contract를 명세한 class이다.
 */
interface TasksContract {

    interface View {

        // 새로운 task를 추가하는 화면으로 이동
        fun showAddTask()

    }

    interface Presenter {

        // 새로운 tasks를 추가하는 작업
        fun addNewTasks()
    }
}