npm i
ng build --prod --aot
docker build --tag 172.30.1.1:5000/simple-site-project/home-fe:latest .
docker push 172.30.1.1:5000/simple-site-project/home-fe
oc new-app --docker-image=172.30.1.1:5000/simple-site-project/home-fe --name=home-fe
oc expose svc/home-fe --port=8080
