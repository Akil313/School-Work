import socket
import Crypto
from Crypto.PublicKey import RSA
from Crypto.Cipher import DES

def getSharedKey():
    p = 13
    q = 23
    progBSecret = 38
    B = (p**progBSecret)%q

    A = int(c.recv(1024))

    sharedSecretKey = (A**progBSecret)%q

    c.send(str(B))
    print("Done Recieving")

    return A, B, sharedSecretKey

def decCeasarCipher(msg, key):
    LETTERS = 'abcdefghijklmnopqrstuvwxyz'
    ULETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    translated = ''
    
    for symbol in msg:
        if symbol.isalpha():
            if symbol in LETTERS:
                num = LETTERS.find(symbol)
                num -= key

                if num >= len (LETTERS):
                    num -= len(LETTERS)
                elif num < 0:
                    num += len(LETTERS)

                translated += LETTERS[num]
                
            else:
                num = ULETTERS.find(symbol)
                
                num -= key

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
s.bind(("", port))

f = open('secrets.dat', 'wb')
s.listen(1)

print "Waiting for connection..."

c, addr = s.accept()
print "Connection made from", addr
print "Receiving..."

encRSAMsg = c.recv(1024)
f.write(encRSAMsg)

f = open('secrets.dat', 'rb')
encRSAMsg = f.read(1024)

f.close()

A, B, sharedSecretKey = getSharedKey()

print "Recieving..."

ceasarEncRSAMsg = c.recv(1024)
c.send("Ceasar Encrypted RSA Message Recieved")
ceasarEncDESKey = c.recv(1024)
c.send("Ceasar Encrypted DES Key Recieved")
ceasarEncPrivateKey = c.recv(1024)
c.send("Ceasar Encrypted RSA Message Recieved")

print "Done Recieving"
c.close()


encRSAMsg = decCeasarCipher(ceasarEncRSAMsg, sharedSecretKey)
key = decCeasarCipher(ceasarEncDESKey, sharedSecretKey)
encRSAPrivateKey = decCeasarCipher(ceasarEncPrivateKey, sharedSecretKey)

print "\n\nTHE RSA MSG IS \n", encRSAMsg
print "\nTHE DES KEY IS \n", key
print "\nTHE PRIVATE KEY IS \n", encRSAPrivateKey

des = DES.new(key)

privateKey = des.decrypt(encRSAPrivateKey)

print privateKey

privateRSAKey = RSA.importKey(privateKey)

decrypted = privateRSAKey.decrypt(encRSAMsg)

print decrypted

