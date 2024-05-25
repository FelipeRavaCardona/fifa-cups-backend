resource "aws_iam_role" "this" {
    name               = "fifa-cups-api"
    assume_role_policy = jsonencode({
        Version = "2012-10-17"
        Statement = [
            {
                Effect = "Allow"
                Principal = {
                    Service = "ec2.amazonaws.com"
                }
                Action = "sts:AssumeRole"
            }
        ]
    })
}

resource "aws_iam_policy" "this" {
    name   = "fifa-cups-api"
    policy = jsonencode({
        Version = "2012-10-17"
        Statement = [
            {
                Effect = "Allow"
                Action = [
                    "secretsmanager:GetSecretValue"
                ]
                Resource = "${var.secrets_manager_arn}" // TODO: Pegar arn do secrets
            }
        ]
    })
}

resource "aws_iam_role_policy_attachment" "this" {
    role       = aws_iam_policy.this.name
    policy_arn = aws_iam_policy.this.arn
}
 
resource "aws_iam_instance_profile" "this" {
    name = "fifa-cups-api"
    role = aws_iam_role.this.name
}

resource "aws_instance" "this" {
    ami = "ami-0bb84b8ffd87024d8"
    instance_type = "t2.micro"
    vpc_security_group_ids = var.security_group_ids
    associate_public_ip_address = true
    iam_instance_profile = aws_iam_instance_profile.this.name
}

resource "aws_eip" "this" {
    instance = aws_instance.this.id
}