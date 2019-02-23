package com.sz.ktg.services

import com.sz.ktg.interfaces.ISendService
import com.sz.ktg.models.Request

class SendServiceImpl implements ISendService{
    private static final String ENCODING = 'UTF-8'
    private URL url
    private Request request

    String send(String methodName) {
        sendPostRequest(methodName)
    }

    private def getUrlForRequest(String methodName) {
        return String.valueOf("${request.url}${request.accessToken}/${methodName}")
    }

    private def sendPostRequest(String methodName) {
        def conn = getHttpURLConnection(methodName)
        conn.setRequestProperty("Accept", 'application/json')
        conn.setRequestProperty("Content-Type", 'application/json')
        conn.connect()
        conn.responseCode == 200 ? conn.inputStream.getText(ENCODING)
                : conn.errorStream.getText(ENCODING)
    }

    protected def getHttpURLConnection(String methodName) {
        def url = url == null ? new URL(getUrlForRequest(methodName)) : url
        url.openConnection() as HttpURLConnection
    }
}
