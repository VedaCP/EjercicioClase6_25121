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
        binding.tvValorEntero.text = sharedPreferences.getInt("Clave1",0).toString()
        binding.etTextAlm.text = sharedPreferences.getString("Clave2","").toString()
        binding.etNumberDecimal.text = sharedPreferences.getFloat("Clave3",0.0f).toString()

        var numEntero = "Clave1"
        var mTexto = "Clave2"
        var numDec = "Clave3"
        
        binding.btGuardar.setOnClickListener{

            var valor = binding.etNumberEntero.text.toString().toInt()
            sharedPreferences.edit().putInt(numEntero, valor).apply()
            var valor2 = sharedPreferences.getInt(numEntero, 0)
                .toString().toInt()
            binding.tvValorEntero.setText(getString(R.string.valor_entero_almacenado_1_d,
               valor2))

            var texto = binding.tvIngreseTexto.text.toString()
            sharedPreferences.edit().putString(mTexto, texto).apply()
            var texto2 = sharedPreferences.getString(mTexto, "")
            binding.etTextAlm.setText(getString(R.string.texto_almacenado, texto2))

            var decimal: Float
            decimal = binding.tvIngreseDecimal.text.toString().toFloat()
            sharedPreferences.edit().putFloat(numDec, decimal).apply()
            var decimal2 = sharedPreferences.getFloat(numDec, 0.0f)
                .toString().toFloat()
            binding.etNumberDecimal.setText(getString(R.string.decimal_almacenado,
                decimal2.toString()))
        }
        binding.btBorrar.setOnClickListener{
            sharedPreferences.edit().remove(numEntero).apply()
            sharedPreferences.edit().remove(mTexto).apply()
            sharedPreferences.edit().remove(numDec).apply()
            binding.etTextAlm.setText("")
            binding.etNumberEntero.setText("")
            binding.etNumberDecimal.setText("")
            binding.tvValorEntero.setText("")
            binding.tvIngreseTexto.setText("")
            binding.tvIngreseDecimal.setText("")
        }

    }
}
