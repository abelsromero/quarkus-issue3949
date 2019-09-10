#!/bin/bash
docker run \
  --name c4p_db \
  -p 5432:5432 \
  -e POSTGRES_DATABASE=c4p \
  -e POSTGRES_USER=c4p \
  -e POSTGRES_PASSWORD=ts4th0ggu4 \
  --rm postgres:11-alpine
#  -v ${pwd}/data:/var/lib/postgresql/data \
