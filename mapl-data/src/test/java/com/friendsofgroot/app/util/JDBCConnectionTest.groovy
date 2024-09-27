package com.friendsofgroot.app.util

import com.friendsofgroot.app.config.JDBCConnection
import spock.lang.*

import java.sql.Connection

class JDBCConnectionTest extends Specification {
    def testObj = new JDBCConnection()
    def conn = Mock(Connection)
    def expectedResult
    def setup() {

        testObj.conn = conn
    }

    @Unroll
    def "getConnection"() {
        when:
        expectedResult = JDBCConnection.getConnection()

        then: "then"
        if(expectedResult!=null) {
            with(expectedResult) {

            }
        }
        thrown(NullPointerException)
        where: "where"
        expectedResult << null
    }

    @Unroll
    def "getJDBCKey"() {
        when:
          expectedResult = JDBCConnection.getJDBCKey()

        then: "then"
        if(expectedResult!=null) {
            with(expectedResult) {

            }
        }
        where: "where"
        expectedResult << "expectedResult"
    }
}

