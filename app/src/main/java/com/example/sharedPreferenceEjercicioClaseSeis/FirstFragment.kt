package com.example.sharedPreferenceEjercicioClaseSeis

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.sharedPreferenceEjercicioClaseSeis.databinding.ActivityMainBinding
import com.example.sharedPreferenceEjercicioClaseSeis.databinding.FragmentFirstBinding

private const val mFileSharedPreferences = "com.example.sharedPreferenceEjercicioClaseSeis"

class FirstFragment : Fragment() {

    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var binding : FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        sharedPreferences = requireActivity().getSharedPreferences(mFileSharedPreferences,
            Context.MODE_PRIVATE)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    private fun Save() {
        val mUserKey = ""
        var mUserRead = sharedPreferences.getString(mUserKey, "")
        if (mUserRead != null) {
            Log.d("TAG", mUserRead)
        }

/*
//obtener un int
        mSharedPreferences.getInt("TestInt", -1)

//obtener un String
        mSharedPreferences.getString("TestString", "NotFound")



//obtener un boolean
        mSharedPreferences.getBoolean("TestBoolean", false)

//obtener un long
        mSharedPreferences.getLong("TestLong", -1L)
//obtener un Float
        mSharedPreferences.getFloat("TestFloat", -1.0f)

//obtener un Set<String>
        mSharedPreferences.getStringSet("TestStringSet", setOf())
    */
    }
}
