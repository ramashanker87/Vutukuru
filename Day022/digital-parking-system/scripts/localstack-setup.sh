#!/bin/bash

# Wait for LocalStack to be ready
echo "Waiting for LocalStack to be ready..."
sleep 5

# Create SQS Queues
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name parking-start-request --region us-east-1
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name parking-end-request --region us-east-1
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name parking-end-response --region us-east-1

# Create DynamoDB Table
aws --endpoint-url=http://localhost:4566 dynamodb create-table \
    --table-name ParkingTable \
    --attribute-definitions AttributeName=regNo,AttributeType=S \
    --key-schema AttributeName=regNo,KeyType=HASH \
    --billing-mode PAY_PER_REQUEST \
    --region us-east-1

echo "LocalStack setup completed!"
