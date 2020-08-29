#!/bin/bash

for i in {1..10000..4}
do
	curl -s http://localhost/primes/is-prime/$i &
	curl -s http://localhost/primes/is-prime/$(($i+1)) &
	curl -s http://localhost/primes/is-prime/$(($i+2)) &
	curl -s http://localhost/primes/is-prime/$(($i+3)) &
	wait
done
