package org.vndataproduct.apacheflink001.functions;

import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import org.vndataproduct.apacheflink001.records.ClickEventStatistics;

import java.util.Date;

/**
 * A simple {@link ProcessWindowFunction}, which wraps a count of {@link ClickEvent}s into an
 * instance of {@link ClickEventStatistics}.
 *
 **/
public class ClickEventStatisticsCollector
      extends ProcessWindowFunction<Long, ClickEventStatistics, String, TimeWindow> {

   @Override
   public void process(
         final String page,
         final Context context,
         final Iterable<Long> elements,
         final Collector<ClickEventStatistics> out) throws Exception {

      Long count = elements.iterator().next();

      out.collect(new ClickEventStatistics(new Date(context.window().getStart()), new Date(context.window().getEnd()), page, count));
   }
}