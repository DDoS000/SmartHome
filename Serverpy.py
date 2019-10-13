import socket
import random

def get_ip_address():
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    s.close
    return s.getsockname()[0]

host=get_ip_address()
port=8888
counts = 0
tempin = random.randrange(16,40)
tempout = random.randrange(16,40)
data=""

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((host, port))
    s.listen()
    while True:
        # if data == "GTemp":
        #     data = ""
        #     s.send(str(tempin).encode('utf-8'))
            # s.send((str(tempin)+":"+str(tempout)).encode('utf-8'))
        if counts != 0:
            client, addr = s.accept()
            data=client.recv(1024).decode('utf-8')
            print(data)
        else:
            print("Waiting for client connections on "+str(host))
            client, addr = s.accept()
            print("Server : Client Connet")
            data=client.recv(1024).decode('utf-8')
            print("Client : ",data)
            counts+=1
    s.close()

# s.send(data.encode('utf-8'))