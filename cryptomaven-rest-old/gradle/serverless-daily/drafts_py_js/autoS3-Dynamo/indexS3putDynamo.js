const AWS = require('aws-sdk');
const s3 = new AWS.S3();
const documentClient = new AWS.DynamoDB.DocumentClient();

exports.handler = async (event) => {
    let statusCode = 0;
    let responseBody = '';

    const { name } = event.Records[0].s3.bucket;
    const { key } = event.Records[0].s3.object;

    const getObjectParams = {
        Bucket: name,
        Key: key
    };

    try {
        const s3Data = await s3.getObject(getObjectParams).promise();
        const dailyStr = s3Data.Body.toString();
        const dailyJSON = JSON.parse(dailyStr);
        console.log(`prices_bitcoin ::: ${dailyStr}`);

        await Promise.all(dailyJSON.map(async daily => {
            const { 
                id,
                did,
                date,
                author,
                cat3,
                title,
                post,
                blogcite,
               } = daily

            const putParams = {
                TableName: "dailytech",
                Item: {
                    id: id, 
                    did: did,
                    date: date,
                    author: author,
                    cat3: cat3,
                    title: title,
                    post: post,  
                    blogcite: blogcite 
                }
            };

            await documentClient.put(putParams).promise();

        }));

        responseBody = 'Succeeded adding daily tech posts';
        statusCode = 201;

    } catch (err) {
        responseBody = 'Error adding daily tech posts';
        statusCode = 403;
    }

    const response = {
        statusCode: statusCode,
        body: responseBody
    };

    return response;
};