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
    private var initialValuesSet = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayCvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!initialValuesSet){
            setInitialValues()
            initialValuesSet = true
        }

        setUpRecyclerView()
        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_displayCvFragment_to_updateCvFragment)
        }
    }

    private fun setInitialValues() {
        viewModel.apply {
            setName("Nwaeme Olisemeka")
            setSlackName("O.Lee")
            setHandle("nwaeme-olise")
            setBio("Hi there! I’m Olise, a Software Engineer with a keen interest in developing native Android apps. I’m also a graduate of Computer Science from the University of Lagos.")
        }
    }

    private fun setUpRecyclerView() {
        val fieldsAdapter = FieldsAdapter(
            listOf(
                FieldItem("Name", viewModel.name.value?: ""),
                FieldItem("Slack Name", viewModel.slackName.value ?: ""),
                FieldItem("GitHub Handle", viewModel.handle.value ?: ""),
                FieldItem("Bio", viewModel.bio.value ?: "")
            )
        )

        binding.rvFields.adapter = fieldsAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}