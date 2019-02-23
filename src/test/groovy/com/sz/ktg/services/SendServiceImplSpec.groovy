package com.sz.ktg.services

import com.sz.ktg.models.Request
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class SendServiceImplSpec extends Specification{
    def RESULT = "result"
    def GET_ME = "getMe"
    def LINK = "http://url/"
    def request
    def requestService

    def setup() {
        request = new Request(
                url: LINK,
                accessToken: "accessToken")
        requestService = Spy(SendServiceImpl)
        requestService.request = request
    }

    def testGetUrlForRequest() {
        given:
        def result = requestService.getUrlForRequest(GET_ME)
        expect:
        result == "${LINK}accessToken/getMe"
    }

    def testSend() {
        given:
        def httpURLConnection = Mock(HttpURLConnection) {
            getResponseCode() >> 200
            connect() >> {}
            getInputStream() >> new ByteArrayInputStream(RESULT.getBytes(StandardCharsets.UTF_8))
        }
        requestService.getHttpURLConnection(GET_ME) >> httpURLConnection
        def result = requestService.send(GET_ME)
        expect:
        result == RESULT
    }
}
