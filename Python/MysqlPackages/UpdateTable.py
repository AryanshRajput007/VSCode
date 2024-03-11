from mysql.connector import Error

class UpdateTable:
    def update_table(self, query, cursor):
        try:
            cursor.execute(query)
            print("Data updated successfully.")
        except Error as e:
            print("Error updating data:", e)
