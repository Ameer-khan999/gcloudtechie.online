variable "project" {
  type = string
}

variable "environment" {
  type = string
}

variable "vpc_cidr" {
    type = string
    default = "10.0.0.0/22"
}

variable "vpc_tags" {
    type = map(map)
    default = {}
}

variable "igw_tags" {
    type = map()
    default = {}
}

variable "public_subnet_cidrs" {
    type = list
    default = ["10.0.0.0/24"]
}

variable "public_subnet_tags" {
    type = map()
    default = {}
  
}

variable "private_subnet_cidrs" {
    type = list
    default = ["10.0.2.0/24"]
}

variable "private_subnet_tags" {
  type = map()
  default = {}
}

variable "public_route_table_tags" {
  type = map()
  default = {}
}

variable "private_route_table_tags" {
  type = map()
  default = {}
}

variable "eip_tags" {
  type = map()
  default = {}
}

variable "nat_gateway_tags" {
  type = map()
  default = {}
}