import mysql.connector as c
from mysql.connector import Error

def connecter():
    try:
        conn = c.connect(host="localhost", user="root", password="ARPU1234")
        cursor = conn.cursor()
        
        cursor.execute("SHOW DATABASES")
        database = input("Enter the name of the database you want to work on: ")
        databases = [db[0] for db in cursor.fetchall()] # type: ignore
        if database not in databases:
            cursor.execute("CREATE DATABASE " + database)
        cursor.execute("USE " + database)
        
        cursor.execute("SHOW TABLES")
        tables = [table[0] for table in cursor.fetchall()] # type: ignore
        table = input("Enter the name of the table you want to work on: ")
        if table not in tables:
            cursor.execute(f"CREATE TABLE {table} (id INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255), Age INT)") # Example table structure with id, name, and age fields. Adjust as per your requirements.
        
        entries = [
            {"Name": "Shivanand", "Age": 19},
            {"Name": "Aryansh", "Age": 19},
            {"Name": "Kush", "Age": 19},
            {"Name": "Aarzoo", "Age": 19},
            {"Name": "Smith", "Age": 19},
            {"Name": "Jay", "Age": 19},
            {"Name": "Ansh", "Age": 19},
            {"Name": "Vanshika", "Age": 19},
            {"Name": "Vishal", "Age": 19}
        ]
        
        for entry in entries:
            sql = f"INSERT INTO {table} (Name, Age) VALUES (%s, %s)"
            val = (entry["Name"], entry["Age"])
            cursor.execute(sql, val)
        
        conn.commit()
        print(cursor.rowcount, "record(s) inserted successfully.")
        cursor.execute(f"SELECT * FROM {table}")
        result = [row for row in cursor.fetchall()]

        try:
            if result:
                print(result)
        except Error as e:
            print(e)
    except Error as e:
        print(f"Error occurred: {e}")
    finally:
        if conn.is_connected():
            cursor.close()
            conn.close()

connecter()
