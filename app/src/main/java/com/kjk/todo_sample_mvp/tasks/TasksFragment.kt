package com.kjk.todo_sample_mvp.tasks

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kjk.todo_sample_mvp.R
import com.kjk.todo_sample_mvp.addedittask.AddEditTaskActivity
import com.kjk.todo_sample_mvp.databinding.FragmentTasksBinding

class TasksFragment : Fragment(), TasksContract.View {

    private lateinit var binding: FragmentTasksBinding
    override lateinit var presenter: TasksContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_tasks,
            container,
            false
        )

        initView()
        presenter = TasksPresenter(this)

        return binding.root
    }

    private fun initView() {
        binding.apply {
            // 현재 hosting되어 있는 Activity를 가져온다
            requireActivity().findViewById<FloatingActionButton>(R.id.fab).apply {
                setOnClickListener {
                    presenter.addNewTasks()
                }
            }
        }

        // app bar의 option menu가 존재하기 때문.
        setHasOptionsMenu(true)
    }

    // Task를 추가하는 화면으로 이동
    override fun showAddTask() {
        val intent = Intent(context, AddEditTaskActivity::class.java)
        startActivityForResult(intent, AddEditTaskActivity.REQUEST_ADD_TASK)
    }

    companion object {
        fun newInstance() = TasksFragment()
    }
}