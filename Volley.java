package com.example.locationdesvoitures.View;

import android.content.Context;
import android.net.Network;
import android.os.Build;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HurlStack;

import java.io.File;

public class Volley {
    public static <RequestQueue, StringRequest> RequestQueue newRequestQueue(RegisterActivity<RequestQueue,StringRequest> requestQueueStringRequestRegisterActivity) {
    


        /**
         * Default on-disk cache directory.
         */
        final String DEFAULT_CACHE_DIR = "volley";

        /** Default network thread pool size */
        final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;

        /** The maximum size of the disk cache, in bytes. */
        final int DEFAULT_DISK_USAGE_BYTES = 5 * 1024 * 1024;

        /** Default connection timeout of 20 seconds. */
        final int DEFAULT_TIMEOUT_MS = 20 * 1000;

        /** Default backoff multiplier for requests. */
        final float DEFAULT_BACKOFF_MULT = 1f;

        final String HEADER_USER_AGENT = "User-Agent";
        final String USER_AGENT = "volley/0";

        /**
         * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
         *
         * @param context A {@link Context} to use for creating the cache dir.
         * @param stack An {@link HttpStack} to use for the network, or null for default.
         * @return A started {@link RequestQueue} instance.
         */
        public static RequestQueue newRequestQueue Object Context;
        Object context1 = Context;
        RegisterActivity<? extends RequestQueue, ? extends Object> context;
        Object HttpStack;
        context, HttpStack boolean stack;
        boolean stack1 = stack;) {
            File cacheDir = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);

            String userAgent = System.getProperty("http.agent");
            if (userAgent == null || userAgent.length() == 0) {
                userAgent = USER_AGENT;
            }

            if (stack == null) {
                if (Build.VERSION.SDK_INT >= 9) {
                    stack = new HurlStack();
                } else {
                    // Prior to Gingerbread, HttpUrlConnection was unreliable.
                    // See: http://android-developers.blogspot.com/2011/09/androids-http-clients.html
                    Class<Object> AndroidHttpClient = null;
                    stack = new HttpClientStack(AndroidHttpClient.newInstance(userAgent());
                }
            }

            Network network = new BasicNetwork(stack);

            RequestQueue queue = new RequestQueue(new DiskBasedCache(cacheDir, DEFAULT_DISK_USAGE_BYTES), network,
                    DEFAULT_NETWORK_THREAD_POOL_SIZE);
            queue.start();

            return queue;
        }

        /**
         * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
         *
         * @param context A {@link Context} to use for creating the cache dir.
         * @return A started {@link RequestQueue} instance.
         */
        public RequestQueue newRequestQueue context1 context) {
            return newRequestQueue(context, null);
        }

    }

    private static Object userAgent() {
        return null;
    }

}
