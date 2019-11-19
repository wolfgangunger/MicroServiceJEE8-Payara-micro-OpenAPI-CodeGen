### Rest Client

A type safe invocation of HTTP rest endpoints. Specification [here](https://microprofile.io/project/eclipse/microprofile-rest-client)

Example needs to be created.
#create a local postgres db , in my case it's name is unw, same for user and password

### local Env variables
# you need these env variables to run the application
export DB_USER=unw
export DB_PASS=unw
export DB_NAME=unw
export DB_PORT=5432
export DB_HOST=localhost


Run application local:
java -jar target/microservice-jee8-open-api-code-gen-microbundle.jar target/microservice-jee8-open-api-code-gen.war

http://localhost:8080/openapi
http://localhost:8080/unw/openapi-ui/index.html
http://localhost:8080/unw/hello
http://localhost:8080/unw/sample/salesOrders

### OpenAPI Code Generation
# first you need the api yaml file, you find it at
http://localhost:8080/openapi
next copy it to 




## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)


### Config

Configuration of your application parameters. Specification [here](https://microprofile.io/project/eclipse/microprofile-config)

The example class **ConfigTestController** shows you how to inject a configuration parameter and how you can retrieve it programmatically.



### Fault tolerance

Add resilient features to your applications like TimeOut, RetryPolicy, Fallback, bulkhead and circuit breaker. Specification [here](https://microprofile.io/project/eclipse/microprofile-fault-tolerance)

The example class **ResilienceController** has an example of a FallBack mechanism where an fallback result is returned when the execution takes too long.



### Health

The health status can be used to determine if the 'computing node' needs to be discarded/restarted or not. Specification [here](https://microprofile.io/project/eclipse/microprofile-health)

The class **ServiceHealthCheck** contains an example of a custom check which can be integrated to health status checks of the instance.  The index page contains a link to the status data.



### Metrics

The Metrics exports _Telemetric_ data in a uniform way of system and custom resources. Specification [here](https://microprofile.io/project/eclipse/microprofile-metrics)

The example class **MetricController** contains an example how you can measure the execution time of a request.  The index page also contains a link to the metric page (with all metric info)





### Open API

Exposes the information about your endpoints in the format of the OpenAPI v3 specification. Specification [here](https://microprofile.io/project/eclipse/microprofile-open-api)

The index page contains a link to the OpenAPI information of your endpoints.




### Open Tracing

Allow the participation in distributed tracing of your requests through various micro services. Specification [here](https://microprofile.io/project/eclipse/microprofile-opentracing)

Example needs to be created.





