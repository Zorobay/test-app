package test.app

import grails.core.GrailsApplication
import grails.plugins.GrailsPluginManager
import grails.plugins.PluginManagerAware
import org.springframework.http.HttpStatus

import java.nio.charset.MalformedInputException

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    def test() {
        try {
            String body = request.reader.text
        } catch (MalformedInputException e) {
            render(HttpStatus.BAD_REQUEST)
        }
        render(HttpStatus.OK)
    }
}
