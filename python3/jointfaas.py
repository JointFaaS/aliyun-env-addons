"""
Aliyun python function handler wrapper

"""
import index
import os
import json

def handler(event, context):
    envs = os.environ
    envs['jointfaas_env'] = 'aliyun'
    envs['region']  = context.region
    creds = context.credentials
    envs['accessKeyId'] = creds.accessKeyId
    envs['accessKeySecret'] = creds.accessKeySecret
    return index.handler(json.loads(event))