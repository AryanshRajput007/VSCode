from flask import Flask
# from markupspace import escape

application = Flask(__name__)

# @application.route('/')
# def index():
#   return 'Index Page'

@application.route('/')
def hello_world():
    return "Hello, World!"

if __name__ == '__main__':
    application.run(debug = True)
    application.run(host='0.0.0.0', port=8080)