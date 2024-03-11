from mysql.connector import Error
from MysqlPackages.DDLExecution import DDLExecutor

class TableSelector:
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
            query = "CREATE TABLE {} (".format(table_name)
            for name, type in columns.items():
                query += "{} {}, ".format(name, type)
            query = query[:-2] + ")"
            executor = DDLExecutor ()
            executor.Create_table(cursor, query)
            return table_name
        except Error as e:
            print("Error creating table:", e)
    
    def select_table(self, cursor):
        try:
            cursor.execute("SHOW TABLES")
            tables = [db[0] for db in cursor.fetchall()] # type: ignore
            table_selector = int(input("Press 1 to work with an existing table\nPress 2 to create a new table\nPress 3 to exit: "))
            if table_selector == 1:
                table = input("Enter the name of the table you want to work with: ")
                if table not in tables:
                    creator_choice = int(input("The given table does not exist. Press 1 to create a new table, else press 2 to exit: "))
                    if creator_choice == 1:
                        return TableSelector.create_table(cursor)
                    else:
                        exit()
                else:
                    return table
            elif table_selector == 2:
                return TableSelector.create_table(cursor)
            else:
                exit()
        except Error as e:
            print("Error selecting table:", e)
