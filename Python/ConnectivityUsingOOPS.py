import mysql.connector as c
from mysql.connector import Error
from MysqlPackages.Connectivity import Connector
from MysqlPackages.DatabaseSelector import DatabaseSelector
from MysqlPackages.TableSelector import TableSelector
from MysqlPackages.UpdateTable import UpdateTable
from MysqlPackages.DeleteTable import DeleteTable
from MysqlPackages.GetData import GetData


# class Connector:
#     def Connection(self):
#         conn = c.connect(host='localhost', user='root', password='ARPU1234')
#         cursor = conn.cursor()
#         return conn, cursor

# class DDL_execution:
    
#     def Create_database(self, Database_name, cursor):
#         try:
#             cursor.execute("CREATE DATABASE IF NOT EXISTS {}".format(Database_name))
#             print("Database '{}' created successfully.".format(Database_name))
#         except Error as e:
#             print("Error creating database: {}".format(e))
        
#     def Create_table(self, cursor, query):
#         try:
#             cursor.execute(query)
#             print("Table created successfully.")
#         except Error as e:
#             print("Error creating table: {}".format(e))

# class DatabaseSelector:
    
#     @staticmethod
#     def create_database(cursor, new_database=None):
#         try:
#             if new_database is None:
#                 new_database = input("Enter the name of the new database: ")
#             executor = DDLExecutor()
#             executor.Create_database(new_database, cursor)
#             cursor.execute(f"USE {new_database}")
#             return new_database
#         except Error as e:
#             print("Error creating database:", e)
    
#     def select_database(self, cursor):
#         try:
#             cursor.execute("SHOW DATABASES")
#             databases = [db[0] for db in cursor.fetchall()] # type: ignore
#             database_selector = int(input("Press 1 to work on an existing database\nPress 2 to create a new database\nEnter your choice: "))
#             if database_selector == 1:
#                 database = input("Enter the database you want to connect to: ")
#                 if database not in databases:
#                     creator_choice = int(input("The entered database does not exist. Do you wish to create a Database?\nIf yes, press 1\nOr press 2 to exit: "))
#                     if creator_choice == 1:
#                         return DatabaseSelector.create_database(cursor)  
#                     else:
#                         exit()
#                 else:
#                     cursor.execute(f"USE {database}")
#                     return database
#             elif database_selector == 2:
#                 new_database = input("Enter the name of the new database: ")
#                 return DatabaseSelector.create_database(cursor, new_database)  
#         except Error as e:
#             print("Error selecting database:", e)

# class TableSelector:
#     @staticmethod
#     def create_table(cursor):
#         try:
#             table_name = input("Enter the table name: ")
#             columns = {}
#             number = int(input("Number of columns: "))
#             for i in range(number):
#                 name = input("Name of the column {}: ".format(i+1))
#                 type = input("Type of the column {}: ".format(i+1))
#                 columns[name] = type
#             query = "CREATE TABLE {} (".format(table_name)
#             for name, type in columns.items():
#                 query += "{} {}, ".format(name, type)
#             query = query[:-2] + ")"
#             executor = DDLExecutor ()
#             executor.Create_table(cursor, query)
#             return table_name
#         except Error as e:
#             print("Error creating table:", e)
    
#     def select_table(self, cursor):
#         try:
#             cursor.execute("SHOW TABLES")
#             tables = [db[0] for db in cursor.fetchall()] # type: ignore
#             table_selector = int(input("Press 1 to work with an existing table\nPress 2 to create a new table\nPress 3 to exit: "))
#             if table_selector == 1:
#                 table = input("Enter the name of the table you want to work with: ")
#                 if table not in tables:
#                     creator_choice = int(input("The given table does not exist. Press 1 to create a new table, else press 2 to exit: "))
#                     if creator_choice == 1:
#                         return TableSelector.create_table(cursor)
#                     else:
#                         exit()
#                 else:
#                     return table
#             elif table_selector == 2:
#                 return TableSelector.create_table(cursor)
#             else:
#                 exit()
#         except Error as e:
#             print("Error selecting table:", e)

if __name__ == "__main__":
    try:
        connector = Connector()
        connection, cursor = connector.Connection()
        conn, cursor = connector.Connection()

        db_selector = DatabaseSelector()
        selected_db = db_selector.select_database(cursor)

        table_selector = TableSelector()
        selected_table = table_selector.select_table(cursor)
        
        update_query = "UPDATE DATA SET STUDENT_NAME = 'Shivanand' WHERE ENROLLMENT_NO = 912"
        update = UpdateTable()
        update.update_table(update_query, cursor)
        
        delete_query = "DELETE FROM DATA WHERE ENROLLMENT_NO = 912"
        delete = DeleteTable()
        delete.delete_table(delete_query, cursor)
        
        data = GetData()
        data.get_data(cursor)
        
    except Error as e:
        print(e)
    finally:
        cursor.close()
        conn.close()
