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

Fibonacci API supports [Skaffold](https://skaffold.dev/) builds with [JIB](https://github.com/GoogleContainerTools/jib) gradle plugin to build and deploy images either on [Minikube](https://minikube.sigs.k8s.io/docs/) or [DockerHub](https://hub.docker.com/).

#### Skaffold, Kubectl, Kustomize, and Minikube setup

Follow steps from [here](https://skaffold.dev/docs/quickstart/) for Skaffold, Kubectl, and Minikube

Install Kustomize as per the instructions from [here](https://kubernetes-sigs.github.io/kustomize/installation/binaries/). This will install Kustomize into the current working directory. You can move it to bin path to make it available globally.

```
sudo mv ./kustomize /usr/local/bin/
```

#### Local build

We need to setup env variables to point docker to minikube instead of default config. This is required because minikube uses its own docker environment for running containers.

Execute the following command to setup env variables for Minikube's docker
```bash
eval $(minikube -p minikube docker-env)
```

Navigate to 'fibonacci-api' directory from terminal and run the following command to start Skaffold 'dev' mode.
```bash
skaffold dev -p ${profile} # check list of available profiles from 'skaffold.yaml'
```

If the setup is correct, you should see an output similar to the following
```
Starting deploy...
 - deployment.apps/fibonacci-api-deployment created
Waiting for deployments to stabilize...
 - deployment/fibonacci-api-deployment is ready.
Deployments stabilized in 2.2596807s
Press Ctrl+C to exit
[fibonacci-api] 
[fibonacci-api]   .   ____          _            __ _ _
[fibonacci-api]  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
[fibonacci-api] ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
[fibonacci-api]  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
[fibonacci-api]   '  |____| .__|_| |_|_| |_\__, | / / / /
[fibonacci-api]  =========|_|==============|___/=/_/_/_/
[fibonacci-api]  :: Spring Boot ::        (v2.3.3.RELEASE)
[fibonacci-api] 
[fibonacci-api] 2020-09-13 10:05:17.555  INFO 1 --- [           main] f.b.n.f.FibonacciApiApplication          : Starting FibonacciApiApplication on fibonacci-api-deployment-65959d887b-pjhpb with PID 1 (/app/classes started by root in /)
[fibonacci-api] 2020-09-13 10:05:17.573  INFO 1 --- [           main] f.b.n.f.FibonacciApiApplication          : No active profile set, falling back to default profiles: default
Watching for changes...
```

The application is deployed in Minikube as a [deployment](https://kubernetes.io/docs/concepts/workloads/controllers/deployment/p) and has two [replicas](https://kubernetes.io/docs/concepts/workloads/controllers/replicaset/)/instances of the service. In order to access the application, we need to create a [service](https://kubernetes.io/docs/concepts/services-networking/service/) which will redirect requests to internal [pods](https://kubernetes.io/docs/concepts/workloads/pods/). 'k8s-service.yaml' has the configuration for the service. Execute the following command to create [ClusterIP](https://kubernetes.io/docs/concepts/services-networking/service/#publishing-services-service-types) service for this application.
```bash
kubectl -n default apply -f k8s-service.yaml
```

Once the service is created, execute the following command to get an externally accessible url of the service.
```bash
minikube service fibonacci-api-service --url
```
You should see an output similar to the following
```
😿  service default/fibonacci-api-service has no node port
🏃  Starting tunnel for service fibonacci-api-service.
|-----------|-----------------------|-------------|------------------------|
| NAMESPACE |         NAME          | TARGET PORT |          URL           |
|-----------|-----------------------|-------------|------------------------|
| default   | fibonacci-api-service |             | http://127.0.0.1:42555 |
|-----------|-----------------------|-------------|------------------------|
http://127.0.0.1:42555
❗  Because you are using a Docker driver on linux, the terminal needs to be open to run it.
```

Swagger UI will be available at 
```html
http://${external-url-for-fibonaacci-api-service}:/v3/api-docs
```
Swagger Doc JSON will be available at 
```html
http://${external-url-for-fibonaacci-api-service}/swagger-ui.html
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
