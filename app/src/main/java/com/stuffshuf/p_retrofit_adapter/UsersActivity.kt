package com.stuffshuf.p_retrofit_adapter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.user_list.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)



       val retrofit=Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl("https://jsonplaceholder.typicode.com")
           .build();


         val service=retrofit.create(UsersInterface::class.java)

        service.listRepos().enqueue(retrofitCallback { throwable, response ->

            response?.let {
                if(it.isSuccessful)
                {

                    Log.d("HH", "response ${it.body()}")
                  //  tvViews.text=it.body().toString()

                   // runOnUiThread {

                      //   tvViews.text=it.body().toString()

                  userRec.layoutManager=GridLayoutManager(
                      this,
                      1,
                      GridLayoutManager.VERTICAL,
                      false
                  )

                    userRec.adapter= UsersAdapter(this, it.body()!!)


                    //}
                }
            }
        })
    }
}
