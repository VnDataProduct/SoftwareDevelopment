
###############################################################################
# Build Click Count Job
###############################################################################
# Get Click Count job and compile it
FROM gradle:latest AS builder
WORKDIR /opt/flink-playground-clickcountjob
COPY . .
RUN gradle build


###############################################################################
# Build Operations Playground Image
###############################################################################
FROM apache/flink:1.16.0-scala_2.12-java11
WORKDIR /opt/flink/bin
# Copy Click Count Job
COPY --from=builder /opt/flink-playground-clickcountjob/build/libs/flink-playground-clickcountjob-*.jar /opt/ClickCountJob.jar
