from time import sleep
import serial
import Users as us

# print(serial.__file__)

sP = serial.Serial(port="COM7", baudrate=9600, bytesize=8,
                   timeout=2, stopbits=serial.STOPBITS_ONE, parity=serial.PARITY_NONE)


def serialRead():
    if sP:

        if sP.in_waiting > 0:
            st = sP.readline().strip()
            try:
                st = int(str(st)[2:-1])
                print("ID: ", end=''), print(str(st))

                us.checkIfIncomingIdPresentInStudentsTable(st)

            except Exception as e:
                e

            print("\n"*4)



