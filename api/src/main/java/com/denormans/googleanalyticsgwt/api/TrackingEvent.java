/*
 * Copyright (c) 2012 deNormans
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.denormans.googleanalyticsgwt.api;

public class TrackingEvent {
  private String category;
  private String action;
  private String label;
  private Integer value;
  private boolean nonInteraction;

  public TrackingEvent() {
  }

  @Deprecated
  public TrackingEvent(final String category, final String action) {
    this.category = category;
    this.action = action;
  }

  @Deprecated
  public TrackingEvent(final String category, final String action, final String label) {
    this.category = category;
    this.action = action;
    this.label = label;
  }

  @Deprecated
  public TrackingEvent(final String category, final String action, final String label, final int value) {
    this.category = category;
    this.action = action;
    this.label = label;
    this.value = value;
  }

  public String getCategory() {
    return category;
  }

  /**
   * The general event category, e.g. Videos
   */
  public TrackingEvent category(String category) {
    this.category = category;
    return this;
  }

  /**
   * The general event category, e.g. Videos
   */
  public TrackingEvent category(AnalyticsConstant category) {
    return category(category.getAnalyticsName());
  }

  public String getAction() {
    return action;
  }

  /**
   * The action for the event, e.g. Play
   */
  public TrackingEvent action(String action) {
    this.action = action;
    return this;
  }

  /**
   * The action for the event, e.g. Play
   */
  public TrackingEvent action(AnalyticsConstant action) {
    return action(action.getAnalyticsName());
  }

  public String getLabel() {
    return label;
  }

  /**
   * An optional description of the event
   */
  public TrackingEvent label(String label) {
    this.label = label;
    return this;
  }

  public boolean hasValue() {
    return value != null;
  }

  public int getValue() {
    return hasValue() ? value : 0;
  }

  /**
   * An optional value that will get aggregated
   */
  public TrackingEvent value(int value) {
    this.value = value;
    return this;
  }

  public boolean isNonInteraction() {
    return nonInteraction;
  }

  public TrackingEvent nonInteraction(boolean nonInteraction) {
    this.nonInteraction = nonInteraction;
    return this;
  }

  @Override
  public String toString() {
    return super.toString() + "[category='" + category + "']" + "[action='" + action + "']" + "[label='" + label + "']" + "[value=" + value + "]" + "[nonInteraction=" + nonInteraction + "]";
  }
}
