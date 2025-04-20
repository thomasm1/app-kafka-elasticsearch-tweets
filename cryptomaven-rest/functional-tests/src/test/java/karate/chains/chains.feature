Feature: chains feature api

  Background: background
#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'

    * url baseUrl + '/api/'


  Scenario Outline: '<_path>'
    Given path '<_path>' + '<_var1>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path       | _meth | _stat | _var1     | _var2 | _var3 |

      | chains      | GET   | 200   |           |       |       |
      | chains      | GET   | 200   | /31       |       |       |
      | chains/name | GET   | 200   | /Ethereum |       |       |


#    @Test
#  public void testGetChainByIdNotFound() {
#  when(chainsService.getChain(1L)).thenReturn(null);
#
#  ResponseEntity<ChainDto> response = chainsController.getChain(1L);
#
#  assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
#  assertEquals(null, response.getBody());
#  }
#    @Test
#  public void testGetChainByNameNotFound() {
#  when(chainsService.getChainByName("ethereum")).thenReturn(null);
#
#  ResponseEntity<ChainDto> response = chainsController.getChainByName("ethereum");
#
#  assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
#  assertEquals(null, response.getBody());
#  }