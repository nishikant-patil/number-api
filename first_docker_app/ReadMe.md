### Create sample app file
``` python
import os
from flask import Flask
app = Flask(__name__)

@app.route("/")
def main():
    return "Welcome!"

@app.route('/how are you')
def hello():
    return 'I am good, thanks for asking'

if __name__ == "__main__":
    app.run()
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
