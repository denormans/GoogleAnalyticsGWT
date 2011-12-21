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

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public final class GoogleAnalyticsTracker extends JavaScriptObject {
  public static int MaxCustomVariables = 5;

  /* Must have zero-arg constructor */
  protected GoogleAnalyticsTracker() {
  }

  /**
   * Returns the name the tracker was given when it was created.
   */
  public native String getName() /*-{
    return this._getName();
  }-*/;

  /**
   * Returns the Google Analytics account ID for this tracker.
   */
  public native String getAccount() /*-{
    return this._getAccount();
  }-*/;

  /**
   * Returns the GATC version number
   */
  public native String getVersion() /*-{
    return this._getVersion();
  }-*/;

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
    if (trackingEvent.hasValue()) {
      trackEventJS(trackingEvent.getCategory(), trackingEvent.getAction(), trackingEvent.getLabel(), trackingEvent.getValue(), trackingEvent.isNonInteraction());
    } else {
      trackEventJS(trackingEvent.getCategory(), trackingEvent.getAction(), trackingEvent.getLabel(), trackingEvent.isNonInteraction());
    }
  }

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category The general event category, e.g. Videos
   * @param action   The action for the event, e.g. Play
   */
  @Deprecated
  public void trackEvent(final String category, final String action) {
    trackEventJS(category, action, null, false);
  }

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category The general event category, e.g. Videos
   * @param action   The action for the event, e.g. Play
   * @param label    A description of the event
   * @deprecated Use {@link #trackEvent(TrackingEvent)} instead
   */
  @Deprecated
  public void trackEvent(final String category, final String action, final String label) {
    trackEventJS(category, action, label, false);
  }

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category The general event category, e.g. Videos
   * @param action   The action for the event, e.g. Play
   * @param label    An optional description of the event
   * @param value    An optional value that will get aggregated
   * @deprecated Use {@link #trackEvent(TrackingEvent)} instead
   */
  @Deprecated
  public void trackEvent(final String category, final String action, final String label, final int value) {
    trackEventJS(category, action, label, value, false);
  }

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category       The general event category, e.g. Videos
   * @param action         The action for the event, e.g. Play
   * @param label          An optional description of the event
   * @param nonInteraction An optional value to indicate that the event should not be used in bounce rate calcs
   */
  private native void trackEventJS(final String category, final String action, @Nullable final String label, final boolean nonInteraction) /*-{
    this._trackEvent(category, action, label, null, nonInteraction);
  }-*/;

  /**
   * Tracks an event that doesn't correspond to a page view.
   *
   * @param category       The general event category, e.g. Videos
   * @param action         The action for the event, e.g. Play
   * @param label          An optional description of the event
   * @param value          An optional value that will get aggregated
   * @param nonInteraction An optional value to indicate that the event should not be used in bounce rate calcs
   */
  private native void trackEventJS(final String category, final String action, @Nullable final String label, final int value, final boolean nonInteraction) /*-{
    this._trackEvent(category, action, label, value, nonInteraction);
  }-*/;

  /**
   * Returns the custom variable value
   */
  public String getCustomVariableValue(final int index) {
    checkCustomVariableIndex(index);

    return getCustomVariableValue(index);
  }

  public native String getCustomVariableValueJS(final int index) /*-{
    return this._getVisitorCustomVar(index);
  }-*/;

  /**
   * Sets the custom variables with the given tracking data
   *
   * @param trackingData The tracking data
   */
  public void setCustomVariables(final List<TrackingVariable> trackingData) {
    clearNumCustomVariables();
    for (final TrackingVariable trackingVariable : trackingData) {
      addCustomVariable(trackingVariable);
    }
  }

  /**
   * Sets the custom variables with the given tracking data
   *
   * @param trackingData The tracking data
   */
  public void setCustomVariables(final TrackingVariable... trackingData) {
    setCustomVariables(Arrays.asList(trackingData));
  }

  /**
   * Adds a custom variable
   *
   * @param variable The tracking variable
   *
   * @return Whether or not the custom variable was set
   */
  public boolean addCustomVariable(final TrackingVariable variable) {
    return setCustomVariable(getNumCustomVariables()+1, variable);
  }

  /**
   * Sets a custom variable to the tracker.
   *
   * @param index    The 0-based index of the custom variable
   * @param variable The variable to track
   *
   * @return Whether or not the custom variable was set
   */
  public boolean setCustomVariable(final int index, final TrackingVariable variable) {
    checkCustomVariableIndex(index);

    if (index > getNumCustomVariables()) {
      setNumCustomVariables(index);
    }

    if (variable.hasScope()) {
      return setCustomVariableJS(index, variable.getName(), variable.getValue(), variable.getScope().getLevel());
    } else {
      return setCustomVariableJS(index, variable.getName(), variable.getValue());
    }
  }

  /**
   * Sets a custom variable to the tracker.
   *
   * @param index The 0-based index of the custom variable
   * @param name  The name of the custom variable
   * @param value The value of the custom variable
   * @param scope The scope of the custom variable
   *
   * @return Whether or not the custom variable was set
   *
   * @deprecated Use {@link #setCustomVariable(int, TrackingVariable)} instead
   */
  @Deprecated
  public boolean setCustomVariable(final int index, final String name, final String value, final TrackingVariableScope scope) {
    checkCustomVariableIndex(index);

    if (scope != null) {
      return setCustomVariableJS(index, name, value, scope.getLevel());
    } else {
      return setCustomVariableJS(index, name, value);
    }
  }

  /**
   * Sets the custom variable on the tracker with default scope.
   *
   * @param index The 0-based variable index
   * @param name  The name of the custom variable
   * @param value The value of the custom variable
   *
   * @return Whether or not the custom variable was set
   */
  private native boolean setCustomVariableJS(final int index, final String name, final String value) /*-{
    return this._setCustomVar(index+1, name, value);
  }-*/;

  /**
   * Sets the custom variable on the tracker.
   *
   * @param index The 0-based variable index
   * @param name  The name of the custom variable
   * @param value The value of the custom variable
   * @param scope The scope of the custom variable (see {@link TrackingVariableScope} enum).
   *
   * @return Whether or not the custom variable was set
   */
  private native boolean setCustomVariableJS(final int index, final String name, final String value, final int scope) /*-{
    return this._setCustomVar(index+1, name, value, scope);
  }-*/;

  /**
   * Delete the given custom variable
   */
  public void deleteCustomVariable(final int index) {
    checkCustomVariableIndex(index);

    deleteCustomVariableJS(index);

    if (index == getNumCustomVariables()-1) {
      setNumCustomVariablesJS(index-1);
    }
  }

  private native void deleteCustomVariableJS(final int index) /*-{
    this._deleteCustomVar(index+1);
  }-*/;

  /**
   * Delete the last custom variable
   */
  public void deleteLastCustomVariable() {
    deleteCustomVariable(getNumCustomVariables()-1);
  }

  public native int getNumCustomVariables() /*-{
    return this.__numCustomVariables || 0;
  }-*/;

  public void setNumCustomVariables(final int size) {
    if (size < 0 || size > MaxCustomVariables) {
      throw new IndexOutOfBoundsException("size: " + size + ", max: " + MaxCustomVariables);
    }

    setNumCustomVariablesJS(size);
  }

  private native void setNumCustomVariablesJS(final int size) /*-{
    this.__numCustomVariables = size;
  }-*/;

  public void clearNumCustomVariables() {
    setNumCustomVariablesJS(0);
  }

  private void checkCustomVariableIndex(final int index) {
    if (index < 0 || index >= MaxCustomVariables) {
      throw new IndexOutOfBoundsException("index: " + index + ", max: " + MaxCustomVariables);
    }
  }
}
