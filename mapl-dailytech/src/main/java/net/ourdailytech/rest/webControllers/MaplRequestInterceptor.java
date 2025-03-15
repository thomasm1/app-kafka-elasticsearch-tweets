package net.ourdailytech.rest.webControllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MaplRequestInterceptor implements ClientHttpRequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(MaplRequestInterceptor.class);


    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution execution) throws IOException {

            logger.info("Request details");
            logger.info(" URI - {}", httpRequest.getURI());
            logger.info("Headers - {}", httpRequest.getHeaders());
            logger.info("Method - {}", httpRequest.getMethod());

            ClientHttpResponse response = execution.execute(httpRequest, body);

            MaplClientHttpResponse maplClientHttpResponse = new MaplClientHttpResponse(response);

            logger.info("response details");
            logger.info("status - {}", maplClientHttpResponse.getStatusCode());
            logger.info("Body - {}", getResponseBody(maplClientHttpResponse.getBody()));

            return maplClientHttpResponse;
        }

    private String getResponseBody(InputStream responseBody) {

        StringBuilder inputStringBuilder = new StringBuilder();

        try  (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseBody, StandardCharsets.UTF_8)))
        {
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
            return inputStringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //IOUtils.
    }


    }
