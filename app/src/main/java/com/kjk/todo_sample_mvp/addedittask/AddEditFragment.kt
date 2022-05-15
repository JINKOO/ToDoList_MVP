package com.kjk.todo_sample_mvp.addedittask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kjk.todo_sample_mvp.R
import com.kjk.todo_sample_mvp.databinding.FragmentAddEidtTaskBinding

class AddEditFragment : Fragment() {

    private lateinit var binding: FragmentAddEidtTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_eidt_task, container, false)

        return binding.root
    }

    companion object {
        fun newInstance() = AddEditFragment()
    }
}