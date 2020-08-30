### Step 1: Create account on Docker Hub
Click [here](https://hub.docker.com/) to login

### Step 2: Docker Labs (Super Lazy Developers)
Click [Lab](https://labs.play-with-docker.com/#) to initialize

### Step 3: Create sample app file (app.py)
``` python
import os
from flask import Flask
app = Flask(__name__)

@app.route("/")
def main():
    return "Welcome to your first docker app!"

@app.route('/how are you')
def hello():
    return 'I am good, thanks for asking'

@app.route('/kill')
def kill():
    raise Exception('killing')    

if __name__ == "__main__":
    app.run()
```

### Step 4: Create sample docker file i.e. Dockerfile
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

### Step 5: Build Image on Docker
``` unix
cd first_docker_app
docker build .
```

### Step 6: Name Image 
``` unix
docker build . -t first_docker_app
```

### Step 7: Test Image on Lab
``` python
docker run -p 8080:5000 first_docker_app
```

### Step 8: Push Image to Docker account
``` unix
docker login
docker build . -t {docker_login_id}/first_docker_app
docker push {docker_login_id}/first_docker_app
```
