#816003000 - Client
#This script takes a message in the dat file called NoWar addressed the president
#of the United States. The message is stored, encrypted using the double cipher method
#and the encoded message is stored in a dat file called trump.
#The file is then sent to a server for decrypting the message.

def ceasarCipher(msg, key):
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

def rfCipher(msg, key):
    fence = []
    count = 0
    inc = 1
    translated = ''
    dec = ''
    
    for x in range(key):
        fence.append([])

    for symbol in msg:
        if count == key-1 :
            inc = -1
        elif count == 0:
            inc = 1
            
        fence[count].append(symbol)
        count += inc

    for rail in fence:
        for symbol in rail:
            translated += symbol

    return translated

def doubleCipher(msg, cKey, rfKey):
    trans = ''
    trans = rfCipher(msg, rfKey)
    trans = ceasarCipher(trans, cKey)
    return trans


import socket
s = socket.socket()
host = socket.gethostname()
port = 1738
s.connect((host, port))

noWar = open('NoWar.dat', 'rb')

print ('Sending...')

msg = noWar.read(1024)

noWar.close()

cKey = int(input("Enter the key for the ceasar cipher: "))
rfKey = int(input("Enter the key for the rail fence cipher: "))

while cKey < 0 or rfKey < 1:
    print("Sorry that was an invalid value for cKey or rfKey. Try again.\n")

    cKey = int(input("Enter the key for the ceasar cipher: "))
    rfKey = int(input("Enter the key for the rail fence cipher: "))

encMsg = doubleCipher(msg.decode('utf-8'), cKey, rfKey)

trump = open('Trump.dat', 'wb')

trump.write(bytes(encMsg, 'utf-8'))

trump.close()

trump = open('Trump.dat', 'rb')

encMsg = trump.read(1024).decode('utf-8')

while msg:
    print('Sending...')
    s.send(bytes(encMsg, 'utf-8'))
    msg = trump.read(1024)

trump.close()
print ("Done sending")
s.shutdown(socket.SHUT_WR)
print(s.recv(1024).decode('utf-8'))
s.close()
