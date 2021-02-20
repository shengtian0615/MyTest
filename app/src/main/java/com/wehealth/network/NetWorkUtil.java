package com.wehealth.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wehealth.model.domain.model.AuthToken;
import com.wehealth.model.util.Constant;
import com.wehealth.network.inter_other.WeHealthToken;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetWorkUtil {

    public static String cli_cred = "client_credentials";
    public static String bear = "Bearer ";
    private static final String CLIENT_AGREEMENT ="TLS";//使用协议

    private static Retrofit instance;

    public static Retrofit getInstance(String Url){
        if (instance==null){
            synchronized (NetWorkUtil.class){
                if (instance==null){
                    instance = init(Url);
                }
            }
        }
        return instance;
    }

    private static Retrofit init(String Url){
        SSLContext sslContext = null;
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        X509TrustManager x509TrustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        try {
            //取得SSL的SSLContext实例
            sslContext = SSLContext.getInstance(CLIENT_AGREEMENT);
            //取得TrustManagerFactory的X509密钥管理器实例
            TrustManager[] trustAllCerts = new TrustManager[] {x509TrustManager};
            //初始化
            sslContext.init(null,trustAllCerts,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sslContext==null){
            return null;
        }
        okHttpClient.sslSocketFactory(sslContext.getSocketFactory(), x509TrustManager);
        HostnameVerifier hostVerifier = (s, sslSession)->true;

        okHttpClient.hostnameVerifier(hostVerifier);
        okHttpClient.readTimeout(5000L, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(5000L, TimeUnit.MILLISECONDS);
        okHttpClient.connectTimeout(5000L, TimeUnit.MILLISECONDS);
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss") .create();
        Gson gson = GsonHelper.customGson;
        return new Retrofit.Builder().baseUrl(Url) //url自行配置 https://test.5wehealth.com/ECGPlatformService/jaxrs/
                .client(okHttpClient.build()).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static Retrofit thirdRetrofit(String Url){
        SSLContext sslContext = null;
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        X509TrustManager x509TrustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        try {
            //取得SSL的SSLContext实例
            sslContext = SSLContext.getInstance(CLIENT_AGREEMENT);
            //取得TrustManagerFactory的X509密钥管理器实例
            TrustManager[] trustAllCerts = new TrustManager[] {x509TrustManager};
            //初始化
            sslContext.init(null,trustAllCerts,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sslContext==null){
            return null;
        }
        okHttpClient.sslSocketFactory(sslContext.getSocketFactory(), x509TrustManager);
        HostnameVerifier hostVerifier = (s, sslSession)->true;

        okHttpClient.hostnameVerifier(hostVerifier);
        okHttpClient.readTimeout(5000L, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(5000L, TimeUnit.MILLISECONDS);
        okHttpClient.connectTimeout(5000L, TimeUnit.MILLISECONDS);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss") .create();
//        Gson gson = GsonHelper.customGson;
        return new Retrofit.Builder().baseUrl(Url) //url自行配置 https://test.5wehealth.com/ECGPlatformService/jaxrs/
                .client(okHttpClient.build()).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static AuthToken refreshAuthToken(AuthToken oldToken, String url) {
        if(oldToken == null) return null;
        String accessToken = oldToken.getAccess_token();
        if (accessToken == null){
            return null;
        }
        long expireTime = oldToken.getExpires_in();
        if (System.currentTimeMillis() - expireTime > 0){ // need get new token
            try {
                String refreshToken = oldToken.getRefresh_token();
                Call<AuthToken> call = init(url).create(WeHealthToken.class).refreshToken(bear + accessToken, "refresh_token", Constant.Doctor, refreshToken);
                Response<AuthToken> response = call.execute();
                if (response.isSuccessful()){
                    return response.body();
                }else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return oldToken;
        }
    }
}
