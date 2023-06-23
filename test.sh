#!/bin/bash

if [ $# -le 1 ]; then
  java -jar target/feign-retry-test.jar openfeign feign
else
  java -jar target/feign-retry-test.jar $@
fi

