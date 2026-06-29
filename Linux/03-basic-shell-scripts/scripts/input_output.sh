
#!/usr/bin/env bash
# Author : Ameer Khan
# Date Created : 28 June, 2026
# Description : This script is to read data as input and print as output on screen
# Date Modified : 28 June, 2026

ll=$(hostname)
user=`whoami`
directory='pwd'
list=`ls -ltr`
echo My hostname is : $ll
echo
echo user is: $user
$directory
$list

echo "Enter your name"
read name
echo Hey $name

echo Note: user printed successfully nut list is not beacuse user is in echo command and list directly referring to command which is already has out put of ls -ltr means rwxr-x like that

