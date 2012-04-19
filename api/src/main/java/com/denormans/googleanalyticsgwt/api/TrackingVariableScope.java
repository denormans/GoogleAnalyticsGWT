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

public enum TrackingVariableScope {
  /** The client that visits the site, such as the browser or mobile phone operated by a person */
  Visitor(1),

  /** The period of time during which the visitor is active on the site */
  Session(2),

  /** Activity on the user's behalf which sends a GIF request to the Analytics servers */
  Page(3);

  private int level;

  TrackingVariableScope(final int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }

  @Override
  public String toString() {
    return super.toString() + "(" + level + ")";
  }
}
