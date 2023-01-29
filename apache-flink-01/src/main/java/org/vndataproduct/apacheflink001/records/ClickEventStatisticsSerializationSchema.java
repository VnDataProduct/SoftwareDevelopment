package org.vndataproduct.apacheflink001.records;

import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * A Kafka {@link SerializationSchema} to serialize {@link ClickEventStatistics}s as JSON.
 *
 */
public class ClickEventStatisticsSerializationSchema implements SerializationSchema<ClickEventStatistics> {
   private static final ObjectMapper objectMapper = new ObjectMapper();

   @Override
   public byte[] serialize(ClickEventStatistics event) {
      try {
         //if topic is null, default topic will be used
         return objectMapper.writeValueAsBytes(event);
      } catch (JsonProcessingException e) {
         throw new IllegalArgumentException("Could not serialize record: " + event, e);
      }
   }
}