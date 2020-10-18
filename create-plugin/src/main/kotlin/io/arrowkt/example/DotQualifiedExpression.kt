package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.dotQualifiedExpression

// dotQualifiedExpression - extension name
val Meta.dotQualifiedExpression: CliPlugin
    get() =
        "Example" {
            meta(
                    // Handle a dot qualified expression where text in selectorExpression is toString()
                    // See https://meta.arrow-kt.io/apidocs/compiler-plugin/arrow.meta.quotes.expression/-dot-qualified-expression/index.html
                    dotQualifiedExpression(this, { selectorExpression?.text == "toString()" }) { c ->
                        Transform.replace(
                                replacing = c,
                                newDeclaration = """$receiverExpression.toDouble()""".dotQualifiedExpression
                        )
                    }
            )
        }
