#decrypt function for rail fence cipher
def railFenceDecryption(cipherText, railFenceKey):

    railFenceKey = int(railFenceKey)
    decryptedText = ""
    matrix = [["" for i in range(len(cipherText))] for j in range(railFenceKey)]
    index = 0
    verticalDirection = 1

    for currentRow in range(0, len(matrix)):
        row = 0

        for col in range(0, len(matrix[row])):
            if row == currentRow:
                matrix[row][col] = matrix[row][col] + cipherText[index]
                index = index + 1
                
            if row + verticalDirection < 0 or row + verticalDirection >= len(matrix):
                verticalDirection = verticalDirection * -1
                
            row = row + verticalDirection
            
    transpose = [[0 for j in range(len(matrix))] for i in range(len(matrix[0]))]
                 
    for i in range (len(matrix)):
        for j in range (len(matrix[0])):
            transpose[j][i] = matrix[i][j]

    x=0
    decipheredText = ""
    while x<len(transpose):
               decipheredText = decipheredText + "".join(transpose[x])
               x = x + 1            

    return decipheredText


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


#decrypt function for double cipher
def doubleCipherDecrypt(message, railFenceKey, caesarKey):
    caesarDecrypt = caesarCipher(message, caesarKey, 'decrypt')
    railFenceDecrypt = railFenceDecryption(caesarDecrypt, railFenceKey)
    return railFenceDecrypt


def decryptLetter():
    f = open('Trump.dat', 'rb')
    encryptedMessage = f.read(1024)
    
    """recognisableTextList = ['president', 'donald', 'trump', 'war', 'nuclear', 'threat', 'west', 'north', 'korea',
                         'power', 'usa', 'citizens', 'united', 'states', 'america', 'soldier', 'civilians',
                         'people', 'death']"""
    recognisableTextList = ['president', 'war', 'trump', 'violence', 'america', 'political', 'people', 'death', 'peace']
    numWordsInRecognisableTextList = len(recognisableTextList)

    highestNumWordsFound = 0
    for i in range (0, 50):
        for j in range (2, 50):
            caesarKey = i
            railFenceKey = j
            
            decryptedMessage = doubleCipherDecrypt(encryptedMessage.decode(), railFenceKey, caesarKey)
            print ("Caesar Key: ", caesarKey)
            print ("Rail Fence Key: ", railFenceKey)
            print ("Decrypted message: ")
            print ("")
            print (decryptedMessage)
            print ("")
            
            messageTextList = (decryptedMessage.lower()).split(" ")
            #print (messageTextList)
            
            numWordsFound = 0
            for word in recognisableTextList:
                if any(word in s for s in messageTextList):
                    numWordsFound = numWordsFound + 1
                    print ("Number of words found: ", numWordsFound, " ", word.lower())

            if (numWordsFound >= numWordsInRecognisableTextList/2):
                print ("")
                print ("********LETTER DECRYPTED********")
                print ("")
                print (decryptedMessage)
                print ("")
                print ("********************************")
                return True

    print ("")        
    print ("DECRYPTION FAILED...")
    return False


#main
import socket
s = socket.socket()
host = socket.gethostname()
port = 12318
s.bind((host, port))

f = open('Trump.dat', 'wb')

s.listen(1)

while True:
    print ("Waiting for connection...")
    c, addr = s.accept()
    print ("Got connection from ", addr)
    print ("")
    print ("Receiving encrypted message...")
    print ("")

    encryptedMessage = (c.recv(1024))
    print ("Encrypted message: ")
    print (encryptedMessage)
    print ("")
    f.write(encryptedMessage)
    f.close()

    result = decryptLetter()
    f.close()
    c.send(bytes(("BYE BYE"), "utf-8"))
    print ("BYE BYE")

input ()    
c.close()
