/*
 * For the full copyright and license information, please view the LICENSE file that was distributed
 * with this source code. (c) 2016
 */
package com.hexmonad.effectivearchitecture.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hexmonad.effectivearchitecture.EffectiveArchApplication;
import com.hexmonad.effectivearchitecture.di.component.ActivityComponent;
import com.hexmonad.effectivearchitecture.di.component.DaggerActivityComponent;
import com.hexmonad.effectivearchitecture.di.module.ActivityModule;

/**
 * BaseActivity
 *
 * A base class for all activities.
 */
public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(EffectiveArchApplication.get(this).getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return activityComponent;
    }
}
