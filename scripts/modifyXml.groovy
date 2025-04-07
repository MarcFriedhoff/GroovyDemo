import groovy.xml.*

import groovy.util.XmlParser
import groovy.xml.MarkupBuilder

// 'inputXml' is passed in from Java via binding
def xml = new XmlParser().parseText(inputXml)

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)

// Rebuilding the XML using the DSL and adding a new book
builder.books {
    xml.book.each { node ->
        book(title: node.@title, author: node.@author)
    }
    book(title: "Fahrenheit 451", author: "Ray Bradbury")
}

return writer.toString()

