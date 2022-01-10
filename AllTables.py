import mysql.connector as ms
import justForPrint as jp
import operations as op
from init_sql import cursor as cc


def student_table():
    print("\n\n-----STUDENT TABLE-----")
    cc.execute("select * from student;")
    jp.printline(cc.fetchall())
    return


def attendacne_table():
    print("\n\n-----ATTENDANCE TABLE-----")
    cc.execute('select * from attendance ')
    table = cc.fetchall()
    jp.printline(table)
    return



def joined_table():
    print("\n\n-----JOINED TABLE-----")

    cc.execute("select student.id, name, intime, outtime from attendance "
               "left join student "
               "on student.uid=attendance.uid;")

    jp.printline(cc.fetchall())
    return





db = ms.connect(host='localhost', user='root', passwd='root123', database='test')
cursor = db.cursor()

student_table()
print("\n")

attendacne_table()
print("\n")

joined_table()



