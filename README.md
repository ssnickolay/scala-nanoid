# Nanoid port for Scala

[![CircleCI](https://circleci.com/gh/ssnickolay/scala-nanoid.svg?style=svg)](https://circleci.com/gh/ssnickolay/scala-nanoid)
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-0.6.17.svg)](https://www.scala-js.org)

Scala port of NanoID ([https://github.com/ai/nanoid](https://github.com/ai/nanoid)), a tiny, secure URL-friendly unique string ID generator.

**Safe.** It uses cryptographically strong random APIs and guarantees a proper distribution of symbols.

**Compact.** It uses a larger alphabet than UUID (A-Za-z0-9_~) and has a similar number of unique IDs in just 21 symbols instead of 36.

### Getting Started

Scala-NanoId is currently available for Scala 2.10, 2.11 and 2.12, and [Scala.js](http://www.scala-js.org/).

Include the following in your sbt file:

```sh
// For Scala.js
libraryDependencies += "com.github.ssnickolay" %%% "scala-nanoid" % "0.1.0"

// For Scala.jvm
libraryDependencies += "com.github.ssnickolay" %% "scala-nanoid" % "0.1.0"
```

### Usage

```
$ 
```

# Publish to Sonatype

```sh
$ sbt +publish
```
