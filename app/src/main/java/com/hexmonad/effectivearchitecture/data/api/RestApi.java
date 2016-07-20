package com.hexmonad.effectivearchitecture.data.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexmonad.effectivearchitecture.data.model.ItemDetails;
import com.hexmonad.effectivearchitecture.data.model.Items;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

/**
 * RestApi
 */
public interface RestApi {

    String BASE_URL = "http://pokeapi.co/api/v2/";
    String IMAGE_PREVIEW_URL = "http://pokeapi.co/media/sprites/pokemon/%d.png";

    @GET("pokemon/?limit=20&offset=0")
    Single<Items> getItems();

    @GET("pokemon/{itemId}/")
    Single<ItemDetails> getItemDetails(@Path("itemId") int itemId);

    class Factory {
        public static RestApi createRestApi() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(RestApi.class);
        }
    }

}
