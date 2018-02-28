#Server
def ceasarCipher(msg, key):
    msg = msg.lower()
    LETTERS = 'abcdefghijklmnopqrstuvwxyz'
    translated = ''
    
    for symbol in msg:
        if symbol in LETTERS:
            num = LETTERS.find(symbol)
            num -= key

            if num >= len (LETTERS):
                num -= len(LETTERS)
            elif num < 0:
                num += len(LETTERS)

            num = num%len(LETTERS)
            translated += LETTERS[num]
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

    for rfKey in range(2, 100):
        for cKey in range(100):
            trialMsg = doubleCipherDec(msg, cKey, rfKey)

            if(msgAcc(trialMsg) >= 40):
                return trialMsg, msgAcc(trialMsg), rfKey, cKey

    return None, -1, -1, -1

f = open('Trump.dat', 'rb')
msg = f.read(1024).decode('utf-8')

decMsg, acc, rfKey, cKey = trials(msg)

if decMsg is not None:
    print("Message is:")
    print (decMsg)
else:
    print ("The message could not be decoded accurately")
