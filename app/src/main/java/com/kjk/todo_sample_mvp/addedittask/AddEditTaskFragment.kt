package com.kjk.todo_sample_mvp.addedittask

import android.os.Bundle
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
    private lateinit var presenter: AddEditTaskContract.Presenter

    private lateinit var title: TextView
    private lateinit var description: TextView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().findViewById<FloatingActionButton>(R.id.fab_edit_task_done).apply {
            setImageResource(R.drawable.ic_done)
            setOnClickListener {
                presenter.saveTask(title.text.toString(), description.text.toString())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_eidt_task, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun showEmptyTaskMessage() {
        title.showSnackBar(getString(R.string.empty_item_message), Snackbar.LENGTH_LONG)
    }

    override fun showTasksList() {
        TODO("Not yet implemented")
    }

    override fun setTitle(title: String) {
        this.title.text = title
    }

    override fun setDescription(title: String) {
        this.description.text = title
    }

    companion object {
        fun newInstance() = AddEditTaskFragment()
    }
}