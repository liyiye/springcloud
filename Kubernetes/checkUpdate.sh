#!/bin/bash
#传入的第一个变量是deployment的名称，第二个变量是要检查的镜像的名称
totalnum=`kubectl get deployment $1 -o=jsonpath='{.spec.replicas}'`
echo "总的镜像的数量：${totalnum}"
echo "更新的版本：${2}"
checkcount=20
while [ $checkcount -gt 0 ];
do

sleep 1s

count=`kubectl get pods -o=jsonpath='{.items[*].spec.containers[*].image}' |grep -o $2 |wc -l`
echo "更新的数量：${count}"
if [ $totalnum -eq $count ];
then
    exit 0;
else
   ((checkcount=checkcount-1))
fi
done

if [ $checkcount  -eq 0  ];
then
 echo "发布失败，进行回滚,失败原因："
 echo `kubectl get pods -o=jsonpath='{.items[*].status.containerStatuses[*].state.*.message}'`
  echo "进行回滚："
 `kubectl rollout undo deployment/$1`
  checkcount=20
while [ $checkcount -gt 0 ];
do
sleep 1s
count=`kubectl get pods -o=jsonpath='{.items[*].status.containerStatuses[*].state}'|grep -o running |wc -l`
echo "回滚的数量：${count}"
if [ $totalnum -eq $count ];
then
    echo "回滚成功"
    exit 1;
else
   ((checkcount=checkcount-1))
fi
done
fi