from mysql.connector import Error
from MysqlPackages.DDLExecution import DDLExecutor

class DatabaseSelector:
    
    @staticmethod
    def create_database(cursor, new_database=None):
        try:
            if new_database is None:
                new_database = input("Enter the name of the new database: ")
            executor = DDLExecutor()
            executor.Create_database(new_database, cursor)
            cursor.execute(f"USE {new_database}")
            return new_database
        except Error as e:
            print("Error creating database:", e)
    
    def select_database(self, cursor):
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
