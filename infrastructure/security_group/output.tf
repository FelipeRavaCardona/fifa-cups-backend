output "database_id" {
    value = aws_security_group.database.id
}

output "ec2_id" {
    value = aws_security_group.ec2.id
}