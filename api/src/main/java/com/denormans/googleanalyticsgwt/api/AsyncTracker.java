package com.denormans.googleanalyticsgwt.api;

/**
 * This is a convenience class for tracking pages and events using the asynchronous interface.
 */
public class AsyncTracker {

  private AsyncTracker() {}

  /**
   * Track a page view.
   *
   * @param page The page view to track
   */
  public static void trackPageview(final String page) {
    GoogleAnalytics.withTracker(new AsyncTrackerCommand() {
      @Override
      public void execute(GoogleAnalytics analytics, GoogleAnalyticsTracker tracker) {
        tracker.trackPageview(page);
      }
    });
  }

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param trackingEvent The tracking event
   */
  public static void trackEvent(final TrackingEvent trackingEvent) {
    GoogleAnalytics.withTracker(new AsyncTrackerCommand() {
      @Override
      public void execute(final GoogleAnalytics analytics, final GoogleAnalyticsTracker tracker) {
        tracker.trackEvent(trackingEvent);
      }
    });
  }

  /**
   * Sets a custom variable to the tracker.
   *
   * @param index    The 0-based index of the custom variable
   * @param variable The variable to track
   */
  public static void setCustomVariable(final int index, final TrackingVariable variable) {
    GoogleAnalytics.withTracker(new AsyncTrackerCommand() {
      @Override
      public void execute(final GoogleAnalytics analytics, final GoogleAnalyticsTracker tracker) {
        tracker.setCustomVariable(index, variable);
      }
    });
  }

}
