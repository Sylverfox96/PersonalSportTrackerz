# PersonalSportTrackerz

This app was created Mohamed

## Development

After starting the application it is accessible under `localhost:8080`.

Go to `http://localhost:8080/swagger-ui/index.html` for API Documentation

## Build

The application can be built using the following command:

```
mvnw clean package
```

Start your application with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./target/PersonalSportTrackerz-0.0.1-SNAPSHOT.jar
```