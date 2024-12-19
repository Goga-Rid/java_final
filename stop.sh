#!/bin/bash

PORT=8090

PID=$(lsof -t -i:$PORT)

if [ -z "$PID" ]; then
    echo "Нет процесса, использующего порт $PORT."
else
    echo "Найден процесс с PID $PID, использующий порт $PORT."
    # Завершение процесса по PID
    kill -9 $PID
    echo "Процесс с PID $PID был завершен."
fi
