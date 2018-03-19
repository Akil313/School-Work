import socket
import Crypto
from Crypto.PublicKey import RSA
from Crypto.Cipher import DES

s = socket.socket()
host = socket.gethostname()
port = 4422
s.connect((host, port))

rsaKey = RSA.generate(1024)

rsaPrivateObj = rsaKey
rsaPublicObj = rsaKey.publickey()
rsaPrivateKey = rsaKey.exportKey(format='PEM')
rsaPublicKey = rsaKey.publickey().exportKey(format='PEM')

key = 'I am Dog'

des = DES.new(key)

rsaPrivateKey += ' ' * (8 - len(rsaPrivateKey) % 8) # Pad the key if needed

encryptedRSAPrivateKey = des.encrypt(rsaPrivateKey)

privateKey = des.decrypt(encryptedRSAPrivateKey).strip()


f = open("privatekey.dat", 'wb')
f.write(encryptedRSAPrivateKey)
f.close()

f = open("publickey.dat", 'wb')
f.write(rsaPublicKey)
f.close()

f = open("NoWar.dat", 'rb')
msg = f.read(1024)
f.close()

f = open("secrets.dat", 'wb')
encRSAmsg = rsaPublicObj.encrypt(msg, "random")[0]
f.write(encRSAmsg)
f.close()

print "Sending..."
print encRSAmsg
s.send(encRSAmsg)

print "Done Sending"
