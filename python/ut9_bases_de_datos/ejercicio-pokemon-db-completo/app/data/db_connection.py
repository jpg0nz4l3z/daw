import pymysql

connection = pymysql.connect(
    host='localhost',
    port=3319,
    user='quevedo',
    password='1234',
    database='pokemondb',
    cursorclass=pymysql.cursors.DictCursor
)
