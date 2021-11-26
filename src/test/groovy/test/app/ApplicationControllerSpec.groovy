package test.app

import grails.testing.web.controllers.ControllerUnitTest
import org.grails.plugins.testing.GrailsMockHttpServletRequest
import org.springframework.http.HttpStatus
import spock.lang.Specification

import java.nio.charset.MalformedInputException

class ApplicationControllerSpec extends Specification implements ControllerUnitTest<ApplicationController>{
    void setup() {
    }

    def "test"() {
        given:
            GrailsMockHttpServletRequest request = Mock()
            request.getReader() >> {
                throw new MalformedInputException(1)
            }
        when:
            controller.test()
        then:
            response.status == HttpStatus.BAD_REQUEST.value()
    }
}
