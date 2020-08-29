import os
from flask import Flask
app = Flask(__name__)

@app.route("/")
def main():
    return "Welcome to your First Docker App!"

@app.route('/how are you')
def hello():
    return 'I am good, thanks for asking'

if __name__ == "__main__":
    app.run()
