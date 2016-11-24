package com.abed.assignment.data.remote;

import com.abed.assignment.BuildConfig;
import com.abed.assignment.data.model.SearchResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface FlickrService {


    @GET("/services/rest")
    Observable<SearchResult> search(@Query("method") String method,
                                    @Query("api_key") String apiKey,
                                    @Query("format") String format,
                                    @Query("nojsoncallback") int nojsoncallback,
                                    @Query("per_page") int perPage,
                                    @Query("page") int page,
                                    @Query("text") String searchKey);


    /********
     * Helper class that sets up a new services
     *******/
    class Creator {
        public static FlickrService newFlickrService(OkHttpClient okHttpClient) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.FLICKR_API_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(FlickrService.class);
        }
    }

}
