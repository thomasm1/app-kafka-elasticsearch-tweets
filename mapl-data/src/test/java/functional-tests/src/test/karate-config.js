function fn() {
    var env = karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'prod';
    }
    karate.log('karate.env system property was:', env);
    var system = karate.baseUrl = karate.baseUrl || "http://localhost:8080"
    var pw = process.env.ORACLE_DB_PASSWORD
    console.log("----------pw----------" + pw)
    var spring_datasource_url = karate.spring_datasource_url || ''
    var spring_datasource_username = karate.spring_datasource_username || ''
    var spring_datasource_password = karate.spring_datasource_password || pw

    if (env === 'dev' || env === 'mysql') {
        baseUrl = 'http://localhost:8080/';

        // spring_datasource_url = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
        spring_datasource_url = "jdbc:mysql://localhost:3306/groot?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false"
        spring_datasource_username = "root"
        spring_datasource_password = process.env.GLOBAL_PASSWORD
    } else if (env === 'prod') {
        // baseUrl = 'http://34.199.129.2/8080/';
        baseUrl = 'http://localhost:8080/';
        spring_datasource_url = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
        spring_datasource_username = "thomas"
        spring_datasource_password = pw

        var config = {
            env: env,
            baseUrl: baseUrl,
            spring_datasource_url: spring_datasource_url,
            spring_datasource_username: spring_datasource_username,
            spring_datasource_password: spring_datasource_password,

        }
        karate.configure('apiKey', config.apiKey);
        // var accessToken = karate.callSingle('classpath:utils/CreateToken.feature', config).authToken
        // karate.configure('headers', {Authorization: 'Token ' + accessToken})
        return config;
    }
}
