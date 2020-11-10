npm i
ng build --prod --aot
docker build --tag default-route-openshift-image-registry.apps-crc.testing/simple-site/home-fe:latest .
docker push default-route-openshift-image-registry.apps-crc.testing/simple-site/home-fe
oc new-app --docker-image=image-registry.openshift-image-registry.svc:5000/simple-site/home-fe --name=home-fe
oc expose svc/home-fe --port=8080
