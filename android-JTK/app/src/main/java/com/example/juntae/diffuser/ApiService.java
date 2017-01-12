package com.example.juntae.diffuser;

/**
 * Created by juntae on 2017-01-06.
 */

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static android.R.attr.x;
import static android.R.attr.y;
import static android.os.Build.VERSION_CODES.M;

public interface ApiService {
 //   public static final String API_URL = "http://jsonplaceholder.typicode.com/";
    public static final String API_URL = "http:172.20.10.11:3000/";
 //   @FormUrlEncoded
    @POST("hello")
    Call<ResponseJson> getComment(@Body DataModel dataModel);

  /* Call<ResponseBody> getComment(@Query("x") int x,
                                  @Query("y") int y,
                                  @Query("z") int z,
                                  @Query("l") int l);
*/
}
