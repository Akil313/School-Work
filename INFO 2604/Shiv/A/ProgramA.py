#encrypt function for rail fence cipher
def railFenceEncryption(plainText, railFenceKey):

    
    railFenceKey = int(railFenceKey)
    cipherText = ""
    matrix = [["" for i in range(len(plainText))] for j in range(railFenceKey)]
    verticalDirection = 1
    row = 0
    col = 0
    x = 0

    while x<len(plainText):

           if row + verticalDirection < 0 or row + verticalDirection == len(matrix):
               verticalDirection = verticalDirection * -1

           matrix[row][col] = plainText[x]
           row = row + verticalDirection
           col = col + 1
           x = x + 1

    x=0

    while x<len(matrix):
               cipherText = cipherText + "".join(matrix[x])
               x = x + 1
    return cipherText


#encrypt and decrypt function for caesar cipher
def caesarCipher(message, caesarKey, mode):

    caesarKey = int(caesarKey)
    lowercaseLetters = "abcdefghijklmnopqrstuvwxyz"
    uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    translatedMessage = ""
    
    for character in message:
        if character in lowercaseLetters or character in uppercaseLetters:
            if character in lowercaseLetters:
                letterSet = lowercaseLetters
            else:
                letterSet = uppercaseLetters

            position = letterSet.find(character)
            
            if mode == 'encrypt':
                position = position + caesarKey
            elif mode == 'decrypt':
                position = position - caesarKey
            if position >= len(letterSet):
                position = position - len(letterSet)
            elif position < 0:
                position = position + len(letterSet)
                
            translatedMessage = translatedMessage + letterSet[position]

        else:
            translatedMessage = translatedMessage + character

    return translatedMessage


#encrypt function for double cipher
def doubleCipherEncrypt(plainText, railFenceKey, caesarKey):
    railFenceCipherText = railFenceEncryption(plainText, railFenceKey)
    caesarCipherText = caesarCipher(railFenceCipherText, caesarKey, 'encrypt')
    return caesarCipherText


#main
import socket
s = socket.socket()
host = socket.gethostname()
port = 12318
s.connect((host, port))


f1 = open('NoWar.dat', 'rb')
print ("Reading NoWar.dat...")
letter = f1.read(1024)

print ("")
railFenceKey = input("Enter Rail Fence Key: ")
caesarKey = input("Enter Caesar Key: ")

print ("")
print ("Encrypting message...")
doubleCipherText = doubleCipherEncrypt(letter.decode(), railFenceKey, caesarKey)

f2 = open('Trump.dat', 'wb')
print ("Writing to Trump.dat...")
f2.write(bytes(str(doubleCipherText), "utf-8"))
f2.close()

f2 = open('Trump.dat', 'rb')
letter = f2.read(1024)
print (letter)

while letter:
    print ("Sending encrypted message to server...") 
    s.send(letter)
    print ("Message sent")
    print ((s.recv(1024)).decode())
    letter = f2.read(1024)

f2.close()
s.shutdown(socket.SHUT_WR)
s.close()
