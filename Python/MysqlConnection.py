import mysql.connector as c
from mysql.connector import Error
from mysql.connector import errorcode

def connecter():
    try:
        try:
            conn = c.connect(host="localhost", user="root", password="ARPU1234")
        except Exception as e:
            print("Error connecting to the database: " + str(e.args))
        
        cursor = conn.cursor()
        cursor.execute("SHOW DATABASES")
        database = input("Enter the name of the database you want to work on: ")
        databases = [db[0] for db in cursor.fetchall()]
        if database not in databases:
            cursor.execute("CREATE DATABASE " + database)
        cursor.execute("USE " + database)
        cursor.execute("SHOW TABLES")
        tables = [table[0] for table in cursor.fetchall()]
        table = input("Enter the name of the table you want work on to: ")
        if table not in tables:
            
    finally:
        cursor.close()
        conn.close()

connecter()
