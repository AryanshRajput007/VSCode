import mysql.connector as c
from MysqlPackages.Connectivity import Connector
from MysqlPackages.DDLExecution import DDLExecutor

connecter = Connector()

DDL = DDLExecutor()


conn, cursor = connecter.Connection()