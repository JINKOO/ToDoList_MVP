package com.kjk.todo_sample_mvp.addedittask

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.kjk.todo_sample_mvp.R
import com.kjk.todo_sample_mvp.databinding.FragmentAddEidtTaskBinding
import com.kjk.todo_sample_mvp.util.showSnackBar

class AddEditTaskFragment : Fragment(), AddEditTaskContract.View {

    private lateinit var binding: FragmentAddEidtTaskBinding
    override lateinit var presenter: AddEditTaskContract.Presenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated: ")
        requireActivity().findViewById<FloatingActionButton>(R.id.fab_edit_task_done).apply {
            setImageResource(R.drawable.ic_done)
            setOnClickListener {
                binding.run {
                    Log.d(TAG, "onActivityCreated: ${addTaskTitle.text.toString()}")
                    presenter.saveTask(addTaskTitle.text.toString(), addTaskDescription.text.toString())
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_eidt_task, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun showEmptyTaskMessage() {
        Log.d(TAG, "showEmptyTaskMessage: ")
        binding.addTaskTitle.showSnackBar(getString(R.string.empty_item_message), Snackbar.LENGTH_LONG)
    }

    override fun showTasksList() {

    }

    override fun setTitle(title: String) {
        //this.title.text = title
    }

    override fun setDescription(title: String) {
        //this.description.text = title
    }

    companion object {
        private const val TAG = "AddEditTaskFragment"
        const val ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID"
        fun newInstance() = AddEditTaskFragment()
    }
}