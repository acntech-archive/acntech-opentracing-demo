# Opentracing and Jaeger demo with Spring Boot

This is a small demo project to show tracing through [Opentracing](https://opentracing.io/) of microservice built in Spring Boot in [Jaeger](https://www.jaegertracing.io/).

## How to run the demo

1. Run Jaeger All-in-one Docker image
```console
$ docker run -d --name jaeger \
  -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  -p 9411:9411 \
  jaegertracing/all-in-one:1.8
  ```
2. Run the three Spring Boot services within this project.
```
$ mvn spring-boot:run
```

3. Open http://localhost:8080/hello in a browser and trigger a request
4. Go to http://localhost:16686 and search for traces on the 'service-a' application.

## Project Structure

This is a simple demonstrator consisting of three very simple Spring Boot applications. The applications interacts with each other in the following manner.

![Services overview](https://user-images.githubusercontent.com/1286207/53803045-60226d00-3f3b-11e9-83bd-4e536adf5de5.png)


## What you should see in Jaeger

In Jaeger you should be able to see the traces from the service calls initates by loading the `/hello` endpoint of service-a.

![Tracing of requests initiated by service-a](https://user-images.githubusercontent.com/1286207/53803043-5f89d680-3f3b-11e9-89a6-42e8e39b010b.png)

You will also be able to see a visualisation of the dependencies between the services.

![Dependencies between services](https://user-images.githubusercontent.com/1286207/53803040-5f89d680-3f3b-11e9-9833-130504e52780.png)
