package com.manappuram.twowheeler.network;


import com.manappuram.twowheeler.APIInterface;
import com.manappuram.twowheeler.BuildConfig;
import java.util.concurrent.TimeUnit;



import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static String BASE_URL ="https://onpay.online.manappuram.com/TwowheelerService/WebService1.asmx/"; // UAT
 // public static String BASE_URL ="https://online.manappuram.com/OtherVerticalService/WebService1.asmx/"; // Production



    private static RetrofitClient sInstance;
    private Retrofit retrofit ;

    public static void create() {
        if (sInstance == null) {
            synchronized (RetrofitClient.class) {
                if (sInstance == null) {
                    sInstance = new RetrofitClient();
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



    private RetrofitClient() {

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
        synchronized (RetrofitClient.class) {
            if (sInstance == null)
//                throw new IllegalStateException("RetrofitClient instance is not created yet. Call RetrofitClient.create() before calling getInstance()");
                create();

        }
        return sInstance.retrofit;
    }


}
