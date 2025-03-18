# URL --> https://051j73kv55.execute-api.us-east-1.amazonaws.com/DEV/py-lambda-dailytech?blogDate=18-02-11
import boto3
# import json

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('postspython')

def lambda_handler(event, context):
    blogID = event['blogID']
    resp = table.get_item(Key={
        "did": blogID
    })
    return resp['Item'] 

## API GATEWAY

### QUERYSTRING-->  blogDate=
### Request: /py-lambda-dailytech?blogDate=18-02-11
### Status: 200


### INTEGRATION REQUEST--> When there are no templates defined (recommended)
### MAPPING TEMPLATE-->  application/json
# {
#   "blogID": "$input.params('blogDate')"
# }
    # or... use integration request mapping, change JSON to XML:::
'''
#set($inputRoot = $input.path('$'))
<xml>
    <response>
        <body>$inputRoot.body</body>
        <statusCode>$inputRoot.statusCode</statusCode>
    </response>
</xml>
'''
## TEST:
# { 
#   "blogID": "18-02-11" # did postspython
#   "blogID": "018df2ca-caad-4ff1-9194-72868bb98d45" # id posts
# }
##
 