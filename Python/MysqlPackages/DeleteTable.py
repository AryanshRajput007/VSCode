from mysql.connector import Error

class DeleteTable:
    def delete_table(self, query, cursor):
        try:
            cursor.execute(query)
            print("Data deleted successfully.")
        except Error as e:
            print("Error deleting data:", e)
        