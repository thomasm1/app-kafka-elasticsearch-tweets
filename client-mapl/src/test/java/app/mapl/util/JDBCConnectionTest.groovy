package app.mapl.util

import app.mapl.config.JDBCConnection
import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Connection

class JDBCConnectionTest extends Specification {
    def testObj = new JDBCConnection()
    def conn = Mock(Connection)
    def expectedResult
    def setup() {

        testObj.conn = conn
    }


    @Unroll
    def "getJDBCKey"() {
        when:
          expectedResult = JDBCConnection.getJDBCKey()

        then: "_"
        if(expectedResult!=null) {
            with(expectedResult) {

            }
        }
        where: "_"
        expectedResult << "expectedResult"
    }
}

