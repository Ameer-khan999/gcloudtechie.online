module "vpc" {
    source = "../modules/vpc"
    #source = "git::https://github.com/daws-90s/terraform-aws-vpc.git?ref=main"
    project = var.project
    environment = var.environment
    
}