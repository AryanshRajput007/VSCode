from datetime import datetime
import os

class Car:
    def __init__(self, maker, model, model_id, year):
        self.maker = maker
        self.model_id = model_id
        self.model = model
        self.year = year

    def display(self):
        print(f"Maker: {self.maker} \n Model: {self.model} \n Year: {self.year}")

def is_valid_year(year):
    current_year = datetime.now().year
    return year <= current_year

def clear_screen():
    # For Windows
    if os.name == 'nt':
        _ = os.system('cls')
    # For Linux and MacOS
    else:
        _ = os.system('clear')

if __name__ == "__main__":
    Cars = []
    while True:
        print("...Enter a choice... \n...Enter 1 to enter car details... \n...Enter 2 to update car details... \n Enter 3 to delete car details... \n...Enter 4 to display all details... \n...Enter 5 to exit...")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            maker = input("Enter your car Maker: ")
            model = input("Enter your car Model: ")
            model_id = input("Enter your car Model ID: ")
            year = int(input("Enter your car Year: "))
            if is_valid_year(year):
                car_instance = Car(maker, model, model_id, year)
                Cars.append(car_instance)
            else:
                print("Invalid year! Please enter a year less than or equal to the present year.")

        elif choice == 2:
            if not Cars:
                print("Error: The list is empty. Add cars before updating.")
                continue

            model_id = input("Enter the model id whose data you wish to update: ")
            for car_instance in Cars:
                if car_instance.model_id == model_id:
                    updater_list = [int(x) for x in input("Press 1 to update the maker name \nPress 2 to update the model \n Press 3 to update the Year \nTo update multiple data enter the values separated by space\nEnter your choice: ").split()]
                    for element in updater_list:
                        if element == 1:
                            new_maker_name = input("Enter the new maker name: ")
                            car_instance.maker = new_maker_name
                        elif element == 2:
                            new_model_name = input("Enter the new model name: ")
                            car_instance.model = new_model_name
                        elif element == 3:
                            new_year = int(input("Enter the new Year: "))
                            if is_valid_year(new_year):
                                car_instance.year = new_year
                            else:
                                print("Invalid year! Please enter a year less than or equal to the present year.")
                    break
            else:
                print("The model number is invalid. Please enter a valid model number")

        elif choice == 3:
            if not Cars:
                print("Error: The list is empty. Add cars before deleting.")
                continue

            model_id = input("Enter the model ID whose data you want to delete: ")
            for car_instance in Cars:
                if car_instance.model_id == model_id:
                    Cars.remove(car_instance)
                    break
            else:
                print("The model number is invalid. Please enter a valid model")

        elif choice == 4:
            if not Cars:
                print("Error: The list is empty. Add cars before displaying.")
                continue

            for car_instance in Cars:
                car_instance.display()

        elif choice == 5:
            print("Exiting")
            exit()

        else:
            print("Invalid Choice! Please try again")

        input("Press Enter to clear the screen...")
        clear_screen()
