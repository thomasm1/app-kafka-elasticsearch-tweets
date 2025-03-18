import json
import boto3
# docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-reference.html 

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('blog_links')


def lambda_handler(event, context):
    table.put_item(
        Item={
            'did': '18-08-23',
            'cat3': 'Web Dev Affairs',
            'tags': ['security','bugs','hacking','games','android'],
            'blogcite':'<p class=\"cite\">1. <a href=\"https://www.androidcentral.com/epic-games-first-fortnite-installer-allowed-hackers-download-install-silently\"   target=\"_blank\"> \n    https://www.androidcentral.com/epic-games-first-fortnite-installer-allowed-hackers-download-install-silently </a></p> \n      ',
            'title':'The Best Offense is a Good Defense',
            'date': 'August 23, 2018',
            'urlcites':['https://www.androidcentral.com/epic-games-first-fortnite-installer-allowed-hackers-download-install-silently', 'https://www.firstpost.com/tech/gaming/epic-games-claims-that-security-patches-to-fix-meltdown-cpu-bug-are-responsible-for-fortnite-downtime-4291117.html']
        }
    )
    response = {
        'message': 'Item added'
    }
    return {
        'statusCode': 200,
        'body': response
    }
 