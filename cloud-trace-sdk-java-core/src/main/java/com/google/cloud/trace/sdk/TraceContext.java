// Copyright 2014 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.cloud.trace.sdk;

import java.math.BigInteger;

/**
 * Identifies the trace and span and whether it is currently slated to be written out.
 * Potentially forwarded over the wire for use in propagation to child spans.
 */
public class TraceContext {
  private final String traceId;
  private final BigInteger spanId;
  private boolean shouldWrite;

  /**
   * Creates a new trace context with the given identifiers.
   */
  public TraceContext(String traceId, BigInteger spanId, boolean shouldWrite) {
    this.traceId = traceId;
    this.spanId = spanId;
    this.shouldWrite = shouldWrite;
  }

  public String getTraceId() {
    return traceId;
  }

  public BigInteger getSpanId() {
    return spanId;
  }

  public boolean getShouldWrite() {
    return shouldWrite;
  }

  public void setShouldWrite(boolean shouldWrite) {
    this.shouldWrite = shouldWrite;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (shouldWrite ? 1231 : 1237);
    result = prime * result + ((spanId == null) ? 0 : spanId.hashCode());
    result = prime * result + ((traceId == null) ? 0 : traceId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TraceContext other = (TraceContext) obj;
    if (shouldWrite != other.shouldWrite)
      return false;
    if (spanId == null) {
      if (other.spanId != null)
        return false;
    } else if (!spanId.equals(other.spanId))
      return false;
    if (traceId == null) {
      if (other.traceId != null)
        return false;
    } else if (!traceId.equals(other.traceId))
      return false;
    return true;
  }
}
