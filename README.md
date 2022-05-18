
# aws-lambda-clojure-demo

A demo of AWS Lambda using Clojure from [Writing AWS Lamba Functions in Clojure](https://aws.amazon.com/blogs/compute/clojure/).

## Prerequisites

- [AWS CLI](https://aws.amazon.com/cli/)
- [Java 8](https://openjdk.java.net/install/)
- [Leiningen](https://leiningen.org)

## Usage

1. Build
```
lein uberjar
```

2. Create
```
aws lambda create-function \
  --function-name clj-hellopojo \
  --handler PojoHandler::handlepojo \
  --runtime java8 \
  --memory 512 \
  --timeout 10 \
  --role arn:aws:iam::AWS_ACCOUNT_ID:role/LAMBDA_EXECUTION_ROLE \
  --zip-file fileb://./target/lambda-clj-examples-0.1.0-standalone.jar
```

3. Invoke
```
aws lambda invoke \
  --function-name clj-hellopojo \
  --cli-binary-format raw-in-base64-out \
  --payload '{ "firstName": "Rich", "lastName": "Hickey" }' \
  response.json
```
