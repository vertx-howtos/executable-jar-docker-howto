# 1st Docker build stage: build the project with Gradle
FROM gradle:8.11.1-jdk11 AS builder
WORKDIR /project
COPY . /project/
RUN gradle assemble --no-daemon

# 2nd Docker build stage: copy builder output and configure entry point
FROM eclipse-temurin:11
ENV APP_DIR=/application
ENV APP_FILE=container-uber-jar.jar

EXPOSE 8888

WORKDIR $APP_DIR
COPY --from=builder /project/build/libs/*-fat.jar $APP_DIR/$APP_FILE

ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]
