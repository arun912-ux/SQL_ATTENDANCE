import justForPrint as jp
from init_sql import cursor as cc
import datetime


# set out time.
def out_time(uid): #uid
    #id = 102

    cc.execute("select * from attendance where uid ={0} and outtime is null and intime is not null;".format(uid))
    table = cc.fetchall()
    # jp.printline(table)
    try:
        if len(table) == 1:
            cc.execute("update attendance set outtime = current_time where uid = {0};".format(uid))
            print("Logged Out at {} !".format(datetime.datetime.now().strftime("%H:%M:%S")))

    except:
        print('error')

    return



# set in time.
def in_time(uid): #uid
    #id = 102
    cc.execute("insert into attendance (uid, intime) values ({0}, current_time);".format(uid))
    print("Logged In at {}".format(datetime.datetime.now().strftime("%H:%M:%S")))
    return



def addAttendance(uid): #uid
    cc.execute("select * from attendance where uid = {0};".format(uid))  #uid
    r = cc.fetchall()
    # print(r)
    try:
        if len(r) == 0 :
            in_time(uid)
        else:

            # print("record present\nouttime")
            out_time(uid)

    except :
        print("error")





