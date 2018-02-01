package com.todo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.react.ReactApplication;
import com.oblador.vectoricons.VectorIconsPackage;
import com.oblador.keychain.KeychainPackage;
import com.lynxit.contactswrapper.ContactsWrapperPackage;
import com.reactlibrary.RNAppAuthPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends MultiDexApplication implements ReactApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

//        @Override
//        protected String getJSBundleFile() {
//       // return CodePush.getJSBundleFile();
//        }
    
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new VectorIconsPackage(),
            // new NavigationReactPackage(),
            new KeychainPackage(),
            new ContactsWrapperPackage(),
            new RNAppAuthPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
        return "artifacts/index.android";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }


  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }



}
