import random

class Customers:
    def __init__(self, name, age, customer_address, customer_contact_number):
        self.name = name
        self.age = age
        self.customer_address = customer_address
        self.customer_contact_number = customer_contact_number
    
    def display(self):
        print(f"Name: {self.name} \nAge: {self.age} \nCustomer Address: {self.customer_address} \nCustomer Contact Number: {self.customer_contact_number}")
        
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
        print(f"The current balance after deposition is {self.balance}")
        
    def withdraw(self, amount):
        self.balance -= amount
        print(f"The current balance after withdrawal is {self.balance}")
    
    def display_balance(self):
        print(f"The current balance is {self.balance}")

if __name__ == "__main__":
    customer_data = {}
    while True:
        print("Press 1 to create an account\nPress 2 to deposit\nPress 3 to withdraw\nPress 4 to check current balance\nPress 5 to exit")
        choice = int(input("Enter your Choice: "))
        if choice == 1:
            name = input("Enter the customer name: ")
            age = int(input("Enter the customer age: "))
            customer_address = input("Enter the customer address: ")
            customer_contact_number = int(input("Enter the customer number: "))
            account_type = input("Enter which type of account you want to create: ")
            new_choice = int(input("Press 1 if owner name and customer number are the same\nPress 2 if owner name and customer number are different\nSelect your choice: "))
            if new_choice == 1:
                owner_name = name
            elif new_choice == 2:
                owner_name = input("Enter the owner name: ")
            else:
                print("Invalid choice")
                exit()
            balance = int(input("Enter the initial balance: "))
            customer_instance = Customers(name, age, customer_address, customer_contact_number)
            bank_instance = Bank(owner_name)
            bank_account_instance = Bank_account(account_type, balance)
            customer_unique_user_name = input("Enter a unique user name for the customer: ")
            customer_data[customer_unique_user_name] = [customer_instance, bank_instance, bank_account_instance]
        elif choice == 2:
            name = input("Enter your unique customer name to deposit the money: ")
            if name in customer_data:
                amount_to_be_deposited = int(input("Enter the amount to be deposited in the customer account: "))
                current_bank_account_instance = customer_data[name][2]
                current_bank_account_instance.deposit(amount_to_be_deposited)
            else:
                print("No unique customer name is found!")
        elif choice == 3:
            name = input("Enter your unique customer name to withdraw the money: ")
            if name in customer_data:
                amount_to_be_withdrawal = int(input("Enter the amount to be withdrawal in the customer account"))
                current_bank_account_instance = customer_data[name][2]
                current_bank_account_instance.withdraw(amount_to_be_withdrawal)
            else:
                print("No unique customer name is found!")
        elif choice == 4:
            name = input("Enter your unique customer name whose balance you want to check: ")
            if name in customer_data:
                current_bank_account_instance = customer_data[name][2]
                current_bank_account_instance.display_balance()
            else:
                print("No unique customer name is found!")
        elif choice == 5:
            print("Exiting the program...")
            exit()
        else:
            print("Invalid choice! Try again")