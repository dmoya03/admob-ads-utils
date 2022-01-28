package social.networks;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Ads {

    public static class Admob {

        public static AdRequest adRequest;
        public static InterstitialAd mInterstitialAd;
        public static final String IntersticialUnitId = "ca-app-pub-3411531091898739/7582946826";
        public static final String IntersticialTestUnitId = "ca-app-pub-3940256099942544/1033173712";

        public static void initAdmob(Context context){
            MobileAds.initialize(context, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });
        }
        public static void prepareIntersticial(Context context, String adUnitId){
            adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(context,adUnitId, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            // The mInterstitialAd reference will be null until
                            // an ad is loaded.
                            mInterstitialAd = interstitialAd;
                            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    Log.i("onAdFailedToShowContent", "onAdFailedToShowFullScreenContent");
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                    super.onAdShowedFullScreenContent();
                                    Log.i("onAdShowedContent", "onAdShowedContent");
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    Log.i("onAdDismissedContent", "onAdDismissedContent");
                                }

                                @Override
                                public void onAdImpression() {
                                    super.onAdImpression();
                                    Log.i("onAdImpression", "onAdImpression");
                                }

                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                    Log.i("onAdClicked", "onAdClicked");
                                }
                            });
                            Log.i("AdLoaded", "onAdLoaded");
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error
                            Log.i("AdFailedError", loadAdError.getMessage());
                            mInterstitialAd = null;
                        }
                    });

        }
        public static void showIntersticialAd(Context context, Activity activity, String unitId){
            //initAdmob(context);
            prepareIntersticial(context, unitId);
            if (mInterstitialAd != null) {
                mInterstitialAd.show(activity);
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }

        public static void showBanner(AdView adView){
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
            adView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    // Code to be executed when an ad finishes loading.
                    Log.i("onAdLoadedBanner", "onAdLoadedBanner");
                }

                @Override
                public void onAdFailedToLoad(LoadAdError adError) {
                    // Code to be executed when an ad request fails.
                    Log.i("onAdFailedLoadBanner", "onAdFailedLoadBanner");
                }

                @Override
                public void onAdOpened() {
                    // Code to be executed when an ad opens an overlay that
                    // covers the screen.
                    Log.i("onAdOpenedBanner", "onAdOpenedBanner");
                }

                @Override
                public void onAdClicked() {
                    // Code to be executed when the user clicks on an ad.
                    Log.i("onAdClickedBanner", "onAdClickedBanner");
                }

                @Override
                public void onAdClosed() {
                    // Code to be executed when the user is about to return
                    // to the app after tapping on an ad.
                    Log.i("onAdClosedBanner", "onAdClosedAdBanner");
                }
            });
        }
    }

    /*public class MetaAudience{

        private InterstitialAd metaInterstitialAd;

        public void initMeta(Context context){
            // Initialize the Audience Network SDK
            AudienceNetworkAds.initialize(context);
        }

        public void prepareIntersticial(Context context){
            metaInterstitialAd = new InterstitialAd(context, "YOUR_PLACEMENT_ID") {
                @NonNull
                @Override
                public String getAdUnitId() {
                    return null;
                }

                @Override
                public void show(@NonNull Activity activity) {

                }

                @Override
                public void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {

                }

                @Nullable
                @Override
                public FullScreenContentCallback getFullScreenContentCallback() {
                    return null;
                }

                @Override
                public void setImmersiveMode(boolean b) {

                }

                @NonNull
                @Override
                public ResponseInfo getResponseInfo() {
                    return null;
                }

                @Override
                public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {

                }

                @Nullable
                @Override
                public OnPaidEventListener getOnPaidEventListener() {
                    return null;
                }
            };

        }
    }*/
}
