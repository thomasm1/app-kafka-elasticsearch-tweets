import json
import boto3

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('blog_links')


def lambda_handler(event, context):
    response = table.get_item(
        Key={
            'did': 'did' 
        }
    )
    print(response)
    return {
        'statusCode': 200,
        'body':response
    }
