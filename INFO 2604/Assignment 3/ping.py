# -*- coding: utf-8 -*-
"""
Created on Sun Apr  8 23:43:48 2018

@author: Akil313
"""

import subprocess
import ipaddress
from subprocess import Popen, PIPE

network = ipaddress.ip_network('192.168.0.0/24')

for i in network.hosts():
    i = str(i)
    toping = Popen(['ping', '-n', '3', i, '-w', '500'])
    output = toping.communicate()[0]
    hostalive = toping.returncode
    if hostalive == 0:
        print (i, "is reachable")
    else:
        print (i, "is unreachable")