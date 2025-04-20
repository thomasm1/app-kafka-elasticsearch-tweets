'use strict';
// dev-lambda-dailytech urls:
// URL GET-ALL: https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/PROD/posts
// URL GET-ONE:  https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/PROD/post/0113ce28-6087-4eeb-8bf8-acaf2acb0928 


 // URL DELETE: https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/PROD/post/{id} /METHOD/DELETE
// with body:
 // URL POST:  https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/PROD/post
 // URL UPDATE: https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/PROD/post/{id}
const AWS = require('aws-sdk');
const db = new AWS.DynamoDB.DocumentClient({ apiVersion: '2012-08-10' });
const uuid = require('uuid/v4');

const postsTable = process.env.POSTS_TABLE;

//  response
function response(statusCode, body) {
  return {
    statusCode: statusCode,
    body: JSON.stringify(body)
  };
}
function sortByDate(a, b) {
  if (a.did > b.did) {
    return -1;
  } else return 1;
}
 
module.exports.createPost = (event, context, callback) => {
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

  const post = {
    id:   uuid(), //id,
    // createdAt: new Date().toISOString(),
    did: reqBody.did, 
    monthOrder: reqBody.monthOrder,
    title: reqBody.title,
    date: reqBody.date,
    author: reqBody.author,
    cat3: reqBody.cat3, 
    post: reqBody.post,
    blogcite: reqBody.blogcite
  };

  return db
    .put({
      TableName: postsTable,
      Item: post
    })
    .promise()
    .then(() => {
      callback(null, response(201, post));
    })
    .catch((err) => response(null, response(err.statusCode, err)));
};
// Get all posts
module.exports.getAllPosts = (event, context, callback) => {
  return db
    .scan({
      TableName: postsTable
    })
    .promise()
    .then((res) => {
      callback(null, response(200, res.Items.sort(sortByDate)));
    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};

// Get # of posts
module.exports.getPosts = (event, context, callback) => {
  const numberOfPosts = event.pathParameters.number;
  const params = {
    TableName: postsTable,
    Limit: numberOfPosts
  };
  return db
    .scan(params)
    .promise()
    .then((res) => {
      callback(null, response(200, res.Items.sort(sortByDate)));
    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};

// Get one post
module.exports.getPost = (event, context, callback) => {
  const id = event.pathParameters.id;

  const params = {
    Key: {
      id: id
    },
    TableName: postsTable
  };

  return db
    .get(params)
    .promise()
    .then((res) => {
      if (res.Item) callback(null, response(200, res.Item));
      else callback(null, response(404, { error: 'Post not found' }));
    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};

// Update post
module.exports.updatePost = (event, context, callback) => {
  const id = event.pathParameters.id;
  const reqBody = JSON.parse(event.body);
  const { monthOrder, title, date, author, cat3, post, blogcite } = reqBody;

  const params = {
    Key: {
      id: id
    },
    TableName: postsTable,
    ConditionExpression: 'attribute_exists(id)',
    UpdateExpression: 'SET monthOrder = :monthOrder, title = :title, date = :date, author = :author, cat3 = :cat3, post = :post, blogcite = :blogcite',
    ExpressionAttributeValues: {  
    ':monthOrder':  monthOrder,
    ':title':  title,
    ':date':  date,
    ':author':  author,
    ':cat3':  cat3, 
    ':post':  post,
    ':blogcite': blogcite
    },
    ReturnValues: 'ALL_NEW'
  };
  console.log('post updated');

  return db
    .update(params)
    .promise()
    .then((res) => {
      console.log(res);
      callback(null, response(200, res.Attributes));
    })
    .catch((err) => callback(null, response(err.statusCode, err)));
};
// Delete a post
module.exports.deletePost = (event, context, callback) => {
  const id = event.pathParameters.id;
  const params = {
    Key: {
      id: id
    },
    TableName: postsTable
  };
  return db
    .delete(params)
    .promise()
    .then(() =>
      callback(null, response(200, { body: 'Post deleted successfully' }))
    )
    .catch((err) => callback(null, response(err.statusCode, err)));
};
 
// docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-reference.html 