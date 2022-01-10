
# initialize database

import mysql.connector as ms

db = ms.connect(host='localhost', user='root', passwd='root123', database='test', autocommit=True)
cursor = db.cursor()




