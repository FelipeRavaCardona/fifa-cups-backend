resource "aws_security_group" "database" {
    name = "fifa-cups-db"

    ingress {
        from_port = 5432
        to_port   = 5432
        protocol  = "tcp"
        cidr_blocks = [ "0.0.0.0/0" ]
    }

    egress {
        from_port   = 0
        to_port     = 0
        protocol    = "-1"
        cidr_blocks = ["0.0.0.0/0"]
    }
}

resource "aws_security_group" "ec2" {

}