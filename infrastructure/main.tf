provider "aws" {
    region                   = "us-east-1"
    shared_credentials_files = [ "/Users/felip/.aws/credentials" ]
    profile                  = "fifa-cups"
}

module "security_group" {
    source = "./security_group"
}

module "rds" {
    source = "./rds"

    rds_instance_name = "fifa-cups"
    database_name     = "fifacups"
    master_database_username =  "fifa_cups"
    security_group_ids = [ module.security_group.database_id ]
}

module "ec2" {
    source = "./ec2"

    secrets_manager_arn = module.rds.secrets_manager_arn
    security_group_ids  = [ module.security_group.ec2_id ]
}

module "api_gateway" {
    source = "./api_gateway"

    public_dns = module.ec2.public_dns
}