'use strict';
const AWS = require('aws-sdk');
const db = new AWS.DynamoDB.DocumentClient({ apiVersion: '2012-08-10' });
const uuid = require('uuid/v4');

const nasaTable = process.env.NASA_TABLE;

//  response
function response(statusCode, body) {
  return {
    statusCode: statusCode,
     headers: {
            "Access-Control-Allow-Headers" : "Content-Type",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
        },
    body: JSON.stringify(body)
  };
}
function sortByDate(a, b) {
  if (a.did > b.did) {
    return -1;
  } else return 1;
}

module.exports.createNasa = (event, context, callback) => {
  const reqBody = JSON.parse(event.body);

  // if (
  //   !reqBody.title ||
  //   reqBody.title.trim() === '' ||
  //   !reqBody.monthOrder ||
  //   reqBody.monthOrder.trim() === ''
  // ) {
  //   return callback(
  //     null,
  //     response(400, {
  //       error: 'title and date required fields'
  //     })
  //   );
  // }

  const nasaItem = {
    // id:   uuid(), //id,
    id: reqBody.id,
    // createdAt: new Date().toISOString(), 
    title: reqBody.title,
    date: reqBody.date,  
    copyright: reqBody.copyright,
    explanation: reqBody.explanation,
    url: reqBody.url,
    hdurl: reqBody.hdurl,
    media_type: reqBody.media_type
  };

  return db
    .put({
      TableName: nasaTable,
      Item: nasaItem
    })
    .promise()
    .then(() => {
      callback(null, response(201, nasaItem));
    })
    .catch((err) => response(null, response(err.statusCode, err)));
};

// Get all nasa
module.exports.getAllNasa = (event, context, callback) => {
  return db
    .scan({
      TableName: nasaTable,
      Limit: 200       // LIMIT TEMPORARY FOR DEVELOPMENT
    })
    .promise()
    .then((res) => {
      callback(null, response(200, res.Items.sort(sortByDate)));

    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};

// Get # limit of nasa
module.exports.getNasa = (event, context, callback) => {
  const numberOfNasa = event.pathParameters.number;
  const params = {
    TableName: nasaTable,
    Limit: numberOfNasa
  };
  return db
    .scan(params)
    .promise()
    .then((res) => {
      const response = {
        statusCode: 200,
        headers: {
        "Access-Control-Allow-Origin" : "*", // Required for CORS support to work
        "Access-Control-Allow-Credentials" : true // Required for cookies, authorization headers with HTTPS
        }
      }
      // callback(null, response);
      callback(null, response(200, res.Items.sort(sortByDate)));
    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};

// Get one nasaItem
module.exports.getNasa = (event, context, callback) => {
  const id = event.pathParameters.id;

  const params = {
    Key: {
      id: id
    },
    TableName: nasaTable
  };

  return db
    .get(params)
    .promise()
    .then((res) => {
      if (res.Item) callback(null, response(200, res.Item));
      else callback(null, response(404, { error: 'Apod not found' }));
    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};

// Update nasaItem
module.exports.updateNasa = (event, context, callback) => {
  const id = event.pathParameters.id;
  const reqBody = JSON.parse(event.body);
  const { title, date, copyright, explanation, url, hdurl, media_type } = reqBody;

 
  const params = {
    Key: {
      id: id
    },
    TableName: nasaTable,
    ConditionExpression: 'attribute_exists(id)',
    UpdateExpression: 'SET title = :title,  date = :date, copyright = :copyright, explanation = :explanation, url = :url, hdurl = :hdurl, media_type = :media_type,',
    ExpressionAttributeValues: { 
    ':title':  title,
    ':date':  date,
    ':copyright':  copyright,
    ':explanation':  explanation,
    ':url':  url,
    ':hdurl': hdurl, 
    ':media_type': media_type
    },
    ReturnValues: 'ALL_NEW'
  };
  console.log('nasa apod updated');

  return db
    .update(params)
    .promise()
    .then((res) => {
      console.log(res);
      callback(null, response(200, res.Attributes));
    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};

// Delete a nasa Apod
module.exports.deletePost = (event, context, callback) => {
  const id = event.pathParameters.id;
  const params = {
    Key: {
      id: id
    },
    TableName: nasaTable
  };
  return db
    .delete(params)
    .promise()
    .then(() =>
      callback(null, response(200, { body: 'Nasa APOD deleted successfully' }))
    )
    .catch((err) => callback(null, response(err.statusCode, err)));
};
 
