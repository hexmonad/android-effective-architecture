/*
 * For the full copyright and license information, please view the LICENSE file that was distributed
 * with this source code. (c) 2016
 */
package com.hexmonad.effectivearchitecture;

import android.app.Application;
import android.content.Context;

import com.hexmonad.effectivearchitecture.data.api.RestApi;

/**
 * EffectiveArchApplication
 */
public class EffectiveArchApplication extends Application {

    private RestApi restApi;

    @Override
    public void onCreate() {
        super.onCreate();

        restApi = new RestApi();
    }

    public static EffectiveArchApplication get(Context context) {
        return (EffectiveArchApplication) context.getApplicationContext();
    }

    public RestApi getRestApi() {
        return restApi;
    }

}
