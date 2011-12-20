package com.denormans.googleanalyticsgwt.api;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;

import javax.annotation.Nullable;

public final class GoogleAnalytics extends JavaScriptObject {
  private static boolean IsAlreadyInjected = false;

  /* Must have zero-arg constructor */
  protected GoogleAnalytics() {
  }

  public static void init() {
    injectAnalytics(null);
  }

  public static void init(String defaultTrackerID) {
    injectAnalytics(defaultTrackerID);
  }

  private static boolean isSSL() {
    if (Window.Location.getProtocol().equals("https:")) {
      return true;
    }
    return false;
  }

  private static boolean injectAnalytics(@Nullable final String defaultTrackerID) {
    if (defaultTrackerID != null) {
      setupDefaultTrackerID(defaultTrackerID);
    }

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
    script.setAttribute("async", "true");

    doc.getBody().appendChild(script);

    return false;
  }

  private static native void setupDefaultTrackerID(final String defaultTrackerID) /*-{
    $wnd._gaq = $wnd._gaq || [];
    $wnd._gaq.push(['_setAccount', defaultTrackerID]);
  }-*/;

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
   * @return A new page tracker with the given ID, if any
   *
   * @deprecated Use {@link #createTracker(String, String)} or {@link #withTracker(String, AsyncTrackerCommand)} instead
   */
  @Deprecated
  public synchronized static GoogleAnalyticsTracker getTracker(final String trackerID) {
    final GoogleAnalytics googleAnalytics = get();
    if (googleAnalytics == null) {
      return null;
    }

    return googleAnalytics.getTrackerJS(trackerID);
  }

  private native GoogleAnalyticsTracker getTrackerJS(final String trackerID) /*-{
    return this._getTracker(trackerID);
  }-*/;

  /**
   * Execute the given command with the default tracker.
   *
   * @param command The command to execute
   */
  public static void withTracker(final AsyncTrackerCommand command) {
    withTracker("", command);
  }

  /**
   * Execute the given command with the tracker.
   *
   * @param trackerName The tracker name
   * @param command The command to execute
   */
  public static native void withTracker(final String trackerName, final AsyncTrackerCommand command) /*-{
    $wnd._gaq = $wnd._gaq || [];
    $wnd._gaq.push(function() {
      @com.denormans.googleanalyticsgwt.api.GoogleAnalytics::executeWithTracker(Ljava/lang/String;Lcom/denormans/googleanalyticsgwt/api/AsyncTrackerCommand;)(trackerName, command);
    });
  }-*/;

  private static void executeWithTracker(String trackerName, final AsyncTrackerCommand command) {
    GoogleAnalytics googleAnalytics = get();
    command.execute(googleAnalytics, googleAnalytics.getTrackerByName(trackerName));
  }

  /**
   * Creates the default page tracker with the given ID.
   *
   * @param trackerID The tracker ID
   * @return A new event tracker with the given ID
   */
  public native GoogleAnalyticsTracker createDefaultTracker(final String trackerID) /*-{
    return this._createTracker(trackerID);
  }-*/;

  /**
   * Creates a page tracker with the given ID.
   *
   * @param trackerID The tracker ID
   * @param trackerName The name of the tracker to be retrieved later
   * @return A new event tracker with the given ID
   */
  public native GoogleAnalyticsTracker createTracker(final String trackerID, final String trackerName) /*-{
    return this._createTracker(trackerID, trackerName);
  }-*/;

  /**
   * Retrieves the default tracker.
   *
   * @return The default event tracker if available, otherwise <tt>null</tt>
   */
  public native GoogleAnalyticsTracker getDefaultTracker() /*-{
    return this._getTrackerByName();
  }-*/;

  /**
   * Retrieves a tracker by name.
   *
   * @param trackerName The name of the tracker to retrieve
   *
   * @return The event tracker if available, otherwise <tt>null</tt>
   */
  public native GoogleAnalyticsTracker getTrackerByName(final String trackerName) /*-{
    return this._getTrackerByName(trackerName);
  }-*/;

  /**
   * Clear out the last octet of the IP address
   */
  public native void anonymizeIP() /*-{
    this._anonymizeIp();
  }-*/;

}
