import csv

def calculate_average(csv_file, column_name):
    try:
        with open(csv_file, 'r') as file:
            reader = csv.DictReader(file)
            if column_name not in reader.fieldnames:
                print(f"Column '{column_name}' not found in the CSV file.")
                return None
            total = 0
            count = 0
            for row in reader:
                try:
                    value = float(row[column_name])
                    total += value
                    count += 1
                except ValueError:
                    print(f"Skipping row {reader.line_num}: Invalid value in the column '{column_name}'")
            if count == 0:
                print(f"No valid values were found in column '{column_name}'")
                return None
            average = total / count
            return average
        
    except FileNotFoundError:
        print(f"File: '{csv_file}' not found.")
        return None
    
csv_file_path = r'C:\Users\Aryansh Rajput\Dropbox\PC\Downloads\file.csv'
column_to_calculate = 'English'
result = calculate_average(csv_file_path, column_to_calculate)

if result is not None:
    print(f"The average value for column '{column_to_calculate}' is: {result}")
