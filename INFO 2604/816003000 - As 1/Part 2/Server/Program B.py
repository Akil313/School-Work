#816003000 - Server
#This script accepts a file from a client and saves it in a dat file called trump
#It then reads the contents of the dat file which contains an encrypted message.
#The message is then decrypted by checking the message for key words
#against all possible keys for the double cipher within a range until an accurate
#decryption can be found. The decrypted message is then displayed for the user.
#If there is no accurate decryption of the message, a message is printed that the
#message could not be accurately decrypted.
def ceasarCipher(msg, key):
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

def rfCipher(msg, key):
    fence = []
    count = 0
    inc = 1
    translated = ''
    dec = ''
    
    for x in range(key):
        fence.append([])

    msgCpy = msg
    dec = ''
    rev = [[0 for x in range(len(msg))] for y in range(key)]

    for x in range(len(msg)):
        if count == key-1 :
            inc = -1
        elif count == 0:
            inc = 1
            
        rev[count][x] = '*'
        count += inc

    for x in range(len(rev)):
        for y in range(len(rev[x])):
            if(rev[x][y] is '*'):
                rev[x][y] = msgCpy[0]
                msgCpy = msgCpy[1:]

    count = 0
    for x in range(len(msg)):
        if count == key-1 :
            inc = -1
        elif count == 0:
            inc = 1

        dec += rev[count][x]
        count += inc

    return dec

def doubleCipherDec(msg, cKey, rfKey):
    trans = ''
    
    
    trans = ceasarCipher(msg, cKey)
    trans = rfCipher(trans, rfKey)

    return trans

def msgAcc(msg):
    keyWords = ['trump', 'war', 'peace', 'death', 'kill']
    accuracy = 0

    for key in keyWords:
        if msg.find(key) != -1:
            accuracy += (1/(len(keyWords)))* 100

    return accuracy

def trials(msg):
    trialMsg = ""

    for rfKey in range(2, len(msg)):
        for cKey in range(26):
            trialMsg = doubleCipherDec(msg, cKey, rfKey)

            if(msgAcc(trialMsg) > 60):
                return trialMsg, msgAcc(trialMsg), rfKey, cKey

    return None, -1, -1, -1

import socket
s = socket.socket()
host = socket.gethostname()
port = 1738
s.bind(("",port))

f = open('Trump.dat', 'wb')
s.listen(1)

print ("Waiting for connection...")

while True:
    c, addr = s.accept()
    print ("Connection made from", addr)
    print ("Receiving...")

    msg = c.recv(1024)
    f.write(msg)

    f = open('Trump.dat', 'rb')
    msg = f.read(1024)
    encMsg = msg.decode('utf-8')
    
    print()
    decMsg, acc, rfKey, cKey = trials(encMsg)

    if decMsg is not None:
        print ("DECODED MESSAGE")
        print ()
        print (decMsg)
    else:
        print ("The message could not be decoded accurately")
        
    f.close()
    break

print()
print ("Done Recieving")
c.send(bytes('Thank you for connecting', 'utf-8'))
c.close()
