import socket
import Crypto
from Crypto.PublicKey import RSA
from Crypto.Cipher import DES

def getSharedKey():
    p = 13
    q = 23

    progASecret = 17

    A = (p**progASecret)%q

    print "Sending..."
    s.send(str(A))

    B = int(s.recv(1024))
    print "Done Recieving"
    sharedSecretKey = (B**progASecret)%q

    return A, B, sharedSecretKey

def encCeasarCipher(msg, key):
    LETTERS = 'abcdefghijklmnopqrstuvwxyz'
    ULETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    translated = ''
    
    for symbol in msg:
        if symbol.isalpha():
            if symbol in LETTERS:
                num = LETTERS.find(symbol)
                num += key

                if num >= len (LETTERS):
                    num -= len(LETTERS)
                elif num < 0:
                    num += len(LETTERS)

                translated += LETTERS[num]
                
            else:
                num = ULETTERS.find(symbol)
                num += key

                if num >= len (ULETTERS):
                    num -= len(ULETTERS)
                elif num < 0:
                    num += len(ULETTERS)

                translated += ULETTERS[num]
        else:
            translated += symbol

    return translated

s = socket.socket()
host = socket.gethostname()
port = 1717
s.connect((host, port))

f = open("NoWar.dat", 'rb')
msg = f.read(1024)
f.close()

rsaKey = RSA.generate(1024)

rsaPrivateObj = rsaKey
rsaPublicObj = rsaKey.publickey()
rsaPrivateKey = rsaKey.exportKey(format='PEM')
rsaPublicKey = rsaKey.publickey().exportKey(format='PEM')

key = 'I am Dog'

des = DES.new(key)

rsaPrivateKey += ' ' * (8 - len(rsaPrivateKey) % 8) # Pad the key if needed

encRSAPrivateKey = des.encrypt(rsaPrivateKey)

#privateKey = des.decrypt(encryptedRSAPrivateKey).strip()

encRSAMsg = rsaPublicObj.encrypt(msg, "random")[0]

f = open("privatekey.dat", 'wb')
f.write(encRSAPrivateKey)
f.close()

f = open("publickey.dat", 'wb')
f.write(rsaPublicKey)
f.close()

f = open("secrets.dat", 'wb')
f.write(encRSAMsg)
f.close()

print "Sending..."
s.send(encRSAMsg)

print "Done Sending"

A, B, sharedSecretKey = getSharedKey()

ceasarEncRSAMsg = encCeasarCipher(encRSAMsg, sharedSecretKey)
ceasarEncDESKey = encCeasarCipher(key, sharedSecretKey)
ceasarEncPrivateKey = encCeasarCipher(encRSAPrivateKey, sharedSecretKey)

s.send(bytes(ceasarEncRSAMsg))
print s.recv(1024)
s.send(bytes(ceasarEncDESKey))
print s.recv(1024)
s.send(bytes(ceasarEncPrivateKey))
print s.recv(1024)

print "\n\nTHE RSA MSG IS \n", encRSAMsg
print "\nTHE DES KEY IS \n", key
print "\nTHE PRIVATE KEY IS \n", encRSAPrivateKey
