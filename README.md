Movie manager
=============

This is a demo project illustrating the use of a Javascript front-end and a Java back-end (JEE).
The front-end uses [Backbone.js](http://backbonejs.org/), [Websockets](https://www.websocket.org/), [REST](http://en.wikipedia.org/wiki/Representational_state_transfer) and [Jasmine](http://jasmine.github.io/) for unit testing.

The WAR has been successfully deployed on [JBoss WildFly](http://wildfly.org/downloads/). It doesn't need any specific configuration, just drop the WAR on the `standalone/deployments` folder and access the web app at either

  - [http://localhost:8080/movie/backbone.html](http://localhost:8080/movie/backbone.html) (Backbone.js with Websockets)
  - [http://localhost:8080/movie/rest.html](http://localhost:8080/movie/rest.html) (Backbone.js with REST)
  - [http://localhost:8080/movie/websocket.html](http://localhost:8080/movie/websocket.html) (standard JS with Websockets)

Installation
------------

```sh
$ git clone https://github.com/miladhub/movie-manager-javascript.git movie
$ cd movie
$ mvn clean install
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.659 s
[INFO] Finished at: 2014-07-28T18:20:59+02:00
[INFO] Final Memory: 19M/491M
[INFO] ------------------------------------------------------------------------
$ cp target/movie.war ~/wildfly-8.1.0.Final/standalone/deployments
$ ~/wildfly-8.1.0.Final/bin/standalone.sh
```
