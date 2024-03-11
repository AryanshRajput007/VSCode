from flask import Flask, render_template

app = Flask(__name__)

@app.route('/user/<username>')
def hello_world(username):
    return f"Hello {username}"

if __name__ == '__main__':
    app.run(debug=True)
