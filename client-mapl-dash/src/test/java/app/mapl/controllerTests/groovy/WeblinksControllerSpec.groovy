package app.mapl.controllerTests.groovy

import app.mapl.models.Weblink
import spock.lang.Specification

class WeblinksControllerSpec extends Specification {
    def setup() {
    }

    def cleanup() {
    }

    def "test createWeblinks"() {
//        given:
//        def weblink = new Weblink( title: "test", url: "http://www.google.com");
//
////
//        when:
//        weblink2 = weblink.create(weblink);
//
//        then:
//        weblink != null
//        weblink2 == weblink
    }

    def "test getWeblinks"() {
        given:
        def weblink = new Weblink( title: "test", url: "http://www.google.com");

        when:
        def t  = weblink.getTitle();
        then:
        t == "test"
    }

    def "test getAllWeblinks"() {
        given:
        def weblink = new Weblink( title: "test", url: "http://www.google.com");

        when:
       def tList = Weblink.findAll();
        then:
        tList != null
    }

    def "test updateWeblinks"() {
//        given:
//        def weblink = new Weblink( title: "test", url: "http://www.google.com");
//
//        when:
//        weblink.update(title: "test2");
//
//        then:
//        weblink.getTitle() == "test2"
    }

    def "test deleteWeblinks"() {
//        given:
//        def weblink = new Weblink( title: "test", url: "http://www.google.com");
//
//        when:
//      weblink.delete();
//
//        then:
//        weblink == null
    }
}
