# Build Stage
FROM gradle:8.5-jdk21 as builder
WORKDIR /builder

# Copy Gradle files first for better caching
COPY build.gradle.kts settings.gradle.kts /builder/
RUN gradle dependencies --no-daemon  # Cache dependencies

# Copy the rest of the source code
COPY . /builder
RUN ./gradlew build --no-daemon --stacktrace

# Runtime Stage
FROM eclipse-temurin:21-jre as runtime
WORKDIR /app
EXPOSE 8080

# Copy built JAR from the builder stage
COPY --from=builder /builder/build/libs/*.jar app.jar


# Run application
CMD ["java", "-jar", "app.jar"]
