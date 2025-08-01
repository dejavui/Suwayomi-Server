package xyz.nulldev.androidcompat

import android.webkit.WebView
import xyz.nulldev.androidcompat.config.ApplicationInfoConfigModule
import xyz.nulldev.androidcompat.config.FilesConfigModule
import xyz.nulldev.androidcompat.config.SystemConfigModule
import xyz.nulldev.androidcompat.webkit.KcefWebViewProvider
import xyz.nulldev.ts.config.GlobalConfigManager

/**
 * Initializes the Android compatibility module
 */
class AndroidCompatInitializer {
    fun init() {
        // Register config modules
        GlobalConfigManager.registerModules(
            FilesConfigModule.register(GlobalConfigManager.config),
            ApplicationInfoConfigModule.register(GlobalConfigManager.config),
            SystemConfigModule.register(GlobalConfigManager.config),
        )

        WebView.setProviderFactory({ view: WebView -> KcefWebViewProvider(view) })

        // Set some properties extensions use
        System.setProperty(
            "http.agent",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36",
        )
    }
}
