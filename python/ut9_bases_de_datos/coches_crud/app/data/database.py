import pymysql


# Connect to the database
connection = pymysql.connect(
    host='localhost',
    port=3319,
    user='quevedo',
    password='1234',
    database='cochesdb',
    cursorclass=pymysql.cursors.DictCursor)

