# Registration and Collector service
## Installation

Speicific instructions are for CentOS 6 but are likely valid for
any Linux dist. Later versions of Linux may have a RPM for 
gradle.

1. Java 8 - install this using yum; you may have to use the
   'alternatives' tool to set the correct version of Java. E.G.:
..1. sudo yum install java-1.8.0
..2. sudo alternatives --config java --> then choose java 1.8.0
..3. java -version --> to verify
2. Gradle - get this from http://gradle.org/gradle-download/.
   download the code and install unpack/install in a plce like
   /usr/local. Then set GRADLE_HOME in bashrc (or equiv) to
   point to /usr/local/gradle-<version> and add $GRADLE_HOME/bin
   to PATH. Also note that while 'alternatives' is great for most
   things, you must also set JAVA_HOME as well (and for gradle
   in particular). I used export JAVA_HOMR=/usr/lib/jvm/java-1.8.0.
3. Mongo db - install this using 'yum install mongodb'

## Configuration 
To configure the collector web application, you should set up the
`application.properties` (in ./src/main/resources/) file with the
correct data:

```
mongo.db.name=harvester
mongo.db.server=localhost
server.port=8081
...
```

and then run the 'bootRun' command in the root project folder

```sh
$ gradle bootRun
```

It is better to run the application in a separate terminal using **nohup**.
To do this:

```sh
$ nohup gradle bootRun &
$ press any key if you want to store logs in nohup.out
```

The application will be started at `server.port.`

### API


All API methods:
* **GET** [/healthcheck]() - returns a string with the application version
* **GET** [/harvester/registration? serverUrl=http://xxx & ping=7 &
log=100]() - Register new HyraxInstance. Check it existence and check
Reporter path. Setting up ping and log lines parameter. If such Hyrax
instance had been already registered, add new record and make all
previous records inactive. Returns created db record.
* **GET** [/harvester/registration? serverUrl=http://xxx &
reporterUrl=http://xxx & ping=7 & log=100]() - Same as previous call,
but setting up custom **reporterUrl**. If this parameter is missed,
reporter url is equals to server url.
* **GET** [/harvester/allHyraxInstances]() - returns list of all
    **active** registered hyrax instances
* **GET** [/harvester/allHyraxInstances?onlyActive=false]() - returns
 list of all **active** and **inactive** registered hyrax instances.
 Parameter **onlyActive** is _true_ by default.
* **GET** [/harvester/logLines? hyraxInstanceName=http://xxx]() -
returns list of all log lines which was harvestered for specific Hyrax
instance
* **GET** [/harvester/logLines/string? hyraxInstanceName=http://xxx]()
- returns string representation of list of all log lines which was
harvestered for specific Hyrax instance