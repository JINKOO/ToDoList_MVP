package com.kjk.todo_sample_mvp.data

data class Task(
    var title: String,
    var description: String
) {
    val isEmpty
        get() = title.isEmpty() || description.isEmpty()
}
