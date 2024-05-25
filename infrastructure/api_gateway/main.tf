resource "aws_apigatewayv2_api" "this" {
    name          = "fifa-cups"
    protocol_type = "HTTP"
}

resource "aws_apigatewayv2_integration" "proxy" {
    api_id                 = aws_apigatewayv2_api.this.id
    integration_type       = "HTTP_PROXY"
    integration_uri        = "http://${var.public_dns}:8080/{proxy}"
    integration_method     = "ANY"
    payload_format_version = "1.0"
}

resource "aws_apigatewayv2_route" "proxy" {
    api_id    = aws_apigatewayv2_api.this.id
    route_key = "ANY /{proxy+}"
    target    = "integrations/${aws_apigatewayv2_integration.proxy.id}"
}

resource "aws_apigatewayv2_integration" "default" {
    api_id = aws_apigatewayv2_api.this.id
    integration_type = "HTTP_PROXY"
}

resource "aws_apigatewayv2_route" "default" {
    api_id    = aws_apigatewayv2_api.this.id
    route_key = "$default"
    target    = "integrations/${aws_apigatewayv2_integration.default.id}"
}

resource "aws_apigatewayv2_stage" "this" {
    api_id = aws_apigatewayv2_api.this.id
    name   = "$default"
}