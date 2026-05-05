import pymysql


# Connect to the database
connection = pymysql.connect(
    host='localhost',
    port=3320,
    user='quevedo',
    password='1234',
    database='personas',
    cursorclass=pymysql.cursors.DictCursor)