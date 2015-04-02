#!/bin/bash
set -e

var1=$(aws ec2 start-instances --instance-ids $1)

var2=$(aws ec2 wait instance-running --instance-ids $1)



echo "$(aws ec2 describe-instances --query 'Reservations[].Instances[0].PublicIpAddress' --instance-ids $1)"
