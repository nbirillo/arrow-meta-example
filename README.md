# Arrow-meta example

A small arrow-meta example for kids. It is a kotlin-compiler plugin which replace the body of `helloWorld` function 
to the following code:

```
fun helloWorld() {
    println("I has changed, hello!")
}
```

## Getting started

Just clone the repo by `git clone https://github.com/nbirillo/arrow-meta-example.git` and build the project. To test 
the plugin run the `main` function from the [Example.kt](https://github.com/nbirillo/arrow-meta-example/blob/main/use-plugin/src/main/kotlin/io/arrowkt/example/Example.kt) file.

If the plugin work correctly you will see the message: `I has changed, hello!` in the terminal.


## Documentation

The [MetaPlugin.kt](https://github.com/nbirillo/arrow-meta-example/blob/main/create-plugin/src/main/kotlin/io/arrowkt/example/MetaPlugin.kt) file contains the main class `MetaPlugin`, 
which defines compiler extensions which will be used. Now it is only `example` extension.

The [HelloWorld.kt](https://github.com/nbirillo/arrow-meta-example/blob/main/create-plugin/src/main/kotlin/io/arrowkt/example/HelloWorld.kt) file contains the extension that was described above.