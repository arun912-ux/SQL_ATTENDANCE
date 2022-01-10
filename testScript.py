import time
import Users as us
import serial_bluetooth as sb

#
# st = 103
# us.checkIfIncomingIdPresentInStudentsTable(st)
#
while(1):
    sb.serialRead()
    time.sleep(0.1)

