package com.carlosgumiel.mientreno;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;

/**
 * Opens the authenticated web app in Chrome's secure browser context.
 * Keeping authentication in Chrome avoids storing ChatGPT credentials in the APK.
 */
public class MainActivity extends android.app.Activity {
    private static final String MI_ENTRENO_URL =
            "https://mi-entreno.carlosgumiel.chatgpt.site/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = Uri.parse(MI_ENTRENO_URL);
        try {
            CustomTabsIntent customTabs = new CustomTabsIntent.Builder()
                    .setShowTitle(false)
                    .build();
            customTabs.launchUrl(this, uri);
        } catch (Exception ignored) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(browserIntent);
        }
        finish();
    }
}
