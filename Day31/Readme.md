# Terraform

## Install teraform

    winget install HashiCorp.Terraform

## Update the environment variable

    C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Hashicorp.Terraform_Microsoft.Winget.Source_8wekyb3d8bbwe

## Verify install version

    terraform -version

## Create first using cloudformation

    aws cloudformation deploy --template-file create-queue-template.yml --stack-name create-queue --capabilities CAPABILITY_NAMED_IAM

## Delete Stack after verification

     aws cloudformation delete-stack --stack-name create-queue 

## Initialise the Terraform
    
    terraform init

## Validate Terraform configuration

    terraform validate

##  Apply and create stack
    
    terraform apply

## Destroy teraform or delete infrastructure
    
    terraform destroy
    
