class MyTagLib {
    static namespace = "my"
    def image = { attrs, body ->
        out << "<image src=\"../images/grails_logo.png\"/>\n"
    }
}