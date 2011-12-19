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

  public TrackingEvent(final String category, final String action) {
    this.category = category;
    this.action = action;
  }

  public TrackingEvent(final String category, final String action, final String label) {
    this.category = category;
    this.action = action;
    this.label = label;
  }

  public TrackingEvent(final String category, final String action, final String label, final int value) {
    this.category = category;
    this.action = action;
    this.label = label;
    this.value = value;
  }

  public String getCategory() {
    return category;
  }

  public String getAction() {
    return action;
  }

  public String getLabel() {
    return label;
  }

  public boolean hasValue() {
    return value != null;
  }

  public int getValue() {
    return hasValue() ? value : 0;
  }

  @Override
  public String toString() {
    return super.toString() + "[category='" + category + "']" + "[action='" + action + "']" + "[label='" + label + "']" + "[value=" + value + "]" + "";
  }
}
