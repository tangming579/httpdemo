import socket

def start_server(host='127.0.0.1', port=12345):
    # 创建 TCP 套接字
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))
    server_socket.listen(1)  # 监听连接，最多允许 1 个连接

    print(f"Server is listening on {host}:{port}")

    while True:
        # 接受客户端连接
        client_socket, client_address = server_socket.accept()
        print(f"Connection established with {client_address}")

        try:
            while True:
                # 接收数据
                data = client_socket.recv(1024)
                if not data:
                    break  # 如果客户端断开连接，退出循环
                print(f"Received: {data.decode().strip()}")
        except Exception as e:
            print(f"Error: {e}")
        finally:
            # 关闭客户端套接字
            client_socket.close()
            print(f"Connection with {client_address} closed")

if __name__ == "__main__":
    start_server()
