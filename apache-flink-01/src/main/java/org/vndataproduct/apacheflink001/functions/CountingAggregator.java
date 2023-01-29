package org.vndataproduct.apacheflink001.functions;

import org.apache.flink.api.common.functions.AggregateFunction;

import org.vndataproduct.apacheflink001.records.ClickEvent;

/**
 * An {@link AggregateFunction} which simply counts {@link ClickEvent}s.
 *
 */
public class CountingAggregator implements AggregateFunction<ClickEvent, Long, Long> {
   @Override
   public Long createAccumulator() {
      return 0L;
   }

   @Override
   public Long add(final ClickEvent value, final Long accumulator) {
      return accumulator + 1;
   }

   @Override
   public Long getResult(final Long accumulator) {
      return accumulator;
   }

   @Override
   public Long merge(final Long a, final Long b) {
      return a + b;
   }
}