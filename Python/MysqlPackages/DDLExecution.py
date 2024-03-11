from mysql.connector import Error

class DDLExecutor:
    
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