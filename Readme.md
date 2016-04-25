# Registration and Collector service
### Requirements
To run server you should have been installed on your localhost:

1. Java 8
2. Gradle
3. Mongo db

### Configuration
To configure application to run you should set up `application.properties` file with correct data:
```
mongo.db.name=harvester
mongo.db.server=localhost
server.port=8081
```
After that you need run in command line inside root project folder
```sh
$ gradle bootRun
```
It is better to run application in separate terminal like **nohup**. To do it call:
```sh
$ nohup gradle bootRun &
$ press any key if you want to store logs in nohup.out
```

Application will be started at `server.port.`

###API


All API methods:
* **GET** [/healthcheck]() - returns string with application version
* **GET** [/harvester/registration? serverUrl=http://xxx & ping=7 & log=100]() -
Register new HyraxInstance. Check it existence and check Reporter path. Setting up ping and log lines parameter.
If such Hyrax instance had been already registered, add new record and make all previous records inactive.
Returns created db record.
* **GET** [/harvester/registration? serverUrl=http://xxx & reporterUrl=http://xxx & ping=7 & log=100]() -
 Same as previous call, but setting up custom **reporterUrl**. If this parameter is missed, reporter url is equals
 to server url.
* **GET** [/harvester/allHyraxInstances]() - returns list of all **active** registered hyrax instances
* **GET** [/harvester/allHyraxInstances?onlyActive=false]() - returns list of all **active** and **inactive**
 registered hyrax instances. Parameter **onlyActive** is _true_ by default.
* **GET** [/harvester/logLines? hyraxInstanceName=http://xxx]() - returns list of all log lines which was
harvestered for specific Hyrax instance
* **GET** [/harvester/logLines/string? hyraxInstanceName=http://xxx]() - returns string representation of
list of all log lines which was harvestered for specific Hyrax instance