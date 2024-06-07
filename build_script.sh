#!/bin/sh

./gradlew build -x test

eval $(minikube docker-env)
docker build -t crud-restapi-challenge:latest .
helm uninstall crud-restapi-challenge

helm uninstall postgresql
kubectl delete pvc data-postgresql-0

helm install postgresql helm/postgresql
helm install crud-restapi-challenge helm/crud-restapi-challenge