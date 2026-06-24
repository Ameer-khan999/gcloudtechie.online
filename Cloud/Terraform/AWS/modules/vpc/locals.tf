locals {
  common_tags = {
    project = var.project
    environment = var.environment
    Terraform = "true"
    Name = local.common_name
  }
  common_name = "${var.project}-${var.environment}-roboshop"
  az_zone_names=slice(data.aws_availability_zones.available.names,0,2)
}