import mysql.connector as c

class Connector:
    def Connection(self):
        conn = c.connect(host='localhost', user='root', password='ARPU1234')
        cursor = conn.cursor()
        return conn, cursor