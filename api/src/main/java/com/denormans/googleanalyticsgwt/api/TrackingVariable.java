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

public class TrackingVariable {
  private String name;
  private String value;
  private TrackingVariableScope scope;

  public TrackingVariable() {
  }

  @Deprecated
  public TrackingVariable(final String name, final String value, final TrackingVariableScope scope) {
    this.name = name;
    this.value = value;
    this.scope = scope;
  }

  public String getName() {
    return name;
  }

  /**
   * The name of the custom variable
   */
  public TrackingVariable name(String name) {
    this.name = name;
    return this;
  }
  /**
   * The name of the custom variable
   */
  public TrackingVariable name(AnalyticsConstant name) {
    return name(name.getAnalyticsName());
  }

  public String getValue() {
    return value;
  }

  /**
   * The value of the custom variable
   */
  public TrackingVariable value(String value) {
    this.value = value;
    return this;
  }

  public boolean hasScope() {
    return scope != null;
  }

  public TrackingVariableScope getScope() {
    return scope;
  }

  /**
   * The scope of the custom variable
   */
  public TrackingVariable scope(TrackingVariableScope scope) {
    this.scope = scope;
    return this;
  }

  @Override
  public String toString() {
    return super.toString() + "[name='" + name + "']" + "[value='" + value + "']" + "[scope=" + scope + "]" + "";
  }
}
