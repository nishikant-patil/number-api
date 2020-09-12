### Step 1: Create account on Docker Hub
Click [here](https://hub.docker.com/) to login

### Step 2: Docker Labs (Super Lazy Developers)
Click [Lab](https://labs.play-with-docker.com/#) to initialize

### Step 3: Create sample app file (app.py)
``` go
package main

import (
  "fmt"
  "net/http"
  "os"
)

func handler(w http.ResponseWriter, r *http.Request) {
  var name, _ = os.Hostname()
  fmt.Fprintf(w, "<h1>Hello Docker , this request is served by GO server , processed by host: %s</h1>\n", name)
}

func main() {
  fmt.Fprintf(os.Stdout, "Web Server started. Listening on 0.0.0.0:80\n")
  http.HandleFunc("/", handler)
  http.ListenAndServe(":80", nil)
}
```

### Step 4: Create sample docker file i.e. Dockerfile
``` unix
FROM golang:1.6-alpine
RUN mkdir /app
ADD . /app/
WORKDIR /app
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o main .
CMD ["/app/main"]

EXPOSE 80
```

### Step 5: Build Image on Docker
``` unix
cd first_docker_app_go
docker build .
```

### Step 6: Name Image 
``` unix
docker build . -t first_docker_app_go
```

### Step 7: Test Image on Lab
``` unix
docker run -p 8080:80 first_docker_app_go
```

### Step 8: Push Image to Docker account
``` unix
docker login
docker build . -t {docker_login_id}/first_docker_app_go
docker push {docker_login_id}/first_docker_app_go
```
