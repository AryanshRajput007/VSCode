import mysql.connector as c
from mysql.connector import Error

class DDL_execution:
    
    def Create_database(self, Database_name, cursor):
        try:
            cursor.execute("CREATE DATABASE IF NOT EXISTS {}".format(Database_name))
            print("Database '{}' created successfully.".format(Database_name))
        except Error as e:
            print("Error creating database: {}".format(e))
        
    def Create_table(self, cursor, query):
        try:
            cursor.execute(query)
            print("Table created successfully.")
        except Error as e:
            print("Error creating table: {}".format(e))

class DatabaseSelector:
    
    @staticmethod
    def select_database(cursor):
        try:
            cursor.execute("SHOW DATABASES")
            databases = [db[0] for db in cursor.fetchall()] # type: ignore
            database_selector = int(input("Press 1 to work on an existing database\nPress 2 to create a new database\nEnter your choice: "))
            if database_selector == 1:
                database = input("Enter the database you want to connect to: ")
                if database not in databases:
                    creator_choice = int(input("The entered database does not exist. Do you wish to create a Database?\nIf yes, press 1\nOr press 2 to exit: "))
                    if creator_choice == 1:
                        return DatabaseSelector.create_database(cursor)
                    else:
                        exit()
                else:
                    cursor.execute(f"USE {database}")
                    return database
            elif database_selector == 2:
                new_database = input("Enter the name of the new database: ")
                return DatabaseSelector.create_database(cursor, new_database)
        except Error as e:
            print("Error selecting database:", e)
    
    @staticmethod
    def create_database(cursor, new_database=None):
        try:
            if new_database is None:
                new_database = input("Enter the name of the new database: ")
            creator = DDL_execution()
            creator.Create_database(new_database, cursor)
            cursor.execute(f"USE {new_database}")
            return new_database
        except Error as e:
            print("Error creating database:", e)
    
    @staticmethod
    def select_table(cursor):
        try:
            cursor.execute("SHOW TABLES")
            tables = [db[0] for db in cursor.fetchall()] # type: ignore
            table_selector = int(input("Press 1 to work with an existing table\nPress 2 to create a new table\nPress 3 to exit: "))
            if table_selector == 1:
                table = input("Enter the name of the table you want to work with: ")
                if table not in tables:
                    creator_choice = int(input("The given table does not exist. Press 1 to create a new table, else press 2 to exit: "))
                    if creator_choice == 1:
                        return DatabaseSelector.create_table(cursor)
                    else:
                        exit()
                else:
                    return table
            elif table_selector == 2:
                return DatabaseSelector.create_table(cursor)
            else:
                exit()
        except Error as e:
            print("Error selecting table:", e)
    
    @staticmethod
    def create_table(cursor):
        try:
            table_name = input("Enter the table name: ")
            columns = {}
            number = int(input("Number of columns: "))
            for i in range(number):
                name = input("Name of the column {}: ".format(i+1))
                type = input("Type of the column {}: ".format(i+1))
                columns[name] = type
            # Creating table query
            query = "CREATE TABLE {} (".format(table_name)
            for name, type in columns.items():
                query += "{} {}, ".format(name, type)
            query = query[:-2] + ")"
            creator = DDL_execution()
            creator.Create_table(cursor, query)
            return table_name
        except Error as e:
            print("Error creating table:", e)

if __name__ == '__main__':
    try:
        conn = c.connect(host="localhost", user="root", password="ARPU1234")
        cursor = conn.cursor()
        
        selected_database = DatabaseSelector.select_database(cursor)
        selected_table = DatabaseSelector.select_table(cursor)
        
        print("Selected Database:", selected_database)
        print("Selected Table:", selected_table)
            
    except Error as e:
        print("Error connecting to MySQL:", e)
    finally:
        if conn.is_connected():
            cursor.close()
            conn.close()
            print("MySQL connection closed.")
