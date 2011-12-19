/*
 * Copyright (C) 2010 deNormans
 * http://www.denormans.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of deNormans ("Confidential Information"). You 
 * shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with deNormans.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * DENORMANS OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.denormans.googleanalyticsgwt.api;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.List;

public final class GoogleAnalyticsTracker extends JavaScriptObject {
  public static int MaxCustomVariables = 5;

  /* Must have zero-arg constructor */
  protected GoogleAnalyticsTracker() {
  }

  /**
   * Track a page view.
   *
   * @param page The page view to track
   */
  public native void trackPageview(final String page) /*-{
    this._trackPageview(page);
  }-*/;

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param trackingEvent The tracking event
   */
  public void trackEvent(final TrackingEvent trackingEvent) {
    if(trackingEvent.hasValue()) {
      trackEvent(trackingEvent.getCategory(), trackingEvent.getAction(), trackingEvent.getLabel(), trackingEvent.getValue());
    } else {
      trackEvent(trackingEvent.getCategory(), trackingEvent.getAction(), trackingEvent.getLabel());
    }
  }

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category The general event category, e.g. Videos
   * @param action The action for the event, e.g. Play
   */
  public void trackEvent(final String category, final String action) {
    trackEvent(category, action, null);
  }

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category The general event category, e.g. Videos
   * @param action The action for the event, e.g. Play
   * @param label A description of the event
   */
  public native void trackEvent(final String category, final String action, final String label) /*-{
    this._trackEvent(category, action, label);
  }-*/;

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category The general event category, e.g. Videos
   * @param action The action for the event, e.g. Play
   * @param label An optional description of the event
   * @param value An optional value that will get aggregated
   */
  public native void trackEvent(final String category, final String action, final String label, final int value) /*-{
    this._trackEvent(category, action, label, value);
  }-*/;

  /**
   * Sets the custom variables with the given tracking data
   *
   * @param trackingData The tracking data
   */
  public void setCustomVariables(final List<TrackingVariable> trackingData) {
    int index = 1;
    for(final TrackingVariable trackingVariable: trackingData) {
      setCustomVariable(index++, trackingVariable);
    }
  }

  /**
   * Sets a custom variable to the tracker.
   *
   * @param index The 1-based index of the custom variable
   * @param variable The variable to track
   *
   * @return Whether or not the custom variable was set
   */
  public boolean setCustomVariable(final int index, final TrackingVariable variable) {
    return setCustomVariable(index, variable.getName(), variable.getValue(), variable.getScope());
  }

  /**
   * Sets a custom variable to the tracker.
   *
   * @param index The 1-based index of the custom variable
   * @param name The name of the custom variable
   * @param value The value of the custom variable
   * @param scope The scope of the custom variable
   *
   * @return Whether or not the custom variable was set
   */
  public boolean setCustomVariable(final int index, final String name, final String value, final TrackingVariableScope scope) {
    if(index > MaxCustomVariables) {
      throw new IllegalStateException("Cannot set custom variable with index " + index + ", max of " + MaxCustomVariables);
    }

    return setCustomVariableJS(index, name, value, scope.getLevel());
  }

  /**
   * Sets the custom variable on the tracker.
   *
   * @param index The 1-based variable index
   * @param name The name of the custom variable
   * @param value The value of the custom variable
   * @param scope The scope of the custom variable (see {@link TrackingVariableScope} enum).
   *
   * @return Whether or not the custom variable was set
   */
  private native boolean setCustomVariableJS(final int index, final String name, final String value, final int scope) /*-{
    return this._setCustomVar(index, name, value, scope);
  }-*/;

}
