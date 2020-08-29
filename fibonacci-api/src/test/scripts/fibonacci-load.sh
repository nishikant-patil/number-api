#!/bin/bash

for i in {1..10000..4}
do
	curl -s http://localhost/fibonacci/get-first-n-fibonnaci-numbers/80 &
	curl -s http://localhost/fibonacci/get-first-n-fibonnaci-numbers/80 &
	curl -s http://localhost/fibonacci/get-first-n-fibonnaci-numbers/80 &
	curl -s http://localhost/fibonacci/get-first-n-fibonnaci-numbers/80 &
	wait
done
