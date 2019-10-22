package wendreo.design.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wendreo.design.R
import wendreo.design.models.ZipCode
import wendreo.design.retrofit.RetrofitConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSearch.setOnClickListener { onClick() }
    }

    private fun onClick() {
        val zip = editTextZipCode!!.text.toString()

        if (zip == "" || zip.length < 9) {
            editTextZipCode!!.error = getString(R.string.type_valid_zipcode)
        } else {
                val call = RetrofitConfig().cepService
                        .buscarCEP(zip)
                call.enqueue(object : Callback<ZipCode> {
                    override fun onResponse(call: Call<ZipCode>,
                                            response: Response<ZipCode>) {
                        val zip = response.body()
                        try {
                            if (zip!!.cep == null) {
                                textViewResponse!!.text = getString(R.string.no_zip)
                            } else {
                                ShowMSG(getString(R.string.success), 1)
                                textViewResponse!!.text = zip.toString()
                            }

                        } catch (e: Exception) {
                            Log.e(getString(R.string.error1),
                                    getString(R.string.error2) + e.message)
                        }
                    }

                    override fun onFailure(call: Call<ZipCode>, t: Throwable) {
                        ShowMSG(getString(R.string.error2) + t.message,
                                0)
                    }
                })
        }
    }

    private fun ShowMSG(msg: String, time: Int?) {
        when (time) {
            0 -> Snackbar.make(LinearLayout!!, msg, Snackbar.LENGTH_LONG).show()
            else -> Snackbar.make(LinearLayout!!, msg, Snackbar.LENGTH_SHORT).show()
        }
    }
}