import subprocess
import ipaddress

alive = []
subnet = ipaddress.ip_network('192.168.1.0/23', strict=False)
for i in subnet.hosts():
    i = str(i)
    retval = subprocess.call(["ping", "-c1", "-n", "-i0.1", "-W1", i])
    if retval == 0:
        alive.append(i)
for ip in alive:
    print(ip + " is alive") 