#816003000 - Akil Hosang
#Program B - Server
#This program is responsible for recieving all the encrypted files and using the secret key obtained from the Diffie Hellman to descrypt all necessary variables.
import socket
import Crypto
import pickle
from Crypto.PublicKey import RSA
from Crypto.Cipher import DES

#getSharedKey is the diffieHellman method of sharing a secret key to program A
def getSharedKey():
    p = 13
    q = 23
    progBSecret = 38
    B = (p**progBSecret)%q

    A = int(c.recv(1024))

    sharedSecretKey = (A**progBSecret)%q

    c.send(str(B))

    return A, B, sharedSecretKey

#encCeasarCipher is the Ceasar Cipher method but only for decryption.
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
                
            elif symbol in ULETTERS:
                num = ULETTERS.find(symbol)
                
                num -= key

                if num >= len (ULETTERS):
                    num -= len(ULETTERS)
                elif num < 0:
                    num += len(ULETTERS)

                translated += ULETTERS[num]
            else:
                translated+=symbol
        else:
            translated += symbol

    return translated

#Initializing server variables
s = socket.socket()
host = socket.gethostname()
port = 1717
s.bind(("", port))

s.listen(1)

c, addr = s.accept()

A, B, sharedSecretKey = getSharedKey()

#Recieving ceasar encrypted variables
ceasarEncRSAMsg = c.recv(1024)
c.send("Ceasar Encrypted RSA Message Recieved")

ceasarEncDESKey = c.recv(8)
c.send("Ceasar Encrypted DES Key Recieved")

ceasarEncPrivateKey = c.recv(1024)
c.send("Ceasar Encrypted RSA Message Recieved")

c.close()

#Decryption of ceasear encrypted variables
encRSAMsg = decCeasarCipher(ceasarEncRSAMsg, sharedSecretKey)
key = decCeasarCipher(ceasarEncDESKey, sharedSecretKey)
encRSAPrivateKey = decCeasarCipher(ceasarEncPrivateKey, sharedSecretKey)

des = DES.new(key)

#Decryption of encrypted RSA private key using the DES key
privateKey = des.decrypt(encRSAPrivateKey)

privateKey = RSA.importKey(privateKey)

#Decryption of encrypted RSA message using privateKey
decrypted = privateKey.decrypt(encRSAMsg)

print decrypted

