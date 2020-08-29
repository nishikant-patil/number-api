# Number API
![Java CI with Gradle](https://github.com/nishikant-patil/number-api/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)

Number API is a collection of Java REST services which can be packaged as Docker images.

APIs available -

1. Fibonacci API
2. Prime Number API

## Docker Installation

### Windows
- Follow step from [here](https://docs.docker.com/docker-for-windows/wsl/).

### Linux

- Follow steps from [here](https://docs.docker.com/engine/install/debian/) for Debian.
- Follow steps from [here](https://docs.docker.com/engine/install/fedora/) for Fedora.
- Follow steps from [here](https://docs.docker.com/engine/install/ubuntu/) for Ubuntu.
- Follow steps from [here](https://docs.docker.com/engine/install/centos/) for CentOS.

### Docker Desktop
- Follow steps from [here](https://www.docker.com/products/docker-desktop)

### Docker Labs (Super Lazy Developers)
- Click [Lab](https://labs.play-with-docker.com/#) to initialize

## Usage
### Fibonacci API

Pull the image from Docker Hub using the following command
``` bash
docker pull nishikantpatil/fibonacci-api:0.1
```

Verify the image using the following command 
``` bash
docker images
```
Spin up a container using the following command 
``` bash
docker run -dp host-port:8080 nishikantpatil/fibonacci-api:0.1 
# replace 'host-port' with any unused port on the host machine
```

Verify the container state using the following command
```bash
docker ps
```
Fibonacci API will be available at 
```html
http://localhost:host-port:/fibonacci/get-first-n-fibonnaci-numbers/5
```

Swagger UI will be available at 
```html
http://localhost:host-port:/v3/api-docs
```
Swagger Doc JSON will be available at 
```html
http://localhost:host-port/swagger-ui.html
```

### Prime Number API

Pull the image from Docker Hub using the following command
``` bash
docker pull nishikantpatil/prime-number-api:0.1
```

Verify the image using the following command 
``` bash
docker images
```
Spin up a container using the following command 
``` bash
docker run -dp host-port:8080 nishikantpatil/prime-number-api:0.1 
# replace 'host-port' with any unused port on the host machine
```

Verify the container state using the following command
```bash
docker ps
```
Fibonacci API will be available at 
```html
http://localhost:host-port:/primes/is-prime/5
```

Swagger UI will be available at 
```html
http://localhost:host-port:/v3/api-docs
```
Swagger Doc JSON will be available at 
```html
http://localhost:host-port/swagger-ui.html
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
