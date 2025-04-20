'use strict' 

// GET ALL: 
// https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/dev/posts

// GET : 
//https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/dev/post/c208bd6d-fcdb-4a69-aa07-a90ea54f1c47?Content-Type=Application/JSON

//  POST:   
//  https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/dev/post

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

/*
{
    "date": "August 23, 2018",
    "cat3": "Web Dev Affairs",
    "post": "<p class=\"firstparagraph\">Security patches that couldn't have arrived sooner ... </p><p class=\"quote\">The Fortnite Installer was easily exploitable to hijack the request to download the full game.      The problem, as Google's security team discovered, was that the Fortnite Installer was very easily exploitable to hijack the request to download Fortnite from Epic and instead download anything when you tap the button to download the game. It's what's known as a \"man-in-the-disk\" attack: an app on your phone looks for requests to download something from the internet and intercepts that request to download something else instead, unbeknownst to the original downloading app.<br /><br />Here's where things get really bad. Because of the way Android's permissions model works, you won't have to accept installation of an app from \"unknown sources\" beyond the time you accepted that installation for Fortnite.<sup>1</sup> </p>\n       \n      ",
    "blogcite": "   <p class=\"cite\">1. <a   href=\"https://www.androidcentral.com/epic-games-first-fortnite-installer-allowed-hackers-download-install-silently\"   target=\"_blank\"> \n    https://www.androidcentral.com/epic-games-first-fortnite-installer-allowed-hackers-download-install-silently </a></p> \n      ",
    "id": "c208bd6d-fcdb-4a69-aa07-a90ea54f1c47",
    "monthOrder": "20",
    "author": "by Thomas Maestas",
    "title": "The Best Offense is a Good Defense",
    "did": "18-08-23"
}
*/