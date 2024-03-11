import mysql.connector as c
from mysql.connector import Error

def connector():
    try:
        conn = c.connect(host="localhost", user="root", password="ARPU1234")
        cursor = conn.cursor()
        return cursor, conn
    except Error as e:
        print("Error connecting to MySQL server:", e)

def create_database(database_name, cursor):
    try:
        cursor.execute("CREATE DATABASE IF NOT EXISTS {}".format(database_name))
    except Error as e:
        print("Error creating database:", e)

def create_table(query, cursor):
    try:
        cursor.execute(query)
        print("Table created successfully.")
    except Error as e:
        print("Error creating table:", e)

def insert_into_table(data, cursor, conn):
    try:
        query = "INSERT INTO DATA (ENROLLMENT_NO, STUDENT_NAME, STUDENT_PHONE_NUMBER) VALUES (%s, %s, %s)"
        cursor.executemany(query, data)
        conn.commit()
        print("Data inserted successfully.")
    except Error as e:
        print("Error inserting data:", e)
        
def update_table(query, cursor):
    try:
        cursor.execute(query)
        print("Data updated successfully.")
    except Error as e:
        print("Error updating data:", e)
    
def delete_table(query, cursor):
    try:
        cursor.execute(query)
        print("Data deleted successfully.")
    except Error as e:
        print("Error deleting data:", e)
        
def get_data(cursor):
    cursor.execute("SELECT * FROM DATA")
    data = [row for row in cursor.fetchall()]
    print(data)

if __name__ == "__main__":
    cursor, conn = connector() # type: ignore
    db_name = input("Enter database name: ")
    create_database(db_name, cursor)
    cursor.execute("USE {}".format(db_name))
    query = """CREATE TABLE IF NOT EXISTS DATA (ENROLLMENT_NO INTEGER PRIMARY KEY, STUDENT_NAME VARCHAR(255), STUDENT_PHONE_NUMBER VARCHAR(255))"""
    create_table(query, cursor)
    
    data = []
    while True:
        enroll_no = input("Enter the Enrollment Number (or type 'done' to finish): ")
        if enroll_no.lower() == 'done':
            break
        student_name = input("Enter the Student Name: ")
        student_phone_number = input("Enter the Student Phone Number: ")
        data.append((enroll_no, student_name, student_phone_number))

    if data:
        insert_into_table(data, cursor, conn)
    
    update_query = "UPDATE DATA SET STUDENT_NAME = 'Shivanand' WHERE ENROLLMENT_NO = 912"
    update_table(update_query, cursor)
    
    delete_query = "DELETE FROM DATA WHERE ENROLLMENT_NO = 912"
    delete_table(delete_query, cursor) 
    
    get_data(cursor)
    
    cursor.close()
    conn.close()

