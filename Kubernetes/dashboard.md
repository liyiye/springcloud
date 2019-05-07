#登陆dashboard的方法
####执行下面的命令：
kubectl create serviceaccount dashboard -n default

kubectl create clusterrolebinding dashboard-admin -n default --clusterrole=cluster-admin  --serviceaccount=default:dashboard

获取登陆的token

kubectl get secret $(kubectl get serviceaccount dashboard -o jsonpath="{.secrets[0].name}") -o jsonpath="{.data.token}" | base64 --decode