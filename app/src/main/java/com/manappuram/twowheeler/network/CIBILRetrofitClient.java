package com.manappuram.twowheeler.network;

import com.manappuram.twowheeler.APIInterface;
import com.manappuram.twowheeler.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CIBILRetrofitClient {
    public static String BASE_URL ="https://mac.mactech.net.in/cibilapi/"; // UAT
 //   public static String BASE_URL ="https://unsecurepl.manappuram.com/tw/CIBILAPI/"; // Production


    private static CIBILRetrofitClient sInstance;
    private Retrofit retrofit ;

    public static void create() {
        if (sInstance == null) {
            synchronized (CIBILRetrofitClient.class) {
                if (sInstance == null) {
                    sInstance = new CIBILRetrofitClient();
                }
            }
        }
//        else
//            throw new IllegalStateException("RetrofitClient instance is already been created.");
    }

    public static APIInterface getAPIInterface() {

        if (sInstance == null)
            create();

        return sInstance.retrofit.create(APIInterface.class);
    }
    private CIBILRetrofitClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(interceptor);
        }
        // httpClient.addInterceptor(new ApplicationInterceptor());
        httpClient.connectTimeout(300, TimeUnit.SECONDS);
        httpClient.writeTimeout(300, TimeUnit.SECONDS);
        httpClient.readTimeout(300, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * Returns the instance of {@link Retrofit}.
     * This method must be called after {@link #create}.
     */
    public static Retrofit retrofit() {
        synchronized (CIBILRetrofitClient.class) {
            if (sInstance == null)
//                throw new IllegalStateException("RetrofitClient instance is not created yet. Call RetrofitClient.create() before calling getInstance()");
                create();

        }
        return sInstance.retrofit;
    }
}
