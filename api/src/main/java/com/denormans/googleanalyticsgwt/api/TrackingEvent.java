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
    return super.toString() + "[category='" + category + "']" + "[action='" + action + "']" + "[label='" + label + "']" + "[value=" + value + "]" + "";
  }
}
