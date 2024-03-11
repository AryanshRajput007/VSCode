from flask import Flask, render_template, request
import random

app = Flask(__name__)

class Customers:
    def __init__(self, name, age, customer_address, customer_contact_number):
        self.name = name
        self.age = age
        self.customer_address = customer_address
        self.customer_contact_number = customer_contact_number
    
    def display(self):
        return f"Name: {self.name} \nAge: {self.age} \nCustomer Address: {self.customer_address} \nCustomer Contact Number: {self.customer_contact_number}"
        
class Bank:
    def __init__ (self, owner_name):
        self.owner_name = owner_name
        self.account_number = self.generate_account_number()
        self.pin = self.generate_pin()
        
    def generate_account_number(self):
        return ''.join(random.choice("0123456789") for _ in range(12))
    
    def generate_pin(self):
        return ''.join(random.choice("0123456789") for _ in range(4))
    
class Bank_account:
    def __init__(self, account_type, balance):
        self.account_type = account_type
        self.balance = balance
        
    def deposit(self, amount):
        self.balance += amount
        return f"The current balance after deposition is {self.balance}"
        
    def withdraw(self, amount):
        self.balance -= amount
        return f"The current balance after withdrawal is {self.balance}"
    
    def display_balance(self):
        return f"The current balance is {self.balance}"

customer_data = {}

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/create_account', methods=['POST'])
def create_account():
    if request.method == 'POST':
        name = request.form['name']
        age = int(request.form['age'])
        customer_address = request.form['customer_address']
        customer_contact_number = int(request.form['customer_contact_number'])
        account_type = request.form['account_type']
        new_choice = int(request.form['new_choice'])
        
        if new_choice == 1:
            owner_name = name
        elif new_choice == 2:
            owner_name = request.form['owner_name']
        else:
            return "Invalid choice"
        
        balance = int(request.form['balance'])
        customer_instance = Customers(name, age, customer_address, customer_contact_number)
        bank_instance = Bank(owner_name)
        bank_account_instance = Bank_account(account_type, balance)
        customer_unique_user_name = request.form['customer_unique_user_name']
        customer_data[customer_unique_user_name] = [customer_instance, bank_instance, bank_account_instance]
        
        return render_template('success.html', customer_data=customer_data)

@app.route('/deposit', methods=['POST'])
def deposit():
    if request.method == 'POST':
        name = request.form['name']
        if name in customer_data:
            amount_to_be_deposited = int(request.form['amount_to_be_deposited'])
            current_bank_account_instance = customer_data[name][2]
            result = current_bank_account_instance.deposit(amount_to_be_deposited)
            return render_template('result.html', result=result)
        else:
            return "No unique customer name is found!"

# Similar routes for withdraw, check_balance, and exit

if __name__ == '__main__':
    app.run(debug=True)
