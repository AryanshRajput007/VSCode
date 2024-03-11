class GetData:
    def get_data(self, cursor):
        cursor.execute("SELECT * FROM DATA")
        data = [row for row in cursor.fetchall()]
        print(data)
