#816003000 - Akil Hosang
#Client
#This program is responsible for the multiple layers of encryption using RSA, DES and DiffieHellman on the secret message to send to program B.
import socket
import Crypto
import pickle
from Crypto.PublicKey import RSA
from Crypto.Cipher import DES

#getSharedKey is the diffieHellman method of sharing a secret key to program B
def getSharedKey():
    p = 13
    q = 23

    progASecret = 17

    A = (p**progASecret)%q
    s.send(str(A))

    B = int(s.recv(1024))
    sharedSecretKey = (B**progASecret)%q

    return A, B, sharedSecretKey

#encCeasarCipher is the Ceasar Cipher method but only for encryption.
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
                
            elif symbol in ULETTERS:
                num = ULETTERS.find(symbol)
                num += key

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
s.connect((host, port))

f = open("NoWar.dat", 'rb')

msg = f.read(1024)
f.close()

#Generation of RSA objects
rsaKey = RSA.generate(1024)
rsaPublicObj = rsaKey.publickey()
rsaPrivateKey = rsaKey.exportKey()
rsaPublicKey = rsaPublicObj.exportKey()

#DES key 
key = 'I am Dog'
des = DES.new(key)

rsaPrivateKey += ' ' * (8 - len(rsaPrivateKey) % 8) # Pad the key if needed

encRSAPrivateKey = des.encrypt(rsaPrivateKey)

encRSAMsg = rsaPublicObj.encrypt(msg, 32)[0]

#Saving private and public key to dat file
f = open("privatekey.dat", 'wb')
f.write(encRSAPrivateKey)
f.close()

f = open("publickey.dat", 'wb')
f.write(rsaPublicKey)
f.close()

A, B, sharedSecretKey = getSharedKey()

#Encrypting encrypted RSA message, encrypted DES key and encrypted private key with ceasar cipher
ceasarEncRSAMsg = encCeasarCipher(encRSAMsg, sharedSecretKey)
ceasarEncDESKey = encCeasarCipher(key, sharedSecretKey)
ceasarEncPrivateKey = encCeasarCipher(encRSAPrivateKey, sharedSecretKey)

#Sending ceasar encrypted variables to program B
s.send(ceasarEncRSAMsg)
s.recv(1024)
s.send(ceasarEncDESKey)
s.recv(8)
s.send(ceasarEncPrivateKey)
s.recv(1024)

