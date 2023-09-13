package com.example.mobilecv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mobilecv.databinding.FragmentUpdateCvBinding


class UpdateCvFragment : Fragment() {
    private var _binding: FragmentUpdateCvBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateCvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etName.setText(viewModel.name)
        binding.etSlackName.setText(viewModel.slackName)
        binding.etHandle.setText(viewModel.handle)
        binding.etBio.setText(viewModel.bio)
        binding.btnDone.visibility = GONE

        binding.etName.doAfterTextChanged {
            binding.btnDone.visibility = VISIBLE
        }

        binding.etSlackName.doAfterTextChanged {
            binding.btnDone.visibility = VISIBLE
        }

        binding.etHandle.doAfterTextChanged {
            binding.btnDone.visibility = VISIBLE
        }

        binding.etBio.doAfterTextChanged {
            binding.btnDone.visibility = VISIBLE
        }

        binding.btnDone.setOnClickListener {
            viewModel.apply {
                name= binding.etName.text.toString()
                slackName= binding.etSlackName.text.toString()
                handle = binding.etHandle.text.toString()
                bio = binding.etBio.text.toString()
            }

            binding.btnDone.visibility = GONE
            findNavController().popBackStack()

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}