#!/usr/bin/env bash



my_array=(a b "c" "d")
echo ${#my_array[@]}
a=10
b=20
if [ $a -eq $b ]
then
  echo "not equal"
  else
    echo " equal"
fi

if [ $a -lt 5 -o $b -lt 5 ]; then
    echo "yes"
else
    echo "no"
fi