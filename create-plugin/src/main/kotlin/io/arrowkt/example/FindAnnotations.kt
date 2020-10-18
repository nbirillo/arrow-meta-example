package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.namedFunction
import org.jetbrains.kotlin.psi.KtNamedFunction

val Meta.example: CliPlugin
    get() =
        "Example" {
            meta(
                    namedFunction(this, { name == "helloWorld" }) { c ->
                        Transform.replace(
                                replacing = c,
                                newDeclaration = replaceBody(c).function
                        )
                    }
            )
        }

fun replaceBody(function: KtNamedFunction): String {
    val functionName = function.name
    return """
          |//metadebug
          |fun ${functionName}() {
          |   println("I has changed, hello!")
          | }"""
}