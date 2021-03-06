package com.prim.primweb.core.webclient.webchromeclient;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;

import com.prim.primweb.core.webview.IAgentWebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/21 0021
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class BaseX5ChromeClient extends WebChromeClient {
    private WebChromeClient mDelegate;

    private AgentChromeClient chormeClient;

    private IAgentWebView webView;

    public WebChromeClient getWebChromeClient() {
        return mDelegate;
    }

    public AgentChromeClient getAgentChromeClient() {
        return chormeClient;
    }

    public void setChromeClient(WebChromeClient delegate) {
        this.mDelegate = delegate;
    }

    public void setChromeClient(AgentChromeClient chromeClient, IAgentWebView webView) {
        this.chormeClient = chromeClient;
        this.webView = webView;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        if (this.mDelegate != null) {
            this.mDelegate.onProgressChanged(view, newProgress);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onProgressChanged(view, newProgress);
            return;
        }
        super.onProgressChanged(view, newProgress);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        if (this.mDelegate != null) {
            this.mDelegate.onReceivedTitle(view, title);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onReceivedTitle(view, title);
            return;
        }
        super.onReceivedTitle(view, title);
    }

    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        if (this.mDelegate != null) {
            this.mDelegate.onReceivedIcon(view, icon);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onReceivedIcon(view, icon);
            return;
        }
        super.onReceivedIcon(view, icon);

    }

    @Override
    public void onReceivedTouchIconUrl(WebView view, String url,
                                       boolean precomposed) {
        if (this.mDelegate != null) {
            this.mDelegate.onReceivedTouchIconUrl(view, url, precomposed);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onReceivedTouchIconUrl(view, url, precomposed);
            return;
        }
        super.onReceivedTouchIconUrl(view, url, precomposed);
    }

    @Override
    public void onShowCustomView(View view, final IX5WebChromeClient.CustomViewCallback callback) {
        if (this.mDelegate != null) {
            this.mDelegate.onShowCustomView(view, callback);
            return;
        }

        if (this.chormeClient != null) {
            com.prim.primweb.core.webclient.callback.CustomViewCallback customViewCallback = new com.prim.primweb.core.webclient.callback.CustomViewCallback() {
                @Override
                public void onCustomViewHidden() {
                    callback.onCustomViewHidden();
                }
            };
            this.chormeClient.onShowCustomView(view, customViewCallback);
            return;
        }
        super.onShowCustomView(view, callback);
    }


    @Override
    public void onShowCustomView(View view, int requestedOrientation,
                                 final IX5WebChromeClient.CustomViewCallback callback) {
        if (this.mDelegate != null) {
            this.mDelegate.onShowCustomView(view, requestedOrientation, callback);
            return;
        }

        if (this.chormeClient != null) {
            com.prim.primweb.core.webclient.callback.CustomViewCallback customViewCallback = new com.prim.primweb.core.webclient.callback.CustomViewCallback() {
                @Override
                public void onCustomViewHidden() {
                    callback.onCustomViewHidden();
                }
            };
            this.chormeClient.onShowCustomView(view, requestedOrientation, customViewCallback);
            return;
        }
        super.onShowCustomView(view, requestedOrientation, callback);
    }


    @Override
    public void onHideCustomView() {
        if (this.mDelegate != null) {
            this.mDelegate.onHideCustomView();
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onHideCustomView();
            return;
        }
        super.onHideCustomView();
    }

    @Override
    public boolean onCreateWindow(WebView view, boolean isDialog,
                                  boolean isUserGesture, Message resultMsg) {
        if (this.mDelegate != null) {
            return this.mDelegate.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
        }
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
    }

    @Override
    public void onRequestFocus(WebView view) {
        if (this.mDelegate != null) {
            this.mDelegate.onRequestFocus(view);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onRequestFocus(view);
            return;
        }
        super.onRequestFocus(view);
    }

    @Override
    public void onCloseWindow(WebView window) {
        if (this.mDelegate != null) {
            this.mDelegate.onCloseWindow(window);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onCloseWindow(window);
            return;
        }
        super.onCloseWindow(window);
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message,
                             JsResult result) {
        if (this.mDelegate != null) {
            return this.mDelegate.onJsAlert(view, url, message, result);
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onJsAlert(view, url, message, result);
        }
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message,
                               JsResult result) {
        if (this.mDelegate != null) {
            return this.mDelegate.onJsConfirm(view, url, message, result);
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onJsConfirm(view, url, message, result);
        }
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message,
                              String defaultValue, JsPromptResult result) {
        if (this.mDelegate != null) {
            return this.mDelegate.onJsPrompt(view, url, message, defaultValue, result);
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onJsPrompt(view, url, message, defaultValue, result);
        }
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    @Override
    public boolean onJsBeforeUnload(WebView view, String url, String message,
                                    JsResult result) {
        if (this.mDelegate != null) {
            return this.mDelegate.onJsBeforeUnload(view, url, message, result);
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onJsBeforeUnload(view, url, message, result);
        }
        return super.onJsBeforeUnload(view, url, message, result);
    }

    @Override
    @Deprecated
    public void onExceededDatabaseQuota(String url, String databaseIdentifier,
                                        long quota, long estimatedDatabaseSize, long totalQuota,
                                        WebStorage.QuotaUpdater quotaUpdater) {
        if (this.mDelegate != null) {
            this.mDelegate.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
            return;
        }
        super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);

    }

    @Override
    @Deprecated
    public void onReachedMaxAppCacheSize(long requiredStorage, long quota,
                                         WebStorage.QuotaUpdater quotaUpdater) {
        if (this.mDelegate != null) {
            this.mDelegate.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
            return;
        }
        super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
    }

    @Override
    public void onGeolocationPermissionsShowPrompt(String s, final GeolocationPermissionsCallback geolocationPermissionsCallback) {
        if (this.mDelegate != null) {
            this.mDelegate.onGeolocationPermissionsShowPrompt(s, geolocationPermissionsCallback);
            return;
        }

        if (this.chormeClient != null) {
            com.prim.primweb.core.webclient.callback.GeolocationPermissionsCallback callback = new com.prim.primweb.core.webclient.callback.GeolocationPermissionsCallback() {
                @Override
                public void invoke(String var1, boolean var2, boolean var3) {
                    geolocationPermissionsCallback.invoke(var1, var2, var3);
                }
            };
            this.chormeClient.onGeolocationPermissionsShowPrompt(s, callback);
        }
        super.onGeolocationPermissionsShowPrompt(s, geolocationPermissionsCallback);
    }

    @Override
    public void onGeolocationPermissionsHidePrompt() {
        if (this.mDelegate != null) {
            this.mDelegate.onGeolocationPermissionsHidePrompt();
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.onGeolocationPermissionsHidePrompt();
            return;
        }
        super.onGeolocationPermissionsHidePrompt();
    }


    @Override
    public boolean onJsTimeout() {
        if (this.mDelegate != null) {
            return this.mDelegate.onJsTimeout();
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onJsTimeout();
        }
        return super.onJsTimeout();
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (this.mDelegate != null) {
            return this.mDelegate.onConsoleMessage(consoleMessage);
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override
    public Bitmap getDefaultVideoPoster() {
        if (this.mDelegate != null) {
            return this.mDelegate.getDefaultVideoPoster();
        }

        if (this.chormeClient != null) {
            return this.chormeClient.getDefaultVideoPoster();
        }
        return super.getDefaultVideoPoster();
    }

    @Override
    public View getVideoLoadingProgressView() {
        if (this.mDelegate != null) {
            return this.mDelegate.getVideoLoadingProgressView();
        }

        if (this.chormeClient != null) {
            return this.chormeClient.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }

    @Override
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        if (this.mDelegate != null) {
            this.mDelegate.getVisitedHistory(callback);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.getVisitedHistory(callback);
            return;
        }
        super.getVisitedHistory(callback);
    }

    @Override
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
                                     FileChooserParams fileChooserParams) {
        if (this.mDelegate != null) {
            return this.mDelegate.onShowFileChooser(webView, filePathCallback, fileChooserParams);
        }

        if (this.chormeClient != null) {
            return this.chormeClient.onShowFileChooser(webView, filePathCallback, fileChooserParams);
        }
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
    }

    @Override
    public void openFileChooser(ValueCallback<Uri> valueCallback, String s, String s1) {
        if (this.mDelegate != null) {
            this.mDelegate.openFileChooser(valueCallback, s, s1);
            return;
        }

        if (this.chormeClient != null) {
            this.chormeClient.openFileChooser(valueCallback, s, s1);
            return;
        }
        super.openFileChooser(valueCallback, s, s1);
    }
}
