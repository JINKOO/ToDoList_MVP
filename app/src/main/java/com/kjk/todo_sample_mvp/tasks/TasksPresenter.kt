package com.kjk.todo_sample_mvp.tasks

/**
 * [TasksFragment]의 UI에서 사용자의 action을 감지하고,
 * 각 이벤트에 따라, data와 UI update를 다시 view에게 전달 한다.
 */
class TasksPresenter(
    val tasksView: TasksContract.View
) : TasksContract.Presenter {

    init {
        tasksView.presenter = this
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun addNewTasks() {
        tasksView.showAddTask()
    }
}