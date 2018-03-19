import socket
s = socket.socket()
host = socket.gethostname()
port = 4422
s.bind(("", port))

f = open('secrets.dat', 'wb')
s.listen(1)

print "Waiting for connection..."

while True:
    c, addr = s.accept()
    print "Connection made from", addr
    print "Receiving..."

    msg = c.recv(1024)
    f.write(msg)

    f = open('secrets.dat', 'rb')
    msg = f.read(1024)

    f.close()
    break

print msg
print("Done Recieving")
