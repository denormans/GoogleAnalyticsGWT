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
