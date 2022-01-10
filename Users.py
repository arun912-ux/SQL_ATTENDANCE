import justForPrint as jp
from init_sql import cursor as cc
import operations as op
import icecream as ic


def insertIntoStudentTable(uid):
    name = input("Enter Name: ")
    roll = (input("Enter ID: "))
    cc.execute("insert into student values ('{0}', {1}, '{2}');".format(uid, roll,name))
    op.addAttendance(uid)


def deleteUser():

    cc.execute("select * from student where uid like '{0}'".format(id))
    r=cc.fetchall()
    cc.execute("delete from student where student.uid={0};".format(id))
    print("Deleted: ", r)


def checkIfIncomingIdPresentInStudentsTable(uid): #uid
    cc.execute("select id from student where uid like {0} ;".format(uid))
    r = cc.fetchall()
    print("Student ID: ", end=''), jp.printline(r)

    if len(r) == 0:
        #print('insertIntoStudentTable')
        print("No user found\tDo you want to add new User!?")
        insertIntoStudentTable(uid) #uid

        # r = [1]

    if len(r) != 0:
        #print('op.addAttendance')
        op.addAttendance(uid)



