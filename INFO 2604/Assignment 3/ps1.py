# -*- coding: utf-8 -*-
"""
Simple Port Scanner
https://stackoverflow.com/questions/26174743/making-a-fast-port-scanner?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa

@author: Akil313
"""

import socket
from timeit import default_timer as timer


ip = "64.234.215.57"
s = socket.socket(2, 1) #socket.AF_INET, socket.SOCK_STREAM

def porttry(ip, port):
    try:
        s.connect((ip, port))
        return True
    except:
        return None

start = timer()

for port in range(0, 100):
    value = porttry(ip, port)
    if value == None:
        print("Port not opened on %d" % port)
    else:
        print("Port opened on %d" % port)
    
end = timer()

print (int(end - start), "seconds")
print ("Done")