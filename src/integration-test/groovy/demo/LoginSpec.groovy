package demo

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

@Integration
class LoginSpec extends GebSpec {

    def "login"() {
        when:
        browser.go '/login/auth'
        LoginPage page = browser.page LoginPage
        page.login('sherlock', 'secret')

        then:
        true
    }
}
