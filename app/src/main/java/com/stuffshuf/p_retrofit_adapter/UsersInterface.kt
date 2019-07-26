package com.stuffshuf.p_retrofit_adapter

import retrofit2.Call
import retrofit2.http.GET

interface UsersInterface {
    @GET("users")

    fun listRepos() : Call<ArrayList<Users>> //we define the exact model class like Array list mae Users hai to hme
                                            // UsersAdapter(it.body()!!) isme array k ander object hai to ArrayList<Object>
                                            // and pulkit wali api mae object k ander array and us array k ander object the
                                            // to hme phle object banana pada fir use object ko items arrayList mae ander daal diya

}