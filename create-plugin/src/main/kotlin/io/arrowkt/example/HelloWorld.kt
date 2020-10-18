package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.namedFunction
import org.jetbrains.kotlin.psi.KtNamedFunction

// example - extension name
val Meta.example: CliPlugin
    get() =
        "Example" {
            meta(
                    // Handle a function with name helloWorld
                    namedFunction(this, { name == "helloWorld" }) { c ->
                        Transform.replace(
                                replacing = c,
                                newDeclaration = replaceBody(c).function
                        )
                    }
            )
        }

// Replace the body of the function
fun replaceBody(function: KtNamedFunction): String {
    val functionName = function.name
    return """
          |//metadebug
          |fun ${functionName}() {
          |   println("I has changed, hello!")
          | }"""
}