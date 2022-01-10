import operations as op
import Users as us


def switch(n):
    if n==1:
        op.student_table()
    elif n==2:
        op.joined_table()
    elif n==3:
        us.insertIntoStudentTable(id)
    elif n==4:
        us.deleteUser()
    #return


print("1. Student Table"), print("2. Attendance with Student IDs (Join)"),
print("3. New Student"), print("4. Remove Student")

n = int(input())

switch(n)
print()




