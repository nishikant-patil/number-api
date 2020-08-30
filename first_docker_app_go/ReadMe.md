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
``` unix
FROM ubuntu

RUN apt-get update
RUN apt-get install -y python
RUN apt-get update
RUN apt-get install -y python3-pip

RUN pip3 install flask

COPY app.py /opt/app.py

ENTRYPOINT FLASK_APP=/opt/app.py flask run --host=0.0.0.0
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
