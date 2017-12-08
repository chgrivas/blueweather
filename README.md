# blueweather
Yet another weather retrieval application.

## Usage

### Run application

Use `./gradlew bootRun` to run the application locally.
The default port is 8080.

So a request at: `localhost:8080/api/weather/default` will download the requested file.

### Build artifacts

Use `./gradlew build` to build the application artifacts.

### Clean application

Use `./gradlew clean` to clean the application artifacts.

## API

Use `./gradlew bSUD` in order to build the application API documentation.
The API document can be found at `blueweather-api/build/docs/swaggerui/index.html`.

## Technical description

The requirement was to create an application that will be fetching New York's weather summary during the 30th of October 2017.
A file was requested to be created that will be creating some specific metrics.

The basic implementation choices were:
- the program was created as a web application as it is user friendly enough to use the browser and there are well-known tools that would make it development faster.
- spring boot because it is easy to setup without boilerplate code
- Groovy & spock framework for quick and clear unit tests
- Checks for the wunderground.com daily limits in order to avoid banning according to the used plan
- Configurable values have been extracted in `application.properties` to make it easier to change
- An endpoint was created but all the structure was designed to easily expand with other more generic endpoints the API

# TODO

- Add more unit tests
- Add API level test layer

# Q&A

For questions please contact Christos Grivas <chgrivas7@gmail.com>
