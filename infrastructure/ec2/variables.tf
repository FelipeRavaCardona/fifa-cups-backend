variable "secrets_manager_arn" {
    description = "Arn of the Secrets Manager where the database credentials are"
    type        = string
}

variable "security_group_ids" {
    description = "List with the ids of the security groups the EC2 should be assigned to"
    type        = list(string)
}