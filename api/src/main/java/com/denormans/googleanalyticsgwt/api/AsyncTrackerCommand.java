package com.denormans.googleanalyticsgwt.api;

public interface AsyncTrackerCommand {

  /**
   * Execute the command with the given tracker.
   */
  void execute(GoogleAnalytics analytics, GoogleAnalyticsTracker tracker);

}
