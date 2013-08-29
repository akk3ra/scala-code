#!/bin/bash

myFunc () {
str = $1
cat test.txt | awk '$1==str'
}
myFunc Sandeep

