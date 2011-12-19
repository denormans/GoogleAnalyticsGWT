package com.denormans.googleanalyticsgwt.api;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;

import java.util.HashMap;
import java.util.Map;

public final class GoogleAnalytics extends JavaScriptObject {
    private static final Map<String, GoogleAnalyticsTracker> trackersByID = new HashMap<String, GoogleAnalyticsTracker>();

    private static boolean IsAlreadyInjected = false;

    /* Must have zero-arg constructor */
    protected GoogleAnalytics() {
    }

    public static void init() {
      injectAnalytics();
    }

    private static boolean isSSL() {
      if (Window.Location.getProtocol().equals("https:")) {
        return true;
      }
      return false;
    }

    private static boolean injectAnalytics() {
      if (IsAlreadyInjected) {
        return true;
      }

      IsAlreadyInjected = true;

      boolean isAlreadyLoaded = get() != null;
      if (isAlreadyLoaded) {
        return true;
      }

      String src;
      if (isSSL()) {
        src = "https://ssl.google-analytics.com/ga.js";
      } else {
        src = "http://www.google-analytics.com/ga.js";
      }

      Document doc = Document.get();
      ScriptElement script = doc.createScriptElement();
      script.setSrc(src);
      script.setType("text/javascript");
      doc.getBody().appendChild(script);

      return false;
    }

    /**
     * Return the Google Analytics API
     *
     * @return The API if available, otherwise <tt>null</tt>
     */
    public static native GoogleAnalytics get() /*-{
      return $wnd._gat;
    }-*/;

    /**
     * Creates a page tracker with the given ID.
     *
     * @param trackerID The tracker ID
     *
     * @return A new page tracker with the given ID, if any
     */
    public synchronized static GoogleAnalyticsTracker getTracker(final String trackerID) {
      GoogleAnalyticsTracker tracker = trackersByID.get(trackerID);

      if(tracker == null) {
        final GoogleAnalytics googleAnalytics = get();
        if(googleAnalytics != null) {
          tracker = googleAnalytics.createTracker(trackerID);
          trackersByID.put(trackerID, tracker);
        }
      }

      return tracker;
    }

    /**
     * Creates a page tracker with the given ID.
     *
     * @param trackerID The tracker ID
     *
     * @return A new page tracker with the given ID, if any
     */
    public native GoogleAnalyticsTracker createTracker(final String trackerID) /*-{
      return this._getTracker(trackerID);
    }-*/;
}
