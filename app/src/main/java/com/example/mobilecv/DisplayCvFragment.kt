package com.example.mobilecv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mobilecv.databinding.FragmentDisplayCvBinding


class DisplayCvFragment : Fragment() {
    private var _binding: FragmentDisplayCvBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayCvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_displayCvFragment_to_updateCvFragment)
        }
    }

    private fun setUpRecyclerView() {
        val fieldsAdapter = FieldsAdapter(
            listOf(
                FieldItem("Name", "Nwaeme Olisemeka"),
                FieldItem("Slack Name", "O.Lee"),
                FieldItem("GitHub Handle", "nwaeme-olise"),
                FieldItem("Bio", "Hi there! I’m Olise, a Software Engineer with a keen interest in developing native Android apps. I’m also a graduate of Computer Science from the University of Lagos.\\n Before starting my developer career, I worked as a Software Instructor, where I taught Android Development with Java, as well as Python and Web Development to 50+ students. I also taught programming to kids in primary and secondary schools using mini robotics kits.")
            )
        )

        binding.rvFields.adapter = fieldsAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}