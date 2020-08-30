### Create sample app file
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

### Create sample docker file i.e. Dockerfile
``` docker
FROM golang:1.6-alpine
RUN mkdir /app
ADD . /app/
WORKDIR /app
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o main .
CMD ["/app/main"]

EXPOSE 80
```

### Build Image on Docker
``` unix
cd first_docker_app
docker build .
```

### Name Image 
``` unix
docker build . -t bhargrah/first_docker_app
```

### Test Image 
``` python
docker run -p 9091:5000 bhargrah/first_docker_app

http://localhost:9091/
http://localhost:9091/how%20are%20you
```

### Push Image to Docker account
``` unix
docker push bhargrah/first_docker_app
```
