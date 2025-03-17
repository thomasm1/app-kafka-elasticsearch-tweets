'use strict' 
// thomasm1 acct; dailytech; 
// 

const AWS = require('aws-sdk');

AWS.config.update({ region: "us-east-1" });


exports.handler = async (event, context) => { 
    const documentClient = new AWS.DynamoDB.DocumentClient({ region: "us-east-1" });  

    let responseBody = "";
    let statusCode = 0;

    const params = {
        TableName: "posts"
    }

    try {
        const data = await documentClient.scan(params).promise();
        responseBody = JSON.stringify(data.Items);
        statusCode = 200;
        console.log(data);
    } catch (err) {
        responseBody = `Unable to get blog posts, oops!: ${err}`;
        statusCode = 403;
        console.log(err);
    }  
     const response = {
    statusCode: statusCode,
    headers: {
      "Content-Type": "application/json",
      "access-control-allow-origin":"*"
    },
    body: responseBody
  };

  return response;
}; 