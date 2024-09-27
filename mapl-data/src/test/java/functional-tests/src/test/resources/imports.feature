Feature: inject   into feature files

  Scenario:
  # ############################## #CREDENTIALS
   # * def headerInfo = { Authorization: '#(read("classpath:auth/token.txt"))',Cookie: '#(read("classpath:auth/cookies.txt"))' }

    * def java = call read('classpath:utils/JavaSetup.js')
    * def js = call read('classpath:utils/JSMethods.js')


    * def getRandomId = call read('classpath:utils/getRandomId.feature')