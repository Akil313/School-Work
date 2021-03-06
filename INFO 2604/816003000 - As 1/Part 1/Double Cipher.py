#816003000 - Double Cipher
#This program is used to encrypt or decrypt messages using the double cipher method
#which is a combination of the Ceasar Cipher and the Rail Fence Cipher
#When encrypting the message to encode, the key for the ceasar cipher and the key
#for the rail fence cipher is required and the same goes for decyphering except
#instead of the message to encrypt, the already encrypted message is required.

def ceasarCipher(msg, mode, key):
    msg = msg.lower()
    LETTERS = 'abcdefghijklmnopqrstuvwxyz'
    translated = ''
    
    for symbol in msg:
        if symbol in LETTERS:
            num = LETTERS.find(symbol)
            if mode == 'encrypt':
                num += key
            elif mode == 'decrypt':
                num -= key

            if num >= len (LETTERS):
                num -= len(LETTERS)
            elif num < 0:
                num += len(LETTERS)

            translated += LETTERS[num]
        else:
            translated += symbol

    return translated

def rfCipher(msg, mode, key):
    fence = []
    count = 0
    inc = 1
    translated = ''
    dec = ''
    
    for x in range(key):
        fence.append([])

    if(mode is 'encrypt'):
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

    elif(mode is 'decrypt'):
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
    return "Invalid mode"

def doubleCipher(msg, mode, cKey, rfKey):
    trans = ''
    
    if mode == 'encrypt':
        trans = rfCipher(msg, mode, rfKey)
        trans = ceasarCipher(trans, mode, cKey)
    elif mode == 'decrypt':
        trans = ceasarCipher(msg, mode, cKey)
        trans = rfCipher(trans, mode, rfKey)

    return trans

def menu():
    message = ""
    
    print("1) Encrypt\n" +
              "2) Decrypt\n" +
              "3) Exit")
    
    choice = int(input())
    
    while(choice not in [1, 2, 3]):
        print("Sorry that was an invalid choice. Try again.\n")
        
        print("1) Encrypt\n" +
              "2) Decrypt\n" +
              "3) Exit")
        
        choice = int(input())

    if choice == 1:
        message = input("Enter the message to encrypt: ")
        mode = 'encrypt'
    elif choice == 2:
        message = input("Enter the message to decrypt: ")
        mode = 'decrypt'
    elif choice == 3:
        exit(0)

    cKey = int(input("Enter the key for the ceasar cipher: "))
    rfKey = int(input("Enter the key for the rail fence cipher: "))

    if cKey < 0 or rfKey < 1:
        print("Sorry that was an invalid value for cKey or rfKey. Try again.\n")

        cKey = int(input("Enter the key for the ceasar cipher: "))
        rfKey = int(input("Enter the key for the rail fence cipher: "))
    
    print (doubleCipher(message, mode, cKey, rfKey))


print("Welcome to the DOUBLE CIPHER MACHINE")
while(1):
    menu()
